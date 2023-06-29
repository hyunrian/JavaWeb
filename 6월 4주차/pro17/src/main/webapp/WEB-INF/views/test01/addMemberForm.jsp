<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include/top.jsp" %>

<h1>회원 가입 양식</h1>
<form action="/member/addMemberRun" method="post">
	<button>가입완료</button>
</form>
<%@ include file="/WEB-INF/views/include/bottom.jsp" %>