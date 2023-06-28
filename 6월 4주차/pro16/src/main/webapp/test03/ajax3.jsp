<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax3.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
$(function() { // document.ready function과 동일(생략 가능)
	$("#button").click(function() {
		let url = "/pro16/mem"; // 원래는 contextPath로 작성하는 것이 원칙
		let sData = {id : $("#id").val().trim()}; 
		// data는 json 형식으로 작성해야 함.(.val/html/text의 차이 복습!)
// 		console.log(sData);
		$.post(url, sData, function(rData) {
			console.log(rData);
			let html = "";
			if (rData == "true") { // 자바에서 boolean으로 넘겨도 여기서는 text임
				html = "<span style='color:red;'>중복된 아이디입니다.</span>";
			} else {
				html = "<span style='color:blue;'>사용 가능한 아이디입니다.</span>";
			}
			$("#div").html(html);
		});
	});
});
</script>
</head>
<body>
	아이디 : <input type="text" id="id"> <button type="button" id="button">중복 확인</button>
	<div id="div"></div>
</body>
</html>