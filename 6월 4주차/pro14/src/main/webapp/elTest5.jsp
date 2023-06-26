<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elTest5.jsp</title>
</head>
<body>
	<%-- empty 연산자 테스트 --%>
	
	<jsp:useBean id="vo" class="sec01.ex01.MemberVo"></jsp:useBean>	
	<jsp:setProperty property="id" name="vo" value="이순신"/>
	\${empty vo} : ${empty vo}<br> <%-- false --%>
	\${not empty vo} : ${not empty vo}<br> 
	
	<jsp:useBean id="list" class="java.util.ArrayList"></jsp:useBean>	
	\${empty list} : ${empty list}<br> <%-- true --%>
	\${!empty list} : ${!empty list}<br> 
	\${not empty list} : ${not empty list}<br> 
	
	\${empty "hello"} : ${empty "hello"}<br>
	\${empty ""} : ${empty ""}<br>
	\${empty null} : ${empty null}<br>
	
</body>
</html>