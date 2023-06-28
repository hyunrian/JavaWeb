<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax2.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
// 비동기 작업 - xml 데이터 연동하기 (xml 파싱)
$(document).ready(function() {
	$("#btnGet").click(function() {
		var url = "http://localhost/pro16/ajaxTest2";
		$.get(url, function(rData) {  
			// $.get(url, sData, function(rData) {});
			// 파라미터 : (url, 보내는데이터, 응답을받으면 실행할 함수). 보내는 데이터가 없을 경우 sData 생략 가능
			// rData로 받아올 수 있는 데이터는 서블릿에서 response한 응답 결과임
			// jQuery에서 응답 결과로 받기 위해서는 PrintWriter를 이용한 출력 뿐이라 writer를 사용하는 것
// 			console.log(rData); // 일반 문서(설정된 타입의)
// 			console.log($(rData)); // $()을 사용하면 jQuery 기능 사용 가능
			let books = $(rData).find("book");
// 			console.log(books); // 찾은 book이 모두 들어있음
			books.each(function() { // 향상된 for문과 비슷한 역할
// 				console.log(this); // this : 반복될 객체의 자기 자신
				let title = $(this).find("title").text().trim(); // title의 글자를 얻음
				let writer = $(this).find("writer").text().trim();
				let image = $(this).find("image").text().trim();
				//화면에 보일 html 태그 작성
				let html = ""; 
				html += "<p>" + title + "</p>"
					+ "<p>" + writer + "</p>"
					+ "<img src='" + image + "'>";
// 				console.log(html);
// 				$("#target").html(html); // 태그를 적용해야 하므로 html 타입으로 지정. but 덮어쓰기되어 책이 1권만 나옴
				$("#target").append(html); // append로 덮어쓰기가 아닌 추가되도록 해야 함
			});
		});
	});
});
</script>
</head>
<body>
	<button type="button" id="btnGet">데이터 가져오기</button>
	<div id="target"></div>
</body>

</html>
