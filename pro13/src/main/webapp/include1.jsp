<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%-- 인클루드 액션태그 사용해보기 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include1.jsp</title>
</head>
<body>
	<h1>include1 - top</h1>
	
	<!-- include_image.jsp -->
 	<!-- 부분 포워드같은 역할. 잠깐 다른페이지로 갔다가 다시 돌아옴 -->
 	<!-- 액션태그 안에 주석을 쓰면 에러 발생함 -->
	<jsp:include page="include_image.jsp">
		<jsp:param value="이미지1" name="name"/>
		<jsp:param value="cat.png" name="src"/>
	</jsp:include>
	
	<h1>include1 - bottom</h1>
</body>
</html>