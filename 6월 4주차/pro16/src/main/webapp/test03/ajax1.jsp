<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax1.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
	// 비동기요청 호출 - 현재 화면을 유지한 채로 서버에 요청하는 것
	function fn_process() {
		console.log("fn_process ran");
		$.ajax({
			/* ',' 빼먹지 않게 조심! */
			type : "get", /*전송방식*/
			dataType : "text", /*응답받을 데이터 타입*/
			async : false, /*비동기로 작업할지 여부 false-순차, true-무작위 실행*/
			url : "http://localhost/pro16/ajaxTest1", /*어느 서버로 요청하는지*/
			data : {param : "Hello, jQuery"}, /*서버로 보낼 데이터. json형식으로 보냄*/
			success : function(rData, textStatus) { /*응답을 정상적으로 받았을 때 실행 (파라미터: 받은데이터, 상태)*/
				console.log("successed -", rData, textStatus); /* 텍스트를 ,로 연결하면 한칸 스페이스 처리됨*/
				$("#message").text(rData); /*응답받은 rData를 아이디 message 태그에서 텍스트처리*/
			}, 
			error : function(rData, textStatus) { /*응답을 받기에 실패했을 때 실행*/
				console.log("error -", rData);
			}, 
			complete : function(rData, textStatus) { /*응답 성공여부와 관계없이 실행*/
				console.log("completed -", rData);
			} 
		});
	}
</script>
</head>
<body>
	<button type="button" onclick="fn_process();">전송하기</button>
	<div id="message"></div>
</body>

</html>