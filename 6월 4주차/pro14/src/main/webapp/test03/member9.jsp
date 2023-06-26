<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member9.jsp</title>
</head>
<body>
<%-- 	아이디 : ${param.id}<br> --%>
<%-- 	비밀번호 : ${param.pwd}<br> --%>
<%-- 	이름 : ${param.name}<br> --%>
<%-- 	이메일 : ${param.email}<br> --%>

	<%-- c:out을 이용하여 사용자가 입력한 <>를 태그가 아닌 글자로 처리 가능 --%>
	아이디 : <c:out value="${param.id}"/><br>
	비밀번호 : <c:out value="${param.pwd}"/><br>
	이름 : <c:out value="${param.name}"/><br>
	이메일 : <c:out value="${param.email}"/><br>
	주소 : <c:out value="${param.address}" default="주소 없음"/><br> 
	<%-- 파라미터로 넘어온 값이 없으면 기본값이 출력 --%>
</body>
</html>