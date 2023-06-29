<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginCheck.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
$(function() {
	$("#button").click(function() {
		let id = $("#id").val();
		console.log(id);
		let url = "/test01/loginCheck";
		let sData = {"id" : id};
		let text = "";
		$.post(url, sData, function(rData) {
			console.log(rData);
			if (rData == true) {
				text = "중복된 아이디입니다.";
			} else {
				text = "사용할 수 있는 아이디입니다.";
			}
				$("#output").text(text);
		});
	});
});
</script>
</head>
<body>
	아이디 : <input type="text" id="id"> <button id="button" type="button">중복확인</button><br>
	<div id="output" style="color:red;"></div>
</body>
</html>