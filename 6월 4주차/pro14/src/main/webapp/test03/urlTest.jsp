<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <c:set var="contextPath" value="${pageContext.request.contextPath}" /> --%>
<%-- <c:set var="id" value="hong"/> --%>
<%-- <c:set var="pwd" value="1234"/> --%>
<%-- <c:set var="name" value="홍길동"/> --%>
<%-- <c:set var="email" value="hong@gmail.com"/> --%>

<c:url var="url1" value="/test03/member8.jsp"> <%-- url 태그를 쓰면 contextPath를 자동으로 구해줌 --%>
	<c:param name="id" value="hong"></c:param>
	<c:param name="pwd" value="1234"></c:param>
	<c:param name="name" value="홍길동"></c:param>
	<c:param name="email" value="hong@gmail.com"></c:param>
</c:url>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>urlTest.jsp</title>
</head>
<body>
<%-- 	<a href="${contextPath}/test03/member8.jsp?id=${id}&pwd=${pwd}&name=${name}&email=${email}">회원정보 보기</a> --%>
	<a href="${url1}">회원정보 보기</a> <%-- 가독성이 훨씬 좋아짐 --%>
</body>
</html>