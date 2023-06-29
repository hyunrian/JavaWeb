<%@page import="ex03.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 관리 시스템</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
$(function() {
	$("#insert").click(function() {
// 		console.log("clicked");
		location.href="/test01/ex03/addStudent.jsp";
	});
	$("#delete").click(function() {
		var sno = prompt("삭제할 학생의 학번을 입력하세요.");
		location.href="/test01/student/deleteStudent?sno=" + sno;
	});
	$("#update").click(function() {
		var sno = prompt("수정할 학생의 학번을 입력하세요.");
		location.href="/test01/ex03/updateStudent.jsp?sno=" + sno;
	});
	
	var str = "";
	if ("${sessionScope.addResult}" == "true") {
		str = "학생 정보 등록 성공";
	} else if ("${sessionScope.addResult}" == "false") {
		str = "학생 정보 등록 실패";
	} else if ("${sessionScope.deleteResult}" == "true") {
		str = "학생 정보 삭제 성공";
	} else if ("${sessionScope.deleteResult}" == "false") {
		str = "학생 정보 삭제 실패";
	} else if ("${sessionScope.updateResult}" == "true") {
		str = "학생 정보 수정 성공";
	} else if ("${sessionScope.updateResult}" == "false") {
		str = "학생 정보 수정 실패"
	} 
		alert(str);
});
</script>
</head>
<body>
	<h1>학생 정보 관리 시스템</h1>
	<button id="insert">등록</button>
	<button id="update">수정</button>
	<button id="delete">삭제</button><br><br>
	
	<hr>
	<br>
	
	<table border="1" width="100%" style="text-align:center">
		<tr>
			<th>#</th>
			<th>학번</th>
			<th>이름</th>
			<th>성별</th>
			<th>전공</th>
			<th>학년</th>
			<th>점수</th>
		</tr>
	<c:forEach var="vo" items="${list}" varStatus="status">
		<tr>
			<td>${status.count}</td>
			<td>${vo.sno}</td>
			<td>${vo.sname}</td>
			<td>
			<c:choose>
				<c:when test="${vo.gender == 'M'}">
					남자
				</c:when>
				<c:otherwise>
					여자
				</c:otherwise>
			</c:choose>
			</td>
			<td>${vo.major}</td>
			<td>${vo.syear}</td>
			<td>${vo.score}</td>
		</tr>
	</c:forEach>
	</table>
<%
session.removeAttribute("addResult");
session.removeAttribute("deleteResult");
session.removeAttribute("updateResult");
%>
</body>
</html>