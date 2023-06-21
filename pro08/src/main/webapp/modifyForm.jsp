<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String member = (String)request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modifyForm.jsp</title>
</head>
<body>
	<h1>회원정보 수정</h1>
	<%=member %><br>
	<form action="/pro08/member?command=modifyRun">
		<button type="submit">수정완료</button>
	</form>
</body>
</html>