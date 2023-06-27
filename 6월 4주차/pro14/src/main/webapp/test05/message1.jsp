<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <fmt:setLocale value="en_US"/> --%>
<fmt:setLocale value="ko_KR"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test05/message1.jsp</title>
</head>
<body>
	<h1>회원 정보</h1>
	<fmt:bundle basename="resource.member">
		이름 : <fmt:message key="mem.name"/><br>
		주소 : <fmt:message key="mem.address"/><br>
		직업 : <fmt:message key="mem.job"/><br>
	</fmt:bundle>
</body>
</html>