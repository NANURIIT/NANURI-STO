package com.nanuri.rams.business.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
/*
 * 금융감독원보고자료관리 CPC1 보고서 양식 DTO
 */
public class IBIMS701BDTO {

    private int rownum;                                                 // 항목
    private String stdrYm;                                              // 기준년월
    private String dprtCd;                                              // 부점코드
    private int rgstSn;                                                 // 등록일련번호
    private String bssAsstMngmNo;                                       // 기초자산관리번호
    private String rptsIemMngmNo;                                       // 보고서항목관리번호
    private String cmpNm;                                               // 회사명
    private String fssCmpCd;                                            // 금융감독원회사코드
    private String wrtnStdrDt;                                          // 작성기준일자
    private String prdtNm;                                              // 상품명
    private String ctrtDt;                                              // 계약일자
    private String expDt;                                               // 만기일자
    private String rptsCtrtTpCd;                                        // 보고서계약유형코드
    private String rptsCtrtTpDetlCd;                                    // 보고서계약유형상세코드
    private long frsCtrcAmt;                                            // 최초약정금액
    private long eprzCrdlNowCtrcBlce;                                   // 기업여신현재약정잔액
    private int detGrteFee;                                             // 채무보증수수료
    private String detGrteFlflDcd;                                      // 채무보증이행구분코드
    private String pfThcsDcd;                                           // PF해당구분코드
    private String pfTpDcd;                                             // PF유형구분코드
    private String pfSlltTpDcd;                                         // PF분양유형구분코드
    private String pfErnTpDcd;                                          // PF수익유형구분코드
    private String pfBssAsstLclsCd;                                     // PF기초자산대분류코드
    private String pfBssAsstSclsCd;                                     // PF기초자산소분류코드
    private String rlesTpDcd;                                           // 부동산유형구분코드
    private String bssAsstLctpDcd;                                      // 기초자산소재지구분코드
    private String rlesLctpZpcd;                                        // 부동산소재지우편번호
    private String lctpAddr;                                            // 소재지주소
    private String pfOvrsLctNtnCd;                                      // PF해외소재국가코드
    private String ovrsLctCtyNm;                                        // 해외소재도시명
    private String unsldThcsDcd;                                        // 미분양해당구분코드
    private String wrteMbdyNm;                                          // 피보증주체명
    private String wrteMbdyCrno;                                        // 피보증주체법인등록번호
    private String lqdzSctyGrteThcsDcd;                                 // 유동화증권보증해당구분코드
    private String lqdzSctyNm;                                          // 유동화증권명
    private String lqdzSctyKndCd;                                       // 유동화증권종류코드
    private String lqdzSctyIsuDt;                                       // 유동화증권발행일자
    private int lqdzSctyParAmt;                                         // 유동화증권액면금액
    private int lqdzSctyIsuIntrt;                                       // 유동화증권발행금리
    private int frsInvPotLtvRto;                                        // 최초투자시점LTV비율
    private int wrtnStdrDeLtvRto;                                       // 작성기준일LTV비율
    private String ltvOutputMthDcd;                                     // LTV산출방법구분코드
    private int aprsPrc;                                                // 감정가격
    private int totSlltAmt;                                             // 총분양금액
    private int jdgmTeamPrsmAmt;                                        // 심사팀추정금액
    private String pybkRankDcd;                                         // 변제순위구분코드
    private int rlesRentGrteAmt;                                        // 부동산임대보증금액
    private int prfdRankAmt;                                            // 우선순위금액
    private int sodrAmt;                                                // 동순위금액
    private int bkbnAmt;                                                // 후순위금액
    private String otcmCrdtRifcThcsDcd;                                 // 타사신용보감해당구분코드
    private String otcmCrdtRifcMnDcd;                                   // 타사신용보강수단구분코드
    private String sq1CrdtRifcCmpNm;                                    // 1차신용보강회사명
    private String sq1CrdtRifcCmpCrno;                                  // 1차신용보강회사법인등록번호
    private String sq1CrdtRifcCmpCrdtGrdCd;                             // 1차신용보강회사신용등급코드
    private String sq2CrdtRifcCmpNm;                                    // 2차신용보강회사명
    private String sq2CrdtRifcCmpCrno;                                  // 2차신용보강회사법인등록번호
    private String sq2CrdtRifcCmpCrdtGrdCd;                             // 2차신용보강회사신용등급코드
    private String efceCmpNm;                                           // 시행회사명
    private String efceCmpCrno;                                         // 시행회사법인등록번호
    private String pfEfceShpDcd;                                        // PF시행형태구분코드
    private String pfBusiApvlStepCd;                                    // PF사업승인단계코드
    private String pfCsstStepCd;                                        // PF착공단계코드
    private String pfSlltStepCd;                                        // PF분양단계코드
    private String pfCnfnStepCd;                                        // PF준공단계코드
    private int totBusiAmt;                                             // 총사업금액
    private int rvnuAmt;                                                // 매출금액
    private int slfCpta;                                                // 자기자본금
    private int unSqmsSlltAmt;                                          // 단위면적분양금액
    private int mdwyGoldRdmpRto;                                        // 중도금상환비율
    private int allSqms;                                                // 전체면적
    private int estmEmrmRt;                                             // 예상공실율
    private int unSqmsEstmRentErnAmt;                                   // 단위면적예상임대수익금액
    private int unSqmsEstmRentCt;                                       // 단위면적예상임대비용
    private int estmPurBsnErnAmt;                                       // 예상순수영업수익금액
    private int pfStlnTotLoanAmt;                                       // PF대주총대출금액
    private int pfStlnPtciIsttNum;                                      // PF대주참여기관수
    private String pfStlnLoanExpDt;                                     // PF대주대출만기일자
    private String sq1StlnIsttNm;                                       // 1차대주기관명
    private String sq1StlnIsttCrno;                                     // 1차대주기관법인등록번호
    private int sq1StlnLoanAmt;                                         // 1차대주대출금액
    private String sq2StlnIsttNm;                                       // 2차대주기관명
    private String sq2StlnIsttCrno;                                     // 2차대주기관법인등록번호
    private int sq2StlnLoanAmt;                                         // 2차대주대출금액
    private String sq3StlnIsttNm;                                       // 3차대주기관명
    private String sq3StlnIsttCrno;                                     // 3차대주기관법인등록번호
    private int sq3StlnLoanAmt;                                         // 3차대주대출금액
    private String sq4StlnIsttNm;                                       // 4차대주기관명
    private String sq4StlnIsttCrno;                                     // 4차대주기관법인등록번호
    private int sq4StlnLoanAmt;                                         // 4차대주대출금액
    private String sq5StlnIsttNm;                                       // 5차대주기관명
    private String sq5StlnIsttCrno;                                     // 5차대주기관법인등록번호
    private int sq5StlnLoanAmt;                                         // 5차대주대출금액
    private Date busiApvlRqsDt;                                         // 사업승인신청일자
    private int landPchsRt;                                             // 토지매입율
    private String rsplCnfnCfrmThcsDcd;                                 // 책임준공확약해당구분코드
    private String rsplCnfnCfrmIsttNm;                                  // 책임준공확약기관명
    private String rsplCnfnCfrmIsttCrno;                                // 책임준공확약기관법인등록번호
    private String rsplCnfnEprzCrdtGrdCd;                               // 책임준공기업신용등급코드
    private String csucCmpNm;                                           // 시공회사명
    private String csucCmpCrno;                                         // 시공회사법인등록번호
    private String csucCmpEprzCrdtGrdCd;                                // 시공회사기업신용등급코드
    private String csstDt;                                              // 착공일자
    private String cnfnDt;                                              // 준공일자
    private int plnFairRt;                                              // 계획공정율
    private int excFairRt;                                              // 실행공정율
    private int slltRt;                                                 // 분양율
    private String slltOpngDt;                                          // 분양개시일자
    private int moinRt;                                                 // 입주율
    private int exitSlltRt;                                             // EXIT분양율
    private int dvrSqms;                                                // 전용면적
    private int dvrSqmsUnAmt;                                           // 전용면적단위금액
    private int rentPsblTotSqms;                                        // 임대가능총면적
    private int emrmRt;                                                 // 공실율
    private int unSqmsRentErnAmt;                                       // 단위면적임대수익금액
    private int unSqmsRentCt;                                           // 단위면적임대비용
    private int sq1YrlyPurBsnErnAmt;                                    // 1차연간순수영업수익금액
    private int sq2YrlyPurBsnErnAmt;                                    // 2차연간순수영업수익금액
    private int rlesTotLoanIntr;                                        // 부동산총대출이자
    private int rlesTotLoanPaiAmt;                                      // 부동산총대출원리금금액
    private int cptlRstrRt;                                             // 자본환원율
    private int ncrRskVl;                                               // NCR위험값
    private int ncrRskAmt;                                              // NCR위험금액
    private String jobChrrNm;                                           // 업무담당자명
    private String dptNm;                                               // 부서명
    private String cplcCtns;                                            // 연락처내용
    private Date hndDetlDtm;                                            // 조작상세일시
    private String hndEmpno;                                            // 조작사원번호
    private String hndTmnlNo;                                           // 조작단말기번호
    private String hndTrId;                                             // 조작거래ID
    private String guid;                                                // GUID

}