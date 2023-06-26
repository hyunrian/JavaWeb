<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="id" value="hong" scope="page"></c:set> <!-- page scope는 생략 가능 -->
<c:set var="pwd" value="1234" scope="page"></c:set>
<c:set var="name" value="${'홍길동'}" scope="page"></c:set> <!-- 표현언어 사용 가능 -->
<c:set var="age" value="${22}" scope="page"></c:set>
<c:set var="height" value="${183}" scope="page"></c:set>

<c:remove var="age"/> <%-- 선언된 변수 제거 --%>
<c:remove var="height"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member3.jsp</title>
</head>
<body>
	<%-- JSTL 사용하기 (JSTL jar 파일을 추가해야 사용 가능)--%>
	
	아이디 : ${id}<br> <%-- c:set에서 설정한 var과 동일하게 작성 --%>
	비밀번호 : ${pwd}<br>
	이름 : ${name}<br>
	나이 : ${age}<br>
	키 : ${height}<br>
</body>
</html>