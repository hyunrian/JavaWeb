<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include/top.jsp" %>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>
					회원 수정 양식
				</h2>
				<p>
					아래 항목을 모두 입력해주세요.
				</p>
				<p>
					<a class="btn btn-primary btn-large" href="/member/listMembers">회원목록</a>
				</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="/member/modifyMemberRun" method="post">
				<div class="form-group">
					<label for="id"> <!-- 아이디라는 글자를 클릭해도 인풋에 포커스 활성화되도록 설정(모바일을 위한 작업) -->
						아이디</label>
					<input type="text" class="form-control" id="id" name="id" value="${vo.id}" readonly/>
				</div>
				<div class="form-group">
					<label for="pwd">패스워드</label>
					<input type="text" class="form-control" id="pwd" name="pwd" value="${vo.pwd}"/>
				</div>
				<div class="form-group">
					<label for="name">이름</label>
					<input type="text" class="form-control" id="name" name="name" value="${vo.name}"/>
				</div>
				<div class="form-group">
					<label for="email">이메일</label>
					<input type="email" class="form-control" id="email" name="email" value="${vo.email}"/>
				</div>
				<button type="submit" class="btn btn-primary">수정완료</button>
			</form>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/include/bottom.jsp" %>