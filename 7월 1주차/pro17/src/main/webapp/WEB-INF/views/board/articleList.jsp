<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include/top.jsp" %>
<script>

</script>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>
					글 목록
				</h2>
				<p>
					<a class="btn btn-primary btn-large" href="board/addArticleForm">글쓰기</a>
				</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr>
						<th>
							#
						</th>
						<th>
							제목
						</th>
						<th>
							작성자
						</th>
						<th>
							작성일
						</th>
						<th>
							조회수
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${list}">
						<tr>
							<td>
								${vo.bno}
							</td>
							<td>
								<a href="/board/articleDetail?bno=${vo.bno}">
									${vo.btitle}</a>
							</td>
							<td>
								${vo.id}
							</td>
							<td>
								${vo.regdate}
							</td>
							<td>
								${vo.readcount}
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/include/bottom.jsp" %>