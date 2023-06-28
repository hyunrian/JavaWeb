<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json5.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
$(function(){
	$("#checkJson").click(function(e) {
		e.preventDefault();
		$.get("/pro16/json1", function(rData) {
			console.log(rData);
// 			let jsonArr = JSON.parse(rData); // rData에서 이미 처리가 되어있음
// 			console.log(jsonArr);

			let output = "회원정보<br>";
			output += "===============<br>";
			for (let i = 0; i < rData.length; i++) {
				output += "이름: " + rData[i].name + "<br>";
				output += "나이: " + rData[i].age + "<br>";
				output += "성별: " + rData[i].gender + "<br>";
				output += "별명: " + rData[i].nickname + "<br>";
				output += "---------------------<br>";
			}
			$("#target").html(output);
		});
	});
});
</script>
</head>
<body>
	<span><a href="http://www.naver.com" id="checkJson">출력</a></span><br><br>
	<div id="target"></div>
</body>
</html>