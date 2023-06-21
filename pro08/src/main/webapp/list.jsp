<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String data = (String)request.getAttribute("data"); // MemberServlet에서 넣어놓은 데이터
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
</head>
<body>
	<h1>회원목록</h1>
	<!-- 데이터 -->
	<%=data %><br>
	<a href="/pro08/member?command=addForm">회원가입</a>
</body>
</html>