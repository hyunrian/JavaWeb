<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	 let addResult = "${sessionScope.addResult}";
	 if (addResult == "true") { 
		 // 데이터 주고받을 때(servlet - boolean) 텍스트로 되는 것과 불리언으로 넘어오는 것의 차이
		 alert("회원가입 성공");
	 } else if (addResult == "false") {
		 alert("회원가입 실패");
	 }
</script>
</head>
<body>
	<h1>회원 목록</h1>
	<form action="/memberTest/joinForm" method="post">
		<button>회원가입</button>
	</form>
	<br>
	<table border="1" width="100%">
		<tr>
			<th>#</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>가입일</th>
		</tr>
		<c:forEach var="vo" items="${list}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${vo.id}</td>
				<td>${vo.pwd}</td>
				<td>${vo.name}</td>
				<td>${vo.email}</td>
				<td>${vo.joindate}</td>
			</tr>
		</c:forEach>
	</table>
	<% session.removeAttribute("addResult"); %>	
</body>
</html>