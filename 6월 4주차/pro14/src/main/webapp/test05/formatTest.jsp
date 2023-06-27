<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>formatTest.jsp</title>
</head>
<body>
	<c:set var="price" value="100000000"/>
	<fmt:formatNumber value="${price}" type="number"/><br> <%-- 100,000,000 --%>
	<fmt:formatNumber value="${price}" type="number" 
		groupingUsed="false"/><br> <%-- 100000000 --%>
	<fmt:formatNumber value="${price}" type="currency" currencySymbol="￦"/><br>
	<fmt:formatNumber value="${price}" type="percent"/><br>
	
	<hr>
	
	<c:set var="now" value="<%=new Date() %>"/>
	${now}<br>
	
	<fmt:formatDate value="${now}" type="date"/><br>
	<fmt:formatDate value="${now}" type="date" dateStyle="full"/><br>
	<fmt:formatDate value="${now}" type="date" dateStyle="long"/><br>
	<fmt:formatDate value="${now}" type="date" dateStyle="medium"/><br>
	<fmt:formatDate value="${now}" type="date" dateStyle="short"/><br>
	
	<fmt:formatDate value="${now}" type="time"/><br>
	<fmt:formatDate value="${now}" type="both"/><br>
	<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br>
	
	<%-- 패턴 적용이 가장 많이 쓰임 --%>
	<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" /><br> 
</body>
</html>