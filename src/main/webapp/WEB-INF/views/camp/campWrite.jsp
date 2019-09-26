<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="title" value="캠핑공간 등록" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<jsp:include page="../include/cssimport.jsp" />
</head>
<body class="animsition">

<jsp:include page="../include/header.jsp" />

	<!-- Title Page -->
	<section class="bg-title-page p-t-50 p-b-40 flex-col-c-m" style="background-image: url(/resources/images/heading-pages-02.jpg);">
		<h2 class="l-text2 t-center">
			Camp
		</h2>
		<p class="m-text13 t-center">
			캠핑공간 등록
		</p>
	</section>
	
	<!-- content page -->
	<section class="bgwhite p-t-66 p-b-60">
		<div class="container">
			<div class="row">

				<div class="col-md-12 p-b-30">
					<form class="leave-comment" action="/CampWebSite/camp/campWrite" method="post" enctype="multipart/form-data">
						<input type="hidden" name="again" id="again-hidden">
						<div class="row">
							<h4 class="m-text26 p-b-36 p-t-15"><strong>공간 정보를 입력해 주세요</strong></h4>
							<p class="p-t-15">( * 필수입력 )</p>
						</div>						
						
						<div class="row">
							<div class="col-md-10">
								<label for="camp_name">공간명<span style="color:red;"> *</span></label>
							</div>
							<div class="p-l-100">
								<span class="option"><span class="txt_count"><em id="campNameCnt">0</em>자/<em>18</em>자</span></span>
							</div>							
						</div>						
						<div class="bo4 of-hidden size15 m-b-20">
							<input class="sizefull s-text7 p-l-22 p-r-22" id="camp_name" type="text" name="campName" placeholder="공간명 " required>
						</div>					
						<p class="p_guide normal">
							<i class="sp_icon ico_alert"></i>사용 가능한 특수문자 : ( , ) , [ , ] , - , .(마침표), ,(쉼표)
						</p>	
						<br><br>
						
						<div class="row">
							<div class="col-md-9">
								<label for="camp_text">공간 소개<span style="color:red;"> *</span></label>
							</div>
							<div class="p-l-100">
								<span class="txt_count"><em id="campContentCnt">0</em>자/<em>500</em>자<span class="txt_guide">(최소 20자)</span></span>
							</div>							
						</div>
						<div class="input">
							<textarea id="camp_text" class="dis-block s-text7 size20 bo4 p-l-22 p-r-22 p-t-13 m-b-20" name="content" required
								placeholder="공간을 상세하게 소개해보세요. 공간의 특징이나 주변환경 등의 세부정보를 작성하시면 효과적입니다."></textarea>
						</div>
						<br>
						
						<div class="row">
							<div class="col-md-10">
								<label>가격<span style="color:red;"> *</span></label>
							</div>
						</div>
						<div class="bo4 of-hidden size15 m-b-20">
							<input class="sizefull s-text7 p-l-22 p-r-22" id="price" type="text" name="price" placeholder="가격 " required>
						</div>


						<div class="w-size25">
							<!-- Button -->
							<button class="flex-c-m size2 bg1 bo-rad-23 hov1 m-text3 trans-0-4">
								Send
							</button>
						</div>
					</form>
				</div>
				
			</div>
		</div>
	</section>

	<!-- Footer -->
	<jsp:include page="../include/footer.jsp" />

	<!-- Back to top -->
	<div class="btn-back-to-top bg0-hov" id="myBtn">
		<span class="symbol-btn-back-to-top">
			<i class="fa fa-angle-double-up" aria-hidden="true"></i>
		</span>
	</div>

	<!-- Container Selection1 -->
	<div id="dropDownSelect1"></div>

	<!-- js import -->
	<jsp:include page="../include/jsimport.jsp" />

</body>
</html>