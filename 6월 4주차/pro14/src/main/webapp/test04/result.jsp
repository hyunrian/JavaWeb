<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${param.id == 'admin'}">
			<h1>관리자로 로그인했습니다.</h1>
			<button>회원정보 삭제하기</button>
			<button>회원정보 수정하기</button>
		</c:when>
		<c:when test="${!empty param.id}">
			<h1>환영합니다. ${param.id}님!!!</h1>
		</c:when>
		<c:otherwise>
			아이디를 입력하세요.<br>
			<a href="/pro14/test04/login.jsp">로그인 창</a>
		</c:otherwise>
	</c:choose>

</body>
</html>