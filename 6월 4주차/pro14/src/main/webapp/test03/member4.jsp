<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="id" value="hong" scope="page"></c:set> <!-- page scope는 생략 가능 -->
<c:set var="pwd" value="1234" scope="page"></c:set>
<c:set var="name" value="${'홍길동'}" scope="page"></c:set> <!-- 표현언어 사용 가능 -->
<c:set var="age" value="${22}" scope="page"></c:set>
<c:set var="height" value="${183}" scope="page"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member4.jsp</title>
</head>
<body>
	<%-- JSTL 조건문 사용하기 (else는 없음) --%>
	
	<%-- if(true) --%>
	<c:if test="${true}">
		<%-- 조건에 해당하면 진행할 내용을 작성 --%>
		항상 참입니다.<br>
	</c:if>
	
	<%-- if(11 == 11) --%>
	<c:if test="${11 eq 11}">
	11과 11은 같다.<br>
	</c:if>
	
	<%-- if(11 != 31) --%>
	<c:if test="${11 ne 31}">
	11과 31은 같지 않다.<br>
	</c:if>
	
	<%-- if(id.equals("hong") && name.equals("홍길동")) --%>
	<c:if test="${id == 'hong' and name eq '홍길동'}">
		아이디는 hong, 이름은 홍길동입니다.<br>
	</c:if>
	
	<%-- if (age == 22) --%>
	<c:if test="${age == 22}">
		${name}의 나이는 ${age}살입니다.<br>
	</c:if>
	
	<%-- if (height > 180) --%>
	<c:if test="${height gt 180}">
		${name}의 키는 180보다 큽니다.<br>
	</c:if>
</body>
</html>