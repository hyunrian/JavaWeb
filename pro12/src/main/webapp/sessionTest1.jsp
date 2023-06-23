<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
	내장객체 중 session과 application 사용해보기
	session - 접속당 공유  /  application - 프로젝트당 공유 
	영역객체 : page < request < session < application
--%>
<%
	session.setAttribute("sessName", "홍길동");
	application.setAttribute("appName", "pro12");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sessionTest1.jsp</title>
</head>
<body>
	<a href="sessionTest2.jsp">다음으로 이동</a>
</body>
</html>