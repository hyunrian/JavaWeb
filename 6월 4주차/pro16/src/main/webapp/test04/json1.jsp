<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json1.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
$(function() {
	/* json과 상관없지만 알아놓으면 좋은것
	$("#checkJson").click(function(e) { // e: 이벤트객체
		e.preventDefault(); // 브라우저의 기본 기능을 막음(a태그의 페이지 이동 막기)
		console.log(e);
		let c = confirm("정말 이동하시겠습니까?"); // alert와 비슷하나 사용자가 yes/no 옵션 선택 가능
		
		if (c == true) {
			let href = $(this).attr("href"); // 속성 가져오기
			console.log(href);
			location.href = href;
		} 
	});
	*/
	
	$("#checkJson").click(function(e) {
		e.preventDefault();
		// json 형식의 문자열 만들기
		let jsonStr = '{"name" : ["홍길동", "이순신", "임꺽정"]}'; // name이라는 키, 배열을 값으로 지정
		console.log(jsonStr);
		
		// json형식의 문자열을 Javascript 객체로 변환하기
		let jsonInfo = JSON.parse(jsonStr);
		console.log(jsonInfo);
		
		let output = "<br>회원이름<br>";
		output += "===============<br>";
		let names = jsonInfo.name;
		console.log(names);
		
// 		for (var v = 0; v < names.length; v++) { // 아래 for문과 같은 결과
// 			output += names[v] + "<br>";
// 		}

		for (var v in names) { // 향상된 for문과 비슷한 역할. but 값이 나오는 것이 아니라 인덱스를 구해줌
			output += names[v] + "<br>";
		}
		
		$("#target").html(output);
		
	});
});
</script>
</head>
<body>
	<div><a href="http://www.daum.net" id="checkJson">출력</a></div> 
	<!-- 빈 a태그 : 사용자가 클릭하면 뭔가 작동될 것임을 알게해줌 -->
	<div id="target"></div>
</body>
</html>