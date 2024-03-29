<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include/top.jsp" %>

	<%-- 데이터베이스에서 얻은 회원목록 보이기 --%>
	<%-- 
		WEB-INF 폴더는 브라우저에서 찾을 수 없음. 
		브라우저에서 직접 jsp에 요청하지 못하도록. 기능의 분리
	--%>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12" style="margin-top:20px;">
				<div class="jumbotron">
					<h2>
						회원 목록
					</h2>
					<p>
						회원 목록입니다.
					</p>
					<p>
						<a class="btn btn-primary btn-large" 
							href="/member/addMemberForm">회원가입</a>
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>아이디</th>
							<th>비밀번호</th>
							<th>이름</th>
							<th>이메일</th>
							<th>가입일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${list}" varStatus="status"> 
							<tr>
								<td>${status.count}</td>
								<td>${vo.id}</td>
								<td>${vo.pwd}</td>
								<td>${vo.name}</td>
								<td>${vo.email}</td>
								<td>${vo.joindate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
<%@ include file="/WEB-INF/views/include/bottom.jsp" %>