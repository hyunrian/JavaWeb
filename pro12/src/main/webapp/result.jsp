<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    	String id = request.getParameter("id"); // 보이진 않지만 HttpRequest/Response가 존재함
    	String pw = request.getParameter("pw");

    	if (id.equals("hong") && pw.equals("1234")) {
			response.sendRedirect("result2.jsp");
		} else {
			response.sendRedirect("result3.jsp");
		}
    	// 화면에 보이지 않을 부분이기 때문에 html 기본 태그 작성할 필요 없음
%>
