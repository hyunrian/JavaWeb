<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json3.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
$(function(){
	let jsonStr = '{"name" : "박지성", "age" : 25, "gender" : "남자", "nickname" : "날쌘돌이"}';
	$("#checkJson").click(function(e) {
		e.preventDefault();
		let jsonObj = JSON.parse(jsonStr);
		console.log(jsonObj);
		let output = "회원정보<br>";
		output += "===============<br>";
		output += "이름: " + jsonObj.name + "<br>";
		output += "나이: " + jsonObj.age + "<br>";
		output += "성별: " + jsonObj.gender + "<br>";
		output += "별명: " + jsonObj.nickname + "<br>";
		$("#target").html(output);
	});
});
</script>
</head>
<body>
	<span><a href="http://www.naver.com" id="checkJson">출력</a></span><br><br>
	<div id="target"></div>
</body>
</html>