<%@page import="java.util.*"%>
<%@page import="sec02.ex01.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="vo" class="sec02.ex01.MemberVo"/>
<jsp:setProperty name="vo" property="*"/>

<%
	MemberDao dao = MemberDao.getInstance();
	dao.addMember(vo);
	List<MemberVo> list = dao.listMembers();
	request.setAttribute("list", list);
%>

<jsp:forward page="memberList.jsp"/>