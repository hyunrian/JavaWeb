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
	<table border="1" width="100%">
		<tr>
			<th colspan="2">${num}단 출력</th>
		</tr>
		<c:forEach var="i" begin="1" end="9" step="1">
			<tr>
				<td width="1%">${num} * ${i}</td>
				<td width="1%">${num * i}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>