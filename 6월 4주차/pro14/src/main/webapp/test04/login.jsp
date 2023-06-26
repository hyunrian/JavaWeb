<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <c:set var="contextPath" value="pageContext.request.contextPath" /> --%>
<c:url var="url" value="/test04/result.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
	<form action="${url}">
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="password" name="pwd"><br>
		<button type="submit">로그인</button>
		<button type="reset">다시입력</button>
	</form>
</body>
</html>