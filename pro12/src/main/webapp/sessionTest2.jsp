<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sessName = (String)session.getAttribute("sessName");
	String appName = (String)application.getAttribute("appName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sessionTest2.jsp</title>
</head>
<body>
	sessName : <%=sessName %><br>
	appName : <%=appName %>
</body>
</html>