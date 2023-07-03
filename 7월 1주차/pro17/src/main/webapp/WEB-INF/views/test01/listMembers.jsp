<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include/top.jsp" %>

	<%-- 데이터베이스에서 얻은 회원목록 보이기 --%>
	<%-- 
		WEB-INF 폴더는 브라우저에서 찾을 수 없음. 
		브라우저에서 직접 jsp에 요청하지 못하도록. 기능의 분리
	--%>

<script>
	var addResult = "${sessionScope.addResult}";
	var modifyResult = "${sessionScope.modifyResult}";
	var deleteResult = "${sessionScope.deleteResult}";

	if (addResult == "true") alert("회원가입 성공");
	else if (addResult == "false") alert("회원가입 실패");
	
	if (modifyResult == "true") alert("회원정보 수정 성공");
	else if (modifyResult == "false") alert("회원정보 수정 실패");
	
	if (deleteResult == "true") alert("회원정보 삭제 성공");
	else if (deleteResult == "false") alert("회원정보 삭제 실패");
	
$(function() {
	// 수정버튼
	$(".btn-modify").click(function() {
		// 클릭한 버튼(this)의 부모(td)의 부모(tr) -> 아이디가 있는 td 찾기(1번째 td)(0부터 시작)
// 		var v = $(this).parent().parent().find("td").eq(1).text();
		// 사용자 정의 속성으로 id 얻기
		var id = $(this).attr("data-id");
		console.log(id);
		location.href="/member/modifyMemberForm?id=" + id;
	});
	// 삭제버튼
	$(".btn-remove").click(function() {
		var id = $(this).attr("data-id");
		console.log(id);
		location.href="/member/deleteMemberRun?id=" + id;
	});
});
</script>
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
						<th>수정</th>
						<th>삭제</th>
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
							<td><button type="button" 
								class="btn btn-success btn-modify" data-id="${vo.id}">수정</button></td>
								<!-- data-XXX : 사용자 정의 속성. 보관하고 싶은 데이터를 넣을 수 있음 -->
							<td><button type="button" 
								class="btn btn-danger btn-remove" data-id="${vo.id}">삭제</button></td>
								<!-- button의 클래스가 총 3개인 것 -->
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<% 
	session.removeAttribute("addResult"); 
	session.removeAttribute("modifyResult"); 
	session.removeAttribute("deleteResult"); 
%>
<%@ include file="/WEB-INF/views/include/bottom.jsp" %>