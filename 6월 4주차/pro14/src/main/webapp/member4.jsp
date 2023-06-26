<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sec01.ex01.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVo m1 = new MemberVo("hong", "1234", "홍길동", "hong@gmail.com");
	MemberVo m2 = new MemberVo("kim", "5678", "김길동", "kim@gmail.com");
	List<MemberVo> list = new ArrayList<>();
	list.add(m1);
	list.add(m2);
	request.setAttribute("list", list); // 표현언어에서 사용하려면 바인딩해야 함
	// pageContext.setAttrubute나 Session에 넣어도 상관 없음
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member4.jsp</title>
</head>
<body>
	<%-- 표현언어에서 Collection 사용하기 --%>
	<%-- requestScope.xxx의 형식으로 써야하지만 생략하면 알아서 범위순으로 찾음 --%>
	
	<h1>m1</h1>
	${list[0].id}<br>
	${list[0].pwd}<br>
	${list[0].name}<br>
	${list[0].email}<br>
	
	<h1>m2</h1>
	${list[1].id}<br>
	${list[1].pwd}<br>
	${list[1].name}<br>
	${list[1].email}<br>
</body>
</html>