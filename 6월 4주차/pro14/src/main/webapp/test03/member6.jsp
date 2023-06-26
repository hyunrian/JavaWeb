<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member6.jsp</title>
</head>
<body>
	<%-- JSTL 반복문 사용하기 --%>

	<div>
		<%-- for (int i = 1; i <= 10; i++) --%>
		<c:forEach var="i" begin="1" end="10" step="1"> <%-- step은 생략하면 1 --%>
			${i * 10}<br>
		</c:forEach>
	</div>
	
	<hr>
<%
	List<String> list = new ArrayList<>();
	list.add("hello");
	list.add("JSP");
	list.add("JSTL");
	pageContext.setAttribute("list", list);
%>
	<c:set var="list" value="${list}"></c:set>
	<div>
		<%-- for (String str : list) --%>
		<c:forEach var="str" items="${list}" varStatus="status">
			${status.index} - ${status.count} - ${str}<br> 
			<%-- index: 0부터 시작 / count: 1부터 시작 (optional) --%>
		</c:forEach>
	</div>
</body>
</html>