<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member1.jsp</title>
</head>
<body>
	아이디 : ${param.id}<br> <%-- request.getParameter하여 출력한 것과 같음 --%>
	비밀번호 : ${param.pwd}<br>
	이름 : ${param.name}<br>
	이메일 : ${param.email}<br>
</body>
</html>