<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>imageList.jsp</title>
<style>
	span{
		display:inline-block;
		width:300px;
 		text-align:center;
 		height: 100px;
	}
	li{
		list-style-type:none;
		border-bottom: 1px solid;
		vertical-align: middle;
	}
	ul{
		display:inline-block;
		vertical-align: middle;
	}
</style>
</head>
<body>
<ul>
	<li>
		<span>이미지</span>
		<span>이미지 이름</span>
		<span>선택하기</span>
	</li>
	<c:forEach var="i" begin="1" end="10" step="1">
		<li>
			<span>
				<img src="fox.png" width="70">
			</span>
			<span>이미지 이름: fox${i}</span>
			<span><input type="checkbox"></span>
		</li>
	</c:forEach>
</ul>
</body>
</html>