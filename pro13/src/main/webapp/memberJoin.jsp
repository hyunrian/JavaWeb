<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberJoin.jsp</title>
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
	<jsp:setProperty property="id" name="vo"/> <%-- property값과 vo 필드에서 작성한 변수명과 동일해야 함 --%>
	<jsp:setProperty property="pwd" name="vo"/>
	<jsp:setProperty property="name" name="vo"/> 
	<jsp:setProperty property="email" name="vo"/> 
	<jsp:setProperty property="joindate" name="vo"/>
	<%
		System.out.println(vo);
	%>
</body>
</html>