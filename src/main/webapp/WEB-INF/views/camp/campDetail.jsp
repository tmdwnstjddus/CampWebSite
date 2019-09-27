<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="title" value="디테일" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="../include/cssimport.jsp" />
</head>
<body class="animsition">

<jsp:include page="../include/header.jsp" />

	<!-- breadcrumb -->
	<div class="bread-crumb bgwhite flex-w p-l-52 p-r-15 p-t-30 p-l-15-sm">
		<a href="/" class="s-text16">
			홈
			<i class="fa fa-angle-right m-l-8 m-r-9" aria-hidden="true"></i>
		</a>

		<a href="/camp/campList" class="s-text16">
			캠핑장 리스트
			<i class="fa fa-angle-right m-l-8 m-r-9" aria-hidden="true"></i>
		</a>

		<span class="s-text17">
			캠핑장 이름
		</span>
	</div>

	<!-- Product Detail -->
	<div class="container bgwhite p-t-35 p-b-80">
		<div class="flex-w flex-sb">
			<div class="w-size13 p-t-30 respon5">
				<div class="wrap-slick3 flex-sb flex-w">					
					<div class="wrap-slick3-dots">
						<ul class="slick3-dots" role="tablist">
							<c:forEach var="file" items="${ camp.fileList }">
							<li class="" role="presentation">
								<img src="/resources/camp-files/${ file.savedFileName }">
								<div class="slick3-dot-overlay"></div>
							</li>
							<!-- <li role="presentation" class="slick-active">
								<img src=" images/thumb-item-02.jpg ">
								<div class="slick3-dot-overlay"></div>
							</li>
							<li role="presentation" class="">
								<img src=" images/thumb-item-03.jpg ">
								<div class="slick3-dot-overlay"></div>
							</li> -->
							</c:forEach>
						</ul>
						
						<div class="slick3 slick-initialized slick-slider slick-dotted">
							<div class="slick-list draggable">
								<div class="slick-track" style="opacity: 1; width: 1299px;">
									<div class="item-slick3 slick-slide"
										data-thumb="images/thumb-item-01.jpg" data-slick-index="0"
										aria-hidden="true" tabindex="-1" role="tabpanel"
										id="slick-slide10" aria-describedby="slick-slide-control10"
										style="width: 433px; position: relative; left: 0px; top: 0px; z-index: 998; opacity: 0; transition: opacity 500ms ease 0s;">
										<div class="wrap-pic-w">
											<img src="images/product-detail-01.jpg" alt="IMG-PRODUCT">
										</div>
									</div>
									<div class="item-slick3 slick-slide slick-current slick-active"
										data-thumb="images/thumb-item-02.jpg" data-slick-index="1"
										aria-hidden="false" tabindex="0" role="tabpanel"
										id="slick-slide11" aria-describedby="slick-slide-control11"
										style="width: 433px; position: relative; left: -433px; top: 0px; z-index: 999; opacity: 1;">
										<div class="wrap-pic-w">
											<img src="images/product-detail-02.jpg" alt="IMG-PRODUCT">
										</div>
									</div>
									<div class="item-slick3 slick-slide"
										data-thumb="images/thumb-item-03.jpg" data-slick-index="2"
										aria-hidden="true" tabindex="-1" role="tabpanel"
										id="slick-slide12" aria-describedby="slick-slide-control12"
										style="width: 433px; position: relative; left: -866px; top: 0px; z-index: 998; opacity: 0; transition: opacity 500ms ease 0s;">
										<div class="wrap-pic-w">
											<img src="images/product-detail-03.jpg" alt="IMG-PRODUCT">
										</div>
									</div>
								</div>
							</div>
						</div>
						
					</div>
				</div>
			</div>

			<div class="w-size14 p-t-30 respon5">
				<h4 class="product-detail-name m-text16 p-b-13">
					${ camp.campName }
				</h4>
				
				<span class="m-text17">
					${ camp.price }
				</span>
				
				<div class="p-b-45">
					<span class="s-text8">${ camp.category }</span>
				</div>

				<!--  -->          
				<div class="wrap-dropdown-content bo6 p-t-15 p-b-14 active-dropdown-content">
					<h5 class="js-toggle-dropdown-content flex-sb-m cs-pointer m-text19 color0-hov trans-0-4">
						Description
						<i class="down-mark fs-12 color1 fa fa-minus dis-none" aria-hidden="true"></i>
						<i class="up-mark fs-12 color1 fa fa-plus" aria-hidden="true"></i>
					</h5>
<c:set var="enter" value="
" /> 
					<div class="dropdown-content dis-none p-t-15 p-b-23">
						<p class="s-text8">${ fn:replace(camp.content, enter, '<br>') }</p>
					</div>
				</div>

				<div class="wrap-dropdown-content bo7 p-t-15 p-b-14">
					<h5 class="js-toggle-dropdown-content flex-sb-m cs-pointer m-text19 color0-hov trans-0-4">
						Additional information
						<i class="down-mark fs-12 color1 fa fa-minus dis-none" aria-hidden="true"></i>
						<i class="up-mark fs-12 color1 fa fa-plus" aria-hidden="true"></i>
					</h5>

					<div class="dropdown-content dis-none p-t-15 p-b-23">
						<p class="s-text8">
							Fusce ornare mi vel risus porttitor dignissim. Nunc eget risus at ipsum blandit ornare vel sed velit. Proin gravida arcu nisl, a dignissim mauris placerat
						</p>
					</div>
				</div>			
			</div>
			
		</div>
	</div>


	<!-- Relate Product -->
	<section class="relateproduct bgwhite p-t-45 p-b-138">
		<div class="container">
			<div class="sec-title p-b-60">
				<h3 class="m-text5 t-center">
					Reviews
				</h3>
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