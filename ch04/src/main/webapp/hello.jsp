<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//request : 내장객체(new로 생성하지 않아도 사용 가능)
	String name = request.getParameter("name"); // http 에서 name=hong 으로 받아올 부분
	String age = request.getParameter("age"); // age=20
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
<script>
/*
$(document).ready(function() {
	$("#btnSend").click(function(){
		var name = $("#name").val();
		var age = $("#age").val();
		location.href = "hello.jsp?name=" + name + "&age=" + age;
	});
});
*/

</script>
</head>
<body>
	<form action="hello.jsp">
		이름 : <input type="text" name="name" id="name"><br>
		나이 : <input type="number" name="age" id="age"><br>
		<button type="submit" id="btnSend">보내기</button>
	</form>
	<%
		if (name != null || age != null) {
	%>
			<h1>Hello</h1>
			<h2>안녕하세요</h2>
			<h3>이름: <%=name %>, 나이: <%=age %></h3>
	<%
		} // if
	%>
</body>
</html>