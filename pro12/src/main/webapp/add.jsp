<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="addException.jsp"
    %>
    <%-- JSP에서 예외처리하기 --%>
<% 
	int iNum = Integer.valueOf(request.getParameter("num"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add.jsp</title>
</head>
<body>
	<%=iNum * 10 %>
</body>
</html>