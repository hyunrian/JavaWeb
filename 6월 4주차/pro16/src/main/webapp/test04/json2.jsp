<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json2.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
$(function(){
	let jsonStr = '{"age" : [22, 33, 44]}';
	$("#print").click(function() {
		let json = JSON.parse(jsonStr);
		let ages = json.age;
		let total = 0;
		let html = "회원 나이<br>";
		html += "========<br>";
		for (let i in ages) {
			html += ages[i] + "<br>";
			total += parseInt(ages[i]);
		}
		html += "========<br>";
		html += "나이의 합: " + total;
		
		$("#output").html(html);
		
	});
});
</script>
</head>
<body>
	<span><a href="#" id="print">출력</a></span><br><br>
	<div id="output"></div>
</body>
</html>