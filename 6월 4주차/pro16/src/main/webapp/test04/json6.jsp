<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>json5.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
$(function(){
	$("#checkJson").click(function(e) {
		e.preventDefault();
		let sData = { 
				"name" : "박지성", 
				"age" : 25,
				"gender" : "남자",
				"nickname" : "날쌘돌이"
		}; // 새로운 객체 클래스를 생성해서 new MemberVo("박지성", 25, ..) 형태로는 전달할 수 없음(서블릿에서 String으로 변환 불가)
		
		$.get("/pro16/json2", sData, function(rData) {
			
		});
	});
});
</script>
</head>
<body>
	<span><a href="http://www.naver.com" id="checkJson">출력</a></span><br><br>
	<div id="target"></div>
</body>
</html>