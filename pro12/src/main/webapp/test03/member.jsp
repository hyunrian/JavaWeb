<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="sec02.ex01.*"
    import="java.util.*"
    %>
<%
	String searchName = request.getParameter("name");
	MemberDao dao = MemberDao.getInstance(); // ctrl + space : 자동임포트
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member.jsp</title>
</head>
<body>
	<table border="1">
		<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>이메일</th>
		<th>가입일</th>
		</tr>
	<%
	String id = "";
	String pwd = "";
	String name = "";
	String email = "";
	Date joindate = null;
	List<MemberVo> list = dao.searchByName(searchName);
	System.out.println(list);
	
	for (MemberVo vo : list) {
	%>
		<tr>
			<td><%=vo.getId() %></td>
			<td><%=vo.getPwd() %></td>
			<td><%=vo.getName() %></td>
			<td><%=vo.getEmail() %></td>
			<td><%=vo.getJoindate() %></td>
		</tr>
	<%
	}
	%>
	</table>
</body>
</html>