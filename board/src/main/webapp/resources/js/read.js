/**
 * read.jsp 스크립트
 */

$(function(){
	
	// operForm 가져오기
	let operForm = $("#operForm");
	
	// list 버튼 클릭 시 /board/list로 이동
	// $("[type = "reset"]")
	// $(":reset")
//	$(".btn-info").click(function(){
//		location.href = "/board/list";
//	})

	$(".btn-info").click(function(){
		
		// operForm 안의 bno 태그 제거
		operForm.find("input[name='bno']").remove();
		
		// operForm action 수정
		operForm.attr("action", "/board/list")
		
		// operForm 보내기
		operForm.submit();		  
		
	})
	
	// modify 버튼 클릭 시 operForm 이동
	$(".btn-default").click(function(){
		operForm.submit();
	})
})