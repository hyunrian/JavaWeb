<%@page import="sec01.ex01.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	MemberVo vo = new MemberVo("kim", "5678", "김길동", "kim@gmail.com");
	Address address = new Address("울산시", "남구");
	vo.setAddress(address); // has-a 관계(MemberVo 객체가 Address 객체를 속성으로 가짐)
	Map<String, MemberVo> map = new HashMap<>();
	map.put("vo", vo);
	pageContext.setAttribute("map", map);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member2.jsp</title>
</head>
<c:set var="vo" value="${map.vo}"></c:set> <%-- map.vo를 vo로 쓸 수 있음 --%>
<body>
	<%-- 표현언어에서 Has-a 관계 빈 사용하기 --%>
	
	아이디 : ${vo.id}<br>
	비밀번호 : ${vo.pwd}<br>
	이름 : ${vo.name}<br>
	이메일 : ${vo.email}<br>
	시/도 : ${vo.address.sido}<br> 
	구/군 : ${vo.address.gugun}<br>
	<%-- 
	MemberVo에 sido가 있는게 아니라 Address에 있음
	MemberVo vo = map.get("memberVo"); // 편의상 getXX라 표현
	Address address = vo.getAddress();
	String sido = address.getSido();
	--%>
	
</body>
</html>