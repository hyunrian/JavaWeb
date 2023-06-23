<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num = Integer.valueOf(request.getParameter("num"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>number.jsp</title>
</head>
<body>
	<h1>number.jsp</h1>
	<h2><%=num %></h2>
</body>
</html>