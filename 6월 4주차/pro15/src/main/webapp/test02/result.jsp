<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="file1" value="${param.param1}"/>
<c:set var="file2" value="${param.param2}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result.jsp</title>
</head>
<body>
	매개변수1: <c:out value="${file1}"/><br>
	매개변수2: <c:out value="${file2}"/><br>
	<hr>
	<c:if test="${not empty file1}">
		이미지1: <img src="${contextPath}/download.do?fileName=${file1}" alt="그림1-고양이"><br>
	</c:if>
	<c:if test="${not empty file2}">
		이미지2: <img src="${contextPath}/download.do?fileName=${file2}" alt="그림2-여우"><br>
	</c:if>
	<hr>
	파일 내려받기: <a href="${contextPath}/download.do?fileName=${file1}">다운로드</a>
</body>
</html>