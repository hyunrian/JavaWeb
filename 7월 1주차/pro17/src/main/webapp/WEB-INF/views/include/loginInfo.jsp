<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty sessionScope.loginId}">
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="alert alert-success alert-dismissable">
				<h4>
					안녕하세요, ${sessionScope.loginId}님!
				</h4> <a href="/login/logout" class="alert-link">로그아웃</a>
			</div>
		</div>
	</div>
</div>
</c:if>


