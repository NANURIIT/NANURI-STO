package com.nanuri.rams.business.assessment.tb06.tb06020;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nanuri.rams.business.common.dto.IBIMS103BDTO;
import com.nanuri.rams.business.common.mapper.IBIMS103BMapper;
import com.nanuri.rams.business.common.mapper.IBIMS201BMapper;
import com.nanuri.rams.business.common.mapper.IBIMS209BMapper;
import com.nanuri.rams.business.common.mapper.IBIMS212BMapper;
import com.nanuri.rams.business.common.vo.IBIMS201BVO;
import com.nanuri.rams.business.common.vo.TB06010SVO;
import com.nanuri.rams.com.security.AuthenticationFacade;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class TB06020ServiceImpl implements TB06020Service {

	private final IBIMS103BMapper ibims103bMapper;
	private final IBIMS201BMapper ibims201bMapper;
	private final IBIMS212BMapper ibims212bMapper;
	private final IBIMS209BMapper ibims209bMapper;

	@Autowired
	private AuthenticationFacade facade;

	// 대출계약 승인정보관리 조회
	@Override
	public TB06010SVO getCnfrncDealInfo(TB06010SVO searchParam) {
		return ibims103bMapper.selectTB06010SVO(searchParam);
	}

	// 종목정보 등록
	@Override
	@Transactional
	public int regPrdtCd(IBIMS201BVO param) {

		int result = 0;
		param.setApvlDt(LocalDate.now().toString().replace("-", ""));
		String empNo = facade.getDetails().getEno();

	  //if((param.getPrdtCd() == null)||("".equals(param.getPrdtCd()))) {
		if(param.getRegDvsn().equals("I")) {
			param.setHndEmpno(empNo);
			//param.setPrdtCd(ibims201bMapper.getPrdtCdSq(param.getPageDcd()));
			IBIMS201BVO ibims201bvo = ibims201bMapper.selectOnlyOneIBIMS201B(param.getPrdtCd());
			if(ibims201bvo == null) {
				result = ibims201bMapper.regPrdtCd(param);
				if (result != 0) {
					IBIMS103BDTO s103b = new IBIMS103BDTO();
					s103b.setDealNo(param.getDealNo());
					s103b.setMtrDcd(param.getMtrDcd());
					s103b.setJdgmDcd(param.getJdgmDcd());
					s103b.setHndEmpno(facade.getDetails().getEno());
	
					s103b = ibims103bMapper.selectOne103B(s103b);
					s103b.setLastYn("N");
					ibims103bMapper.updateLastYn(s103b);
	
					s103b.setLastYn("Y");
					s103b.setMtrPrgSttsDcd("401");
					result = ibims103bMapper.insert103B(s103b);
				}
			}else {
				result = -1; //기존 동일한 종목코드가 존재할경우 에러
			}
   	  //} else  {
		} else if(param.getRegDvsn().equals("U")) {	
	        IBIMS201BVO ibims201bvo = ibims201bMapper.selectOnlyOneIBIMS201B(param.getPrdtCd());
			param.setSn(ibims201bvo.getSn());
			param.setHndEmpno(empNo);
			result = ibims201bMapper.updateIBIMS201BDTO(param);

		}

		return result;
	}

	// 종목정보 삭제
	@Override
	public int deletePrdtCd(IBIMS201BVO param) {
		String prdtCd =param.getPrdtCd();
		//연결 승인조건내역 삭제
		ibims209bMapper.deleteIBIMS209BbyPrdtCd(prdtCd);
		//연결 담보내역 삭제
		ibims212bMapper.deleteIBIMS212BbyPrdtCd(prdtCd);
		return ibims201bMapper.deletePrdtCd(param);
	}

}
