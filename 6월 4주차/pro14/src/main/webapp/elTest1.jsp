<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elTest1.jsp</title>
</head>
<body>
	<%-- 산술연산자 테스트 --%>
	
	\${100} : ${100}<br>
	\${"안녕하세요"} : ${"안녕하세요"}<br>
	\${'안녕하세요'} : ${'안녕하세요'}<br>
	\${10 + 1} : ${10+1}<br>
	\${"10" + 1} : ${"10" + 1}<br> <%-- 11 --%>
	\${null + 10} : ${null + 10}<br> <%-- 10 --%>
<%-- 	\${"안녕" + 11} : ${"안녕" + 11}<br>  에러 발생 : 숫자로 변환할 수 없는 문자열과 숫자의 + 연산 불가 --%>
<%-- 	\${"hello" + " world"} : ${"hello" + " world"}<br> 에러 발생 : 문자열 간 + 연산 불가 --%>
</body>
</html>