var arrPqGridMrtgInfoList;


let TB06017P_gridState = 1;
let TB06017P_onchangehandler = "on";	// on off

$(document).ready(function() {
	docRdySettings();
});

/**
 * show modal 
 */
function callTB06017P(prefix) {
	clearTB06017P();
	keyDownEnter_TB06017P();
	$('#TB06017P_prefix').val(prefix);
	
	TB06017P_gridState=0;
	$('#modal-TB06017P').modal('show');
	indexChangeHandler("TB06017P");
	setTimeout(() => roadMrtgInfoListGrid(), 300);

	if(prefix == 'TB06013P'){
		$("#TB06017P_mrtgMngmNo").val($("#TB06013P_mrtgMngmNo").val());  //담보번호
		//$("#TB06017P_mrtgNm").val($("#TB06013P_mrtgNm").val()); //담보명
		if(isNotEmpty($("#TB06017P_mrtgMngmNo").val())){
			setTimeout(() => getMrtgInfo(), 300);
		}
	}
}

/**
 * callGridTB06017P
 */
function callGridTB06017P(prefix) {
	$('#TB06017P_prefix').val(prefix);
	setTimeout(() => roadMrtgInfoListGrid(), 300);
}

/**
	문서로드시 세팅
 */
function docRdySettings() {
	modalShowFunction_TB06017P();
	keyDownEnter_TB06017P();
}

/**
 * 모달 오픈 애니메이션 후 포커스 주도록 설정
 */
function modalShowFunction_TB06017P() {
	$('#modal-TB06017P').on('shown.bs.modal', function() {
		$('#modal-TB06017P input[id=TB06017P_mrtgMngmNo]').focus();
	});
}

/**
 * 키다운엔터이벤트
 */
function keyDownEnter_TB06017P() {
	$("input[id=TB06017P_mrtgMngmNo]").keydown(function(key) {
		if (key.keyCode == 13) {//키가 13이면 실행 (엔터는 13)
			console.log("keyDownEnter_TB06017P");
			getMrtgInfo();
		}
	});

	$("input[id=TB06017P_mrtgNm]").keydown(function(key) {
		if (key.keyCode == 13) {//키가 13이면 실행 (엔터는 13)
			getMrtgInfo();
		}
	});
}

/**
 * 팝업 닫힌채 자동호출 , 검색
 */
function TB06017P_srch(menuId) {	
	/**
	 * (1) 담보번호길이체크 후 자동조회
	 */
	// 그리드만 부릅니다
	callGridTB06017P('TB06013P');

	$(`div[id="modal-TB06013P"] span.input-group-append > button[onclick*="callTB06017P"]:not([disabled])`).closest('span.input-group-append').prev("input[id*='_mrtgMngmNo']").on('input', async function () {
			const str = $(this).val().length
			// 같이 붙어있는 인풋박스 id
			//const result = $(this).attr('id').slice(0, $(this).attr('id').length - 6) + 'Nm_forSeach'; //담보명
			//$(`#${result}`).val("") //담보명
			console.log("담보번호길이체크 후 자동조회");
			$('#TB06013P_mrtgNm_forSeach').val("");

			// ex) 담보번호 VARCHAR(16)
			if(str === 16){
				TB06017P_onchangehandler = "off";
				await srchEvent_TB06017P(this);
			}
		})
		
	/**
	 * (2) 담보번호 키이벤트 
	 * */	
	$(`div[id="modal-TB06013P"] span.input-group-append > button[onclick*="callTB06017P"]:not([disabled])`).closest('span.input-group-append').prev("input[id*='_mrtgMngmNo']").on('keydown', async function (evt) {
		console.log("담보번호 키이벤트 ");
			// Enter에만 작동하는 이벤트
			if (evt.keyCode === 13) {
				evt.preventDefault();
				TB06017P_onchangehandler = "off";
				await srchEvent_TB06017P(this);
			}
	})
	/**
	 *(3) 부모이벤트 컨트롤
	 */
	async function srchEvent_TB06017P(selector){
		// 사용한 인풋박스의 출처 페이지 가져오기
		let prefix;
		prefix= 'TB06013P';
		$('#TB06013P_mrtgNm_forSeach').val("");
		
		
		$('#TB06017P_prefix').val(prefix);		
		if ($(`div[id='modal-TB06017P']`).css('display') === "none") {
			TB06017P_gridState = 1;
		}
		
		// 인풋박스 밸류
		let data = $(selector).val();
		$('#TB06017P_mrtgMngmNo').val(data);		
		
		// 팝업 오픈
		if (TB06017P_gridState === 0) {
			console.log("열려있음", TB06017P_gridState);
			$('#TB06017P_mrtgMngmNo').val(data);
			setTimeout(() => getMrtgInfo(), 200);
		} else if (TB06017P_gridState === 1) {
			console.log("닫혀있음", TB06017P_gridState);
			$('#TB06017P_mrtgMngmNo').val(data);
			// ajax통신인데 각 팝업마다 구조가 달라서 다르게 세팅해야해요
			setTimeout(() => getMrtgInfo(), 200);
		}
		
	}
}	





//그리드 컬럼 세팅 
var colMrtgInfoList = [

	{ 	
		title    : "담보번호",  
		dataType : "string", 
		dataIndx : "mrtgMngmNo", 
		align    : "center",
		halign	 : "center",
		width    : 90,
		filter   : { crules: [{ condition: 'range' }] } 
	},
	{ 	
		title    : "담보명", 
		dataType : "string",
		dataIndx : "mrtgNm", 
		align    : "left", 
		halign	 : "center",
		filter   : { crules: [{ condition: 'range' }] },
	},
	{ 	
		title    : "담보종류", 
		dataType : "string", 
		dataIndx : "mrtgStupKndNm",
		align    : "left",
		halign	 : "center",
		filter   : { crules: [{ condition: 'range' }] },
	},
	{ 	
		title    : "담보대분류", 
		dataType : "string", 
		dataIndx : "mrtgLclsNm",
		align    : "left",
		halign	 : "center",
		filter   : { crules: [{ condition: 'range' }] },
	},
	{ 	
		title    : "담보중분류", 
		dataType : "string", 
		dataIndx : "mrtgMdclNm",
		align    : "left",
		halign	 : "center",
		filter   : { crules: [{ condition: 'range' }] },
	},
	{ 	
		title    : "담보평가기준", 
		dataType : "string", 
		dataIndx : "mrtgEvlStdrNm",
		align    : "left",
		halign	 : "center", 
		filter   : { crules: [{ condition: 'range' }] },
	},
	{ 	
		title    : "담보금액", 
		dataType : "integer", 
		dataIndx : "mrtgAmt", 
		align    : "right",
		halign	 : "center", 
		filter   : { crules: [{ condition: 'range' }] },
		render	 : function (ui) {
            let cellData = ui.cellData;
            if (cellData !== null && cellData !== undefined) {
                return addComma(cellData); 
            }
            return cellData; 
        }

	},
	{ 	
		title    : "등록일자", 
		dataType : "string", 
		dataIndx : "rgstDt", 
		align    : "center",
		halign	 : "center", 
		filter   : { crules: [{ condition: 'range' }] },
		render   : function (ui) {
			let cellData = ui.cellData;
			if (cellData && cellData.length !== 0) {
				let rgstDt1 = cellData.substring(0, 4);
				let rgstDt2 = cellData.substring(4, 6);
				let rgstDt3 = cellData.substring(6, 8);
				return `${rgstDt1}-${rgstDt2}-${rgstDt3}`.trim();
			}
			return cellData; 
        } 
	},
	{ 	
		title    : "해지일자", 
		dataType : "string", 
		dataIndx : "mrtgCclcDt", 
		align    : "center",
		halign	 : "center", 
		filter   : { crules: [{ condition: 'range' }] },
		render   : function (ui) {
			let cellData = ui.cellData;
			if (cellData && cellData.length !== 0) {
				let rgstDt1 = cellData.substring(0, 4);
				let rgstDt2 = cellData.substring(4, 6);
				let rgstDt3 = cellData.substring(6, 8);
				return `${rgstDt1}-${rgstDt2}-${rgstDt3}`.trim();
			}
			return cellData; 
        } 
	},
	{ 	
		title    : "담보평가기준코드", 
		dataType : "string", 
		dataIndx : "mrtgEvlStdrCd",
		align    : "right",
		halign	 : "center",
		hidden	 : true,
		filter   : { crules: [{ condition: 'range' }] },
	}

];

//그리드 호출
function roadMrtgInfoListGrid(){
	arrPqGridMrtgInfoList = $("#TB06017P_mrtgInfoList").pqGrid( 'instance' );	
	if(typeof arrPqGridMrtgInfoList == "undefined") {	
		var obj = {	
			height: 665,
			maxHeight: 665,
			showTitle: false,
			showToolbar: false,
			collapsible: false,
			wrap: false,
			hwrap: false,
			numberCell: { show: false, width: 40, resizable: true, title: "<p class='text-center'>순번</p>" },
			editable: false,
			scrollModel: { autoFit: true },
			colModel: colMrtgInfoList,
			strNoRows: '데이터가 없습니다.'
		};	
		$("#TB06017P_mrtgInfoList").pqGrid(obj);
		arrPqGridMrtgInfoList = $("#TB06017P_mrtgInfoList").pqGrid( 'instance' );		
	} 
	else{		
		arrPqGridMrtgInfoList.setData([]);
	}

}

//그리드에 데이터 넣기 (CRUD)
function dataMrtgInfoSetGrid(data){	
	arrPqGridMrtgInfoList.setData(data);
	arrPqGridMrtgInfoList.option("strNoRows", '조회된 데이터가 없습니다.');
	arrPqGridMrtgInfoList.on("cellDblClick", function (event, ui) 
		{
		 	var rowData = ui.rowData;
		 	setMrtgInfo(rowData);
		});
		
	 // 검색된 행이 1개일 경우 데이터 바로 입력	
	 if( (arrPqGridMrtgInfoList.pdata.length== 1)
	  && ( $(`div[id='modal-TB06017P']`).css('display') === "none")
	 ){
		console.log("1개면 닫혀야지");
		setMrtgInfo(arrPqGridMrtgInfoList.pdata[0]);
	 }
}





/**
 * hide modal
 */
function modalClose_TB06017P() {
	if(typeof fnltPgGrid != "undefined") arrPqGridMrtgInfoList.setData([]);
	$('#modal-TB06017P').modal('hide');
};

/**
 * clear modal
 * 초기화 버튼
 */
function clearTB06017P() {
	$('#TB06017P_mrtgMngmNo').val("");
	$('#TB06017P_mrtgNm').val("");
}

/**
 * 조회 버튼
 */
function getMrtgInfo() {
	
	var paramData = {
		"mrtgMngmNo" : $('#TB06017P_mrtgMngmNo').val()
		, "mrtgNm" : $('#TB06017P_mrtgNm').val()
	}
	$.ajax({
		type: "GET",
		url: "/TB06017P/getMrtgInfo",
		data: paramData,
		dataType: "json",
		success: function(data) {
			if((data.length >1)
				&& ( $(`div[id='modal-TB06017P']`).css('display') === "none")	
			){
				//팝업오픈				
				callTB06017P('TB06013P');				
			}else if(data.length>0){
				dataMrtgInfoSetGrid(data);
			}else{
				arrPqGridMrtgInfoList.setData([]);
			}
		}
	});
}

/**
 * dblclick event function
 * 더블클릭 이벤트
 */
function setMrtgInfo(e) {
	var tr = $(e);
	var td = $(tr).children();

	// 종목정보
	var mrtgMngmNo		= td.eq(0).text();
	var mrtgNm			= td.eq(1).text();
	var mrtgStupKndCd	= td.eq(2).text();
	var mrtgLclsCd		= td.eq(3).text();
	var mrtgMdclCd		= td.eq(4).text();
	var mrtgAmt			= td.eq(5).text();
	var rgstDt			= td.eq(6).text();
	var mrtgCclcDt		= td.eq(7).text();
	
	// 페이지 항목
	var pageMrtgMngmNo	= '#' + $('#TB06017P_prefix').val() + '_mrtgMngmNo';
	var pageMrtgNm		= '#' + $('#TB06017P_prefix').val() + '_mrtgNm_forSeach';

	// 값 전달
	$(pageMrtgMngmNo).val(e.mrtgMngmNo);
	$(pageMrtgNm).val(e.mrtgNm);
	
	TB06013P_getMrtgInfoDetails();
	modalClose_TB06017P();
}
