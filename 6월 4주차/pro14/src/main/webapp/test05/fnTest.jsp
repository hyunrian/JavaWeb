<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fnTest.jsp</title>
</head>
<body>
	<c:set var="title1" value="hello world!"/>
	<c:set var="title2" value="쇼핑몰 중심 JSP입니다."/>
	<c:set var="title3" value="  JAVA"/>
	<c:set var="str" value="중심"/>

	<hr>
	title1 : hello world!<br>	
	title2 : 쇼핑몰 중심 JSP입니다.<br>	
	str : 중심<br>
	<hr>
	
	<!-- 문자열 길이 -->
	${fn:length(title1)}<br>
	<!-- 대문자로 변경 -->
	${fn:toUpperCase(title1)}<br>
	<!-- 소문자로 변경 -->
	${fn:toLowerCase(title3)}<br>
	<!-- 부분 문자열 str.substring(0, 10) -->
	${fn:substring(title1, 3, 6)}<br>
	<!-- 공백 제거 -->
	${fn:trim(title3)}<br>
	<!-- 문자열 치환(대체) str.replace("a", "b") -->
	${fn:replace(title1, " ", "/")}<br>
	<!-- 특정 문자의 위치 얻기(인덱스) -->
	${fn:indexOf(title2, str)}<br>
	<!-- 특정 문자 존재 여부 -->
	${fn:contains(title1, str)}<br>
	${fn:contains(title2, str)}<br>
	
</body>
</html>