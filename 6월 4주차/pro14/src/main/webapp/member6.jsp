<%@page import="sec01.ex01.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>member6.jsp</title>
</head>
<body>
	<%-- 표현언어에서 Has-a 관계 빈 사용하기 --%>
	
	아이디 : ${map.vo.id}<br>
	비밀번호 : ${map.vo.pwd}<br>
	이름 : ${map.vo.name}<br>
	이메일 : ${map.vo.email}<br>
	시/도 : ${map.vo.address.sido}<br> 
	구/군 : ${map.vo.address.gugun}<br>
	<%-- 
	MemberVo에 sido가 있는게 아니라 Address에 있음
	MemberVo vo = map.get("memberVo"); // 편의상 getXX라 표현
	Address address = vo.getAddress();
	String sido = address.getSido();
	--%>
	
</body>
</html>