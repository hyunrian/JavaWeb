<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Map<String, String> map = new HashMap<>();
	map.put("id", "hong");
	map.put("pwd", "1234");
	map.put("name", "홍길동");
	map.put("email", "hong@gmail.com");
	pageContext.setAttribute("map", map);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member5.jsp</title>
</head>
<body>
	<%-- 표현언어에서 Map 사용하기 --%>
	<%-- map.getXX라는 메서드는 없으나 key로 value를 찾아오는 메서드를 알아서 사용해줌 --%>
	
	아이디 : ${map.id} <br> <%-- pageContext.map.id로 써야하지만 생략 가능 --%>
	비밀번호 : ${map.pwd} <br> 
	이름 : ${map.name} <br> 
	이메일 : ${map.email} <br> 
	
</body>
</html>