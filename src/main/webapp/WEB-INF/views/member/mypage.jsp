<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html lang="ko">
<head>
	<title>마이페이지</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<jsp:include page="../include/cssimport.jsp" />
	
</head>
<body class="animsition">

	<!-- Header -->
	<jsp:include page="../include/header.jsp" />
	<!-- content page -->
		<div class="container">
		</div>
		
		<div class="mypage_block01_wrap">
			<div class="mypage_block01">
					<img src="/resources/images/person.png" alt="" style="width: 45px; height: 45px">
			${ loginuser.memberId }님의 마이페이지
			</div>
			<br>
				<div class="mypage_block02">
				고객님의 정보 수정 및 각종 내역을 확인 하실 수 있습니다
				</div>
		</div>
	<!-- 마이페이지 카테고리 -->
	<div class="mypage">
		<ul>
			<li style="text-align: center">
				<a href="#" class="p-r-17"> 
					<img src="/resources/images/cart.png" alt="" style="width: 360px; height:360px">
				</a>
				<a href="#" class="p-r-17">
					<img src="/resources/images/order.png" alt="" style="width: 360px; height:360px">
				</a>
				<a href="/member/memberset?memberId=${ loginuser.memberId }">
					<img src="/resources/images/set.png" alt="" style="width: 360px; height:360px">
				</a>								
			</li>
		</ul>
	</div>
	<br><br><br>



	<!-- Footer -->
	<jsp:include page="../include/footer" />





	<!-- Container Selection -->
	<div id="dropDownSelect1"></div>
	<div id="dropDownSelect2"></div>


	<!-- js import -->
	<jsp:include page="../include/jsimport.jsp" />


</body>
</html>
