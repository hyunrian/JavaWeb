<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member2.jsp</title>
</head>
<body>
	아이디 : ${param.id}<br> <%-- request.getParameter하여 출력한 것과 같음 --%>
	비밀번호 : ${param.pwd}<br> <%-- requestScope로는 실행되지 않음(파라미터로 전달된 값. 바인딩되지 않았기 때문) --%>
	이름 : ${param.name}<br>
	이메일 : ${param.email}<br>
	address : ${requestScope.address}<br> <%-- request 영역에서 address라는 이름으로 바인딩된 데이터 출력 --%>
	<%-- forward는 응답하기 전까지는 여러번 forward해도 살아있음 --%>
</body>
</html>