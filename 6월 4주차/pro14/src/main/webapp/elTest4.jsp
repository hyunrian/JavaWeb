<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elTest4.jsp</title>
</head>
<body>
	<%-- 논리연산자 테스트 --%>
	
	\${(10 == 10) && (20 == 20)} : ${(10 == 10) && (20 == 20)}<br>
	\${(10 == 10) and (20 == 20)} : ${(10 == 10) and (20 == 20)}<br>
	\${(10 == 10) || (20 == 20)} : ${(10 == 10) || (20 == 20)}<br>
	\${(10 == 10) or (20 == 20)} : ${(10 == 10) or (20 == 20)}<br>
	\${!((10 == 10) or (20 == 20))} : ${!((10 == 10) or (20 == 20))}<br>
	\${not((10 == 10) or (20 == 20))} : ${not((10 == 10) or (20 == 20))}<br>
</body>
</html>