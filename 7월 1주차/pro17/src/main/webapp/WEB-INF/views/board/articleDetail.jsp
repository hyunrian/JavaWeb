<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/top.jsp" %>

<script>
var data = null;
var modifyResult = "${sessionScope.modifyResult}";
var selectedComment = null;
if (modifyResult == "true") alert("수정 완료");
else if (modifyResult == "false") alert("수정 실패");

$(function() {
	
	// 댓글 목록 가져오기
	function getCommentList() {
		var url = "/comment/getCommentList";
		var sData = {
				"bno" : "${boardVo.bno}"
		};
		$.get(url, sData, function(rData) {
			console.log(rData); 
			var jData = JSON.parse(rData); // 사용 가능한 json 형태로 변환
			for (var v = 0; v < jData.length; v++) {
				var tr = "<tr>";
				tr += "<td>" + jData[v].cno + "</td>";
				tr += "<td>" + jData[v].ccontent + "</td>";
				tr += "<td>" + jData[v].id + "</td>";
				tr += "<td>" + jData[v].regdate + "</td>";
				
				var loginId = "${sessionScope.loginId}";
				if (loginId == jData[v].id) { // 해당 사용자가 작성한 댓글인 경우
					tr += "<td><button type='button' class='btn btn-sm btn-warning btn-comment-update'>수정</button></td>";
					tr += "<td><button type='button' class='btn btn-sm btn-danger btn-comment-delete' data-cno='"+ jData[v].cno +"'>삭제</button></td>";
				} else { // 해당 사용자가 작성한 댓글이 아닌 경우
					tr += "<td></td>";					
					tr += "<td></td>";					
				}
				tr += "</tr>";
				$("#commentTable > tbody").append(tr);
			}
		});
	}
	
	getCommentList();
	
	

	// 수정 버튼
	$("#btnModify").click(function() {
		$(this).fadeOut("slow");
		$("#btnModifyOk").fadeIn("slow");
		$(".modifyInput").prop("readonly", false);
	});
	
	// 답글 버튼
	$("#btnReply").click(function() {
		$("#frmReply").submit();
	});
	
	// 삭제 버튼
	$("#btnRemove").click(function() {
		var bno = "${boardVo.bno}"; // jquery에서 jsp의 \${}을 쓰려면 "" 안에 작성해야 함
		// 주석 내에서 표현식 앞에 \를 써야 에러가 발생하지 않음!!
		location.href = "/board/deleteArticle?bno=" + bno 
				+ "&bgroup=${boardVo.bgroup}&bseq=${boardVo.bseq}";
	});
	
	// 댓글 등록 버튼
	$("#btnSendComment").click(function() {
		var ccontent = $("#ccontent").val();
		var url = "/comment/addComment";
		var sData = {
				"ccontent"	: ccontent,
				"bno"		: "${boardVo.bno}"
		};
		$.post(url, sData, function(rData) {
// 			console.log(rData.trim());
			var vData = rData.trim();
			if (vData == "true") {
				$("#commentTable > tbody").empty(); 
				getCommentList();
				// 비우고 가져오지 않으면 기존 목록에서 계속 append됨
			}
		});
	});
	
	
	// 댓글 삭제 버튼
	
	// 비동기 방식으로 추가된 엘리먼트에 대한 이벤트 처리
	// 비동기로 가져온 것은(소스에 없는것) 불러올 수가 없음
	// 해당 엘리먼트가 속하는 소스보기 상태에서 존재하는 엘리먼트에 이벤트를 설정해야 함
// 	$(".btn-comment-delete").click(function() {
// 		console.log("deleted");
// 	}); -> 이렇게 작성하면 작동 안됨
	// 이렇게 작성해야 작동함!
	// on(이벤트종류, 실제대상, 함수)
	$("#commentTable > tbody").on("click", ".btn-comment-delete", function() {
		var that = $(this);
		var cno = that.attr("data-cno");
// 		console.log("cno:" + cno);
		var url = "/comment/delete";
		var sData = { "cno" : cno };
		$.get(url, sData, function(rData) {
// 			console.log("rData:" + rData.trim());
			if (rData.trim() == "true") {
				that.parent().parent().fadeOut("slow"); // 버튼이 속해있는 tr 제거
				// 여기서 \$(this)를 쓰면 버튼이 아니라 .get이 됨
			} 
		});
	});
	
	// 댓글 수정 버튼
	$("#commentTable > tbody").on("click", ".btn-comment-update", function() {
		var cno = $(this).parent().parent().find("td").eq(0).text();
		var ccontent = $(this).parent().parent().find("td").eq(1).text();
		selectedComment = $(this).parent().parent().find("td").eq(1);
// 		console.log("cno:" + cno + ", ccontent:" + ccontent);
		
		$("#modal-ccontent").val(ccontent);
		$("#btnModalSave").attr("data-cno", cno); // 모달창의 저장 버튼에 cno 값 넣기
		
		$("#modal-276743").trigger("click"); // 수정버튼을 클릭했을 때 modal이 실행되도록 트리거 설정
	});
	
	// 모달창 저장 버튼
	$("#btnModalSave").click(function() {
		var url = "/comment/update";
		var cno = $(this).attr("data-cno");
		var ccontent = $("#modal-ccontent").val();
		var sData = {
				"cno" : cno,
				"ccontent" : ccontent
		};
		$.post(url, sData, function(rData) {
// 			console.log(rData);
			if (rData.trim() == "true") { // 공백 처리 필수
				console.log("true!!");
				$("#modal-container-276743").modal("hide");
				selectedComment.text(ccontent);
			}
		});
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

	<!-- 모달창 -->
	<div class="row">
		<div class="col-md-12">
			<a id="modal-276743" href="#modal-container-276743" role="button" 
			 	class="btn" data-toggle="modal" style="display:none;">수정창 모달</a>
			<div class="modal fade" id="modal-container-276743" 
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="myModalLabel">
								댓글 수정
							</h5> 
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<div class="modal-body">
							<input type="text" class="form-control" id="modal-ccontent">
						</div>
						<div class="modal-footer">
							 
							<button type="button" class="btn btn-primary" id="btnModalSave">
								저장
							</button> 
							<button type="button" class="btn btn-secondary" data-dismiss="modal">
								취소
							</button>
						</div>
					</div>
					
				</div>
				
			</div>
			
		</div>
	</div>
	<!-- //모달창 -->
	
	
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
	
	
	<h4 style="margin-top:30px;">Comments</h4>
	
	<!-- 댓글 입력 -->
	<div class="row" style="margin-top:10px;">
		<div class="col-md-11">
			<input type="text" class="form-control" 
				id="ccontent" name="ccontent">
		</div>
		<div class="col-md-1">
			<button type="button" class="btn btn-dark" id="btnSendComment">
				등록
			</button>
		</div>
	</div>
	
	<!-- 댓글 목록 -->
	<div class="row" style="margin-top:10px;">
		<div class="col-md-12">
			<table class="table" id="commentTable">
				<thead>
					<tr>
						<th>#</th>
						<th>내용</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>수정</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%
	session.removeAttribute("modifyResult");
%>
<%@ include file="/WEB-INF/views/include/bottom.jsp" %>