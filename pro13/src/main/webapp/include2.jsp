<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include2.jsp</title>
</head>
<body>
	<h1>include2 - top</h1>
	
	<!-- include_image.jsp -->
 	<!-- 부분 포워드같은 역할. 잠깐 다른페이지로 갔다가 다시 돌아옴 -->
 	<!-- 액션태그 안에 주석을 쓰면 에러 발생함 -->
	<jsp:include page="include_image.jsp">
		<jsp:param value="이미지2" name="name"/>
		<jsp:param value="fox2.png" name="src"/>
	</jsp:include>
	
	<h1>include2 - bottom</h1>
</body>
</html>