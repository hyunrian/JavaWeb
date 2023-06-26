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
		width:200px;
 		text-align:center;
 		vertical-align: middle;
	}
	li{
		list-style-type:none;
		border-bottom: 1px solid;
		vertical-align: middle;
		height: 80px;
	}
	ul{
		display:inline-block;
		vertical-align: middle;
	}
	img{
		margin-top:5px;
	}
</style>
</head>
<body>
<ul>
	<li style="height:50px;">
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