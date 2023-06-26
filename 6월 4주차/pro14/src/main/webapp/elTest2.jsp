<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elTest2.jsp</title>
</head>
<body>
	<%-- 산술연산자 테스트 --%>
	
	\${10 + 10} : ${10 + 10}<br>
	\${10 - 10} : ${10 - 10}<br>
	\${10 * 10} : ${10 * 10}<br>
	\${10 / 10} : ${10 / 10}<br> <%-- 1.0 --%>
	\${10 % 10} : ${10 % 10}<br>
	\${10 div 10} : ${10 div 10}<br> <%-- 1.0 --%>
	\${10 mod 10} : ${10 mod 10}<br>
</body>
</html>