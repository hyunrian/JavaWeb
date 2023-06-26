<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elTest3.jsp</title>
</head>
<body>
	<%-- 비교연산자 테스트 --%>
	
	\${10 == 10} : ${10 == 10}<br>
	\${10 eq 10} : ${10 eq 10}<br>
	\${10 != 10} : ${10 != 10}<br>
	\${10 ne 10} : ${10 ne 10}<br>
	\${"hello" == "hello"} : ${"hello" == "hello"}<br> <%-- 표현언어(EL) 안에서는 문자열 비교 == 가능 --%>
	\${"hello" eq "hello"} : ${"hello" eq "hello"}<br> <%-- true --%>
	\${10 < 10} : ${10 < 10}<br> 
	\${10 lt 10} : ${10 lt 10}<br> 
	\${10 > 10} : ${10 > 10}<br> 
	\${10 gt 10} : ${10 gt 10}<br>
	\${10 <= 10} : ${10 <= 10}<br>
	\${10 le 10} : ${10 le 10}<br>
	\${10 >= 10} : ${10 >= 10}<br>
	\${10 ge 10} : ${10 ge 10}<br>
	&lt;h1&gt;은 제목을 표현합니다 <%-- html에서 이런식으로 사용함! --%>
</body>
</html>