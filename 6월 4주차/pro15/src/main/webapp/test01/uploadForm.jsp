<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>uploadForm.jsp</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/> <!-- 경로 구하기 -->
	<!-- 파일전송(binary data) 시 method:post
		enctype:multipart/form-data로 지정해야 함 -->
	<form action="${contextPath}/upload.do"
		method="post" enctype="multipart/form-data">
		파일1: <input type="file" name="file1"><br>
		파일2: <input type="file" name="file2"><br>
		매개변수1: <input type="text" name="param1"><br>
		매개변수2: <input type="text" name="param2"><br>
		매개변수3: <input type="text" name="param3"><br>
		<button>업로드</button>
	</form>
</body>
</html>
