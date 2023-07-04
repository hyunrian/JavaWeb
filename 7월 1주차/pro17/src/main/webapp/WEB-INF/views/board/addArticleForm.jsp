<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/top.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>
					글쓰기 양식
				</h2>
				<p>
					<a class="btn btn-primary btn-large" href="#">글 목록</a>
				</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="/board/addArticleRun" method="post">
				<div class="form-group">
					 
					<label for="btitle">
						제목
					</label>
					<input type="text" class="form-control" id="btitle" name="btitle" />
				</div>
				<div class="form-group">
					 
					<label for="bcontent">
						내용
					</label>
					<textarea class="form-control" id="bcontent" name="bcontent"></textarea>
					<!-- textarea는 태그 사이의 값이 value -->
				</div>
				<button type="submit" class="btn btn-primary">
					작성하기
				</button>
			</form>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/include/bottom.jsp" %>