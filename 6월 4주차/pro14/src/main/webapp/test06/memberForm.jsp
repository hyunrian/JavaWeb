<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberForm.jsp</title>
</head>
<body>
	<h3>회원가입</h3>
	<form action="memberAction.jsp" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td colspan="2">
				<button type="submit">가입하기</button>
				<button type="reset">다시입력</button>
				<a href="/pro07/member">목록으로</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>