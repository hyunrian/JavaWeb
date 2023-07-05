<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include/top.jsp" %>
<%@ include file="/WEB-INF/views/include/loginInfo.jsp" %>
<script>
var deleteResult = "${sessionScope.deleteResult}";
var loginResult = "${sessionScope.loginResult}";
var hasReply = "${sessionScope.hasReply}";

if (deleteResult == "true") alert("삭제 성공");
else if (deleteResult == "false") alert("삭제 실패");

if (loginResult == "true") alert("로그인 성공");
</script>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>글 목록</h2>
				<p>
					<a class="btn btn-primary btn-large" 
						href="addArticleForm">글쓰기</a>
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
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${list}">
						<c:choose>
							<c:when test="${vo.delete_yn == 'y'}">
								<tr>
									<td colspan="5" 
										style="text-align:center; background-color:#F8F9F9">
										삭제된 게시글입니다.
									</td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr>
									<td>${vo.bno}</td>
									<td>
										<span style="padding-right:${vo.blevel * 30}px"></span>
										<a href="/board/articleDetail?bno=${vo.bno}">
										<c:if test="${vo.blevel > 0}">
											ㄴ
										</c:if>
										${vo.btitle}</a>
									</td>
									<td>${vo.id}</td>
									<td>${vo.regdate}</td>
									<td>${vo.readcount}</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%
	session.removeAttribute("deleteResult");
	session.removeAttribute("loginResult");
%>
<%@ include file="/WEB-INF/views/include/bottom.jsp" %>