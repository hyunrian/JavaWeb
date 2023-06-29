<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 입력</title>
</head>
<body>
	<form action="/test01/student/addStudent" method="post">
		<h5>학번</h5>
		<input type="number" name="sno"><br>
		<h5>이름</h5>
		<input type="text" name="sname"><br>
		<h5>성별</h5>
		<input type="radio" name="gender" value="M" checked>남자
		<input type="radio" name="gender" value="F">여자
		<h5>전공</h5>
		<select name="major">
			<option value="컴퓨터공학">컴퓨터공학</option>
			<option value="미디어">미디어</option>
			<option value="수학">수학</option>
		</select>
		<h5>학년</h5>
		<input type="number" name="syear"><br>
		<h5>점수</h5>
		<input type="number" name="score"><br>
		<button>완료</button>
	</form>
</body>
</html>