<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json7.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
$(function(){
	$("#checkJson").click(function(e) {
		e.preventDefault();
		
		let url = $(this).attr("href");
		$.get(url, function(rData) {
// 			console.log(rData);
			let output = "<table border='1'>";
			output += "<tr>";
			output += "<th>아이디</th>";
			output += "<th>비밀번호</th>";
			output += "<th>이름</th>";
			output += "<th>이메일</th>";
			output += "<th>가입일</th>";
			output += "</tr>";
			
			for (var v = 0; v < rData.length; v++) {
				output += "<tr>";
				output += "<td>" + rData[v].id + "</td>";
				output += "<td>" + rData[v].pwd + "</td>";
				output += "<td>" + rData[v].name + "</td>";
				output += "<td>" + rData[v].email + "</td>";
				output += "<td>" + rData[v].joindate + "</td>";
				output += "</tr>";
			}
			output += "</table>";
			$("#target").html(output);
		});
	});
});
</script>
</head>
<body>
	<div><a href="/pro16/json3" id="checkJson">출력</a></div>
	<div id="target"></div>
</body>
</html>