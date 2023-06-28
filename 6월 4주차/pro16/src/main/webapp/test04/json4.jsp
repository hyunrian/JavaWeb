<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json4.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
$(function(){
	let jsonStr = '[{"name" : "박지성", "age" : 25, "gender" : "남자", "nickname" : "날쌘돌이"},';
	jsonStr += '{"name" : "손흥민", "age" : 30, "gender" : "남자", "nickname" : "쏘니"}]';
	$("#checkJson").click(function(e) {
		e.preventDefault();
		let jsonArr = JSON.parse(jsonStr);
		console.log(jsonArr);
		let output = "회원정보<br>";
		output += "===============<br>";
		for (let i = 0; i < jsonArr.length; i++) {
			output += "이름: " + jsonArr[i].name + "<br>";
			output += "나이: " + jsonArr[i].age + "<br>";
			output += "성별: " + jsonArr[i].gender + "<br>";
			output += "별명: " + jsonArr[i].nickname + "<br>";
			output += "---------------------<br>";
		}
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