<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/top.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
var loginResult = "${sessionScope.loginResult}";
if (loginResult == "false") alert("로그인 실패");
</script>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>로그인</h2>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="/login/loginRun" method="post">
				<div class="form-group">
					<label for="id">
						아이디
					</label>
					<input type="text" class="form-control" 
						id="id" name="id" value="${cookie.loginId.value}"/>
				</div>
				<div class="form-group">
					<label for="pwd">
						비밀번호
					</label>
					<input type="password" class="form-control" id="pwd" name="pwd"/>
				</div>
				<div class="checkbox">
					 
					<label>
						<input type="checkbox" name="rememberId"
						<c:if test="${not empty cookie.loginId.value}">
							checked
						</c:if>
						/> 아이디 저장
					</label>
				</div> 
				<button type="submit" class="btn btn-primary">
					로그인
				</button>
			</form>
		</div>
	</div>
</div>
<%
	session.removeAttribute("loginResult");
%>
<%@ include file="/WEB-INF/views/include/bottom.jsp" %>