<%@page import="java.util.*"%>
<%@page import="sec01.ex01.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member7.jsp</title>
</head>
<body>
	<%-- JSTL 객체 반복 --%>
<%
	MemberVo vo1 = new MemberVo("lee", "1234", "이길동", "lee@gmail.com");
	MemberVo vo2 = new MemberVo("kim", "12345", "김길동", "kim@gmail.com");
	MemberVo vo3 = new MemberVo("choi", "123456", "최길동", "choi@gmail.com");
	MemberVo vo4 = new MemberVo("park", "1234567", "박길동", "park@gmail.com");
	
	List<MemberVo> list = new ArrayList<>();
	list.add(vo1);
	list.add(vo2);
	list.add(vo3);
	list.add(vo4);
	pageContext.setAttribute("list", list);
%>

	<table border="1">
		<tr>
			<th>#</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
		</tr>
		<%-- for (MemberVo vo : list) --%>
		<c:forEach var="vo" items="${list}" varStatus="status">
		<tr>
			<td>${status.count}</td>
			<td>${vo.id}</td>
			<td>${vo.pwd}</td>
			<td>${vo.name}</td>
			<td>${vo.email}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>