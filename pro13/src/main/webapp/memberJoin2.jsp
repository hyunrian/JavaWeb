<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberJoin2.jsp</title>
</head>
<body>
	<%--
		MemberVo vo = new MemberVo();
		vo.setId(request.getParameter("id"));
		vo.setId(request.getParameter("pwd"));
		vo.setId(request.getParameter("name"));
		vo.setId(request.getParameter("email"));
		vo.setId(request.getParameter("joindate"));
	--%>
	<jsp:useBean id="vo" class="sec01.ex01.MemberVo"></jsp:useBean>
	<jsp:setProperty property="*" name="vo"/> <%-- property를 *로 지정하면 전체 setter가 동작됨 --%>
	
	아이디 : <jsp:getProperty property="id" name="vo"/><br>
	비밀번호 : <jsp:getProperty property="pwd" name="vo"/><br>
	이름 : <jsp:getProperty property="name" name="vo"/><br>
	이메일 : <jsp:getProperty property="email" name="vo"/><br>
	
</body>
</html>