<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// request.setCharacterEncoding("utf-8");
	// 필터 적용(filter.EncodingFilter) 됐으므로 작성할 필요 없음
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member3.jsp</title>
</head>
<body>
	<%-- 표현언어에서 객체에 접근하기 --%>
	
	<jsp:useBean id="vo" class="sec01.ex01.MemberVo"></jsp:useBean>
	<jsp:setProperty property="*" name="vo"/>
	
	<%-- 파라미터로 넘어온 데이터를 객체에 넣은 후 객체에 있는 값을 출력 --%>
	<%-- MemberVo에 getter가 있어야 작동함 --%>
	아이디 : ${vo.id}<br>  <%-- == <%=vo.getId()%> --%>
	비밀번호 : ${vo.pwd}<br>
	이름 : ${vo.name}<br>
	이메일 : ${vo.email}<br>
</body>
</html>