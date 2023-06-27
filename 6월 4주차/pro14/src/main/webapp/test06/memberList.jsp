<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList.jsp</title>
<script>
	var result = "${result}";
	if (result == "true") alert("가입 성공");
	else alert("가입 실패");
		
</script>
</head>
<body>
	<h1>회원 목록</h1>
	<table border="1">
		<tr>
			<th>#</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>가입일</th>
		</tr>
		<c:forEach items="${list}" var="vo" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${vo.id}</td>
				<td>${fn:substring(vo.pwd, 0, 2)}******</td>
				<td>${vo.name}</td>
				<td>${vo.email}</td>
				<td><fmt:formatDate value="${vo.joindate}" pattern="yy-MM-dd HH:mm:ss"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>