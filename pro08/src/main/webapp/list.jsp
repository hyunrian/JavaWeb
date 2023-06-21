<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String data = (String)request.getAttribute("data"); // MemberServlet에서 넣어놓은 데이터

	String strResult = request.getParameter("result");
	System.out.println("result:" + strResult);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
<script>
<% 
if (strResult.equals("true")) { // strResult는 위의 자바 코드에서 가져온 것(JS와 상관X)
%>
	alert("성공");
<% 
} else if (strResult.equals("false")) { 
%>
	alert("실패");
<% 
} 
%>
</script>
	
</head>
<body>
	<h1>회원목록</h1>
	<!-- 데이터 -->
	<%=data %><br>
	<a href="/pro08/member?command=addForm">회원가입</a>
</body>
</html>