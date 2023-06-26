<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="id" value="hong" scope="page"></c:set> <!-- page scope는 생략 가능 -->
<c:set var="pwd" value="1234" scope="page"></c:set>
<c:set var="name" value="${'홍길동'}" scope="page"></c:set> <!-- 표현언어 사용 가능 -->
<c:set var="age" value="${22}" scope="page"></c:set>
<c:set var="height" value="${183}" scope="page"></c:set>
<c:set var="score" value="${77}" scope="page"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member5.jsp</title>
</head>
<body>
	<%-- JSTL 조건문 사용하기 (if~else~) --%>
	
	<%-- if(age >= 19) else --%>
	<c:choose>
		<c:when test="${age >= 19}">
			성인입니다.<br>
		</c:when>
		<c:otherwise>
			미성년자입니다.<br>
		</c:otherwise>
	</c:choose>
	
	<%-- if() ~ else if() ~ else --%>
	<c:choose>
		<c:when test="${score ge 90}">
			참 잘했어요.<br>
		</c:when>
		<c:when test="${score ge 80}">
			좀 잘했어요.<br>
		</c:when>
		<c:otherwise>
			분발하세요.<br>
		</c:otherwise>
	</c:choose>
</body>
</html>