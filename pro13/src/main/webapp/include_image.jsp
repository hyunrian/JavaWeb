<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name"); 
	String src = request.getParameter("src");
	// 어떤 값으로 파라미터가 넘어오는지에 따라 다른 처리를 함
	// -> 파라미터 설정 이름이 같아도 그때그때 맞게 작동
%>
	<h1>include_image : <%=name %></h1>
	<img src="images/<%=src %>">