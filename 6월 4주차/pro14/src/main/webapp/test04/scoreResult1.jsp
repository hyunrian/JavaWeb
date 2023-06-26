<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="score" value="${param.score}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scoreResult1.jsp</title>
</head>
<body>
	<h1>시험점수 ${score}</h1>
	<h1>
		<c:choose>
			<c:when test="${90 < score && score <= 100}">
				A학점입니다.
			</c:when>
			<c:when test="${80 < score && score <= 90}">
				B학점입니다.
			</c:when>
			<c:when test="${70 < score && score <= 80}">
				C학점입니다.
			</c:when>
			<c:when test="${60 < score && score <= 70}">
				D학점입니다.
			</c:when>
			<c:otherwise>
				F학점입니다.
			</c:otherwise>
		</c:choose>
	</h1>
</body>
</html>