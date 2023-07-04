<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/top.jsp" %>
<script>
var modifyResult = "${sessionScope.modifyResult}";
if (modifyResult == "true") alert("수정 완료");
else if (modifyResult == "false") alert("수정 실패");
$(function() {
	$("#btnModify").click(function() {
		$(this).fadeOut("slow");
		$("#btnModifyOk").fadeIn("slow");
		$(".modifyInput").prop("readonly", false);
	});
	
	$("#btnReply").click(function() {
		$("#frmReply").submit();
	});
	
	$("#btnRemove").click(function() {
		var bno = "${boardVo.bno}"; // jquery에서 jsp의 \${}을 쓰려면 "" 안에 작성해야 함
		// 주석 내에서 표현식 앞에 \를 써야 에러가 발생하지 않음!!
		location.href = "/board/deleteArticle?bno=" + bno 
				+ "&bgroup=${boardVo.bgroup}&bseq=${boardVo.bseq}";
	});
	
});
</script>

<!-- 답글 정보 전송을 위한 폼 만들기 -->
<form id="frmReply" action="/board/replyForm" method="get">
	<input type="hidden" name="bgroup" value="${boardVo.bgroup}">
	<input type="hidden" name="bseq" value="${boardVo.bseq}">
	<input type="hidden" name="blevel" value="${boardVo.blevel}">
</form>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>
					상세보기
				</h2>
				<p>
					<a class="btn btn-primary btn-large" 
						href="/board/getList">글 목록</a>
				</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="/board/modifyArticleRun" method="post">
				<input type="hidden" name="bno" value="${boardVo.bno}">
				<div class="form-group">
					 
					<label for="btitle">
						제목
					</label>
					<input type="text" class="form-control modifyInput" id="btitle" 
						 name="btitle" value="${boardVo.btitle}" readonly/>
				</div>
				<div class="form-group">
					 
					<label for="bcontent">
						내용
					</label>
					<textarea class="form-control modifyInput" id="bcontent" 
						name="bcontent" readonly>${boardVo.bcontent}</textarea>
					<!-- textarea는 태그 사이의 값이 value -->
				</div>
				<div class="form-group">
					 
					<label for="id">
						아이디
					</label>
					<input type="text" class="form-control" 
						id="id" value="${boardVo.id}" readonly/>
				</div>
				<div class="form-group">
					 
					<label for="regdate">
						작성일
					</label>
					<input type="text" class="form-control"  
						value="${boardVo.regdate}" readonly/>
				</div>
				<div class="form-group">
					 
					<label for="readcount">
						조회수
					</label>
					<input type="text" class="form-control" 
						value="${boardVo.readcount}" readonly/>
				</div>
				<button type="button" class="btn btn-warning" 
					id="btnModify">수정</button>
				<button type="submit" class="btn btn-success" style="display:none;" 
					id="btnModifyOk">수정완료</button>
				<button type="button" class="btn btn-info" 
					id="btnReply">답글</button>
				<button type="button" class="btn btn-danger" 
					id="btnRemove">삭제</button>
			</form>
		</div>
	</div>
</div>
<%
	session.removeAttribute("modifyResult");
%>
<%@ include file="/WEB-INF/views/include/bottom.jsp" %>