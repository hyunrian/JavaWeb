<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="num" value="${param.num}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="100%" style="text-align:center;">
		<tr>
			<th colspan="2">${num}단 출력</th>
		</tr>
		<c:forEach var="i" begin="1" end="9" step="1">
			<c:choose>
				<c:when test="${i % 2 == 0}">
					<tr style="background-color:YELLOW;">
				</c:when>
				<c:otherwise>
					<tr style="background-color:GREEN;">
				</c:otherwise>
			</c:choose>
				<td width="1%">${num} * ${i}</td>
				<td width="1%">${num * i}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>