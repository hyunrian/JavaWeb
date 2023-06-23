<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello.jsp</title>
</head>
<body>
	<%! // 선언문
		String name = "듀크"; // 멤버 필드로 정의
		
		public String getName() { // 멤버 메서드로 정의
			return name;
		}
	%>
	<h1>안녕하세요 <%=name %> 님!</h1> <%-- 표현식 : 값 출력 시 사용. 표현식 안에는 세미콜론 없어야 함 --%>
	<h1>안녕하세요 <%=getName() %> 님!</h1>
	<!--주석입니다1. -> F12 소스보기를 하면 보임(브라우저로 전달)--> 
	<%--주석입니다2. -> 소스보기에서 보이지 않음(브라우저로 전달X)--%>
</body>
</html>