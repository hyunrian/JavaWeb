<%@page import="ex03.StudentVo"%>
<%@page import="ex03.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <jsp:useBean id="vo" class="ex03.StudentVo" /> --%>
<%
	String sno = request.getParameter("sno");
	StudentDao dao = StudentDao.getInstance();
	StudentVo vo = dao.get1Student(sno);
	System.out.println(vo);
	request.setAttribute("vo", vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 수정</title>
</head>
<body>
	<form action="/test01/student/updateStudent" method="post">
		<h5>학번</h5>
		<input type="number" name="sno" value="${param.sno}"><br>
		<h5>이름</h5>
		<c:set var="sname" value="${vo.sname}"/>
		<input type="text" name="sname" value="${vo.sname}"><br>
		<h5>성별</h5>
		<c:choose>
			<c:when test="${vo.gender == 'M'}">
				<input type="radio" name="gender" value="M" checked>남자
				<input type="radio" name="gender" value="F">여자
			</c:when>
			<c:otherwise>
				<input type="radio" name="gender" value="M">남자
				<input type="radio" name="gender" value="F" checked>여자
			</c:otherwise>
		</c:choose>
		<h5>전공</h5>
		<select name="major">
			<c:choose>
			<c:when test="${vo.major == '컴퓨터공학'}">
				<option value="컴퓨터공학" selected>컴퓨터공학</option>
				<option value="미디어">미디어</option>
				<option value="수학">수학</option>
			</c:when>
			<c:when test="${vo.major == '미디어'}">
				<option value="컴퓨터공학" >컴퓨터공학</option>
				<option value="미디어" selected>미디어</option>
				<option value="수학">수학</option>
			</c:when>
			<c:otherwise>
				<option value="컴퓨터공학" selected>컴퓨터공학</option>
				<option value="미디어">미디어</option>
				<option value="수학" selected>수학</option>
			</c:otherwise>
		</c:choose>
		</select>
		<h5>학년</h5>
		<input type="number" name="syear" value="${vo.syear}"><br>
		<h5>점수</h5>
		<input type="number" name="score" value="${vo.score}"><br>
		<button>완료</button>
	</form>
</body>
</html>