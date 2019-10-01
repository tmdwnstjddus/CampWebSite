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

		<a href="/product/productList?category=all" class="s-text16">
			캠핌용품 리스트
			<i class="fa fa-angle-right m-l-8 m-r-9" aria-hidden="true"></i>
		</a>

		<span class="s-text17">
			캠핑용품 이름
		</span>
	</div>

	<!-- Product Detail -->
	<div class="container bgwhite p-t-35 p-b-80">
		<div class="flex-w flex-sb">
			<div class="w-size13 p-t-30 respon5">
				<div class="wrap-slick3 flex-sb flex-w">
					<div class="wrap-slick3-dots"></div>								
					<div class="slick3">
						<c:forEach var="file" items="${ product.fileList }">
							<div class="item-slick3" data-thumb="/resources/camp-files/${ file.savedFileName }">
								<div class="wrap-pic-w">
									<img src="/resources/camp-files/${ file.savedFileName }" width="500px" height="600px" alt="IMG-PRODUCT">
								</div>
							</div>
						</c:forEach>
					</div>					
				</div>
			</div>

			<div class="w-size14 p-t-30 respon5">
				<h4 class="product-detail-name m-text16 p-b-13">
					${ product.productName }
				</h4>
				
				<span class="m-text17">
					${ product.price }
				</span>
				
				
				
				<%-- 관리자가 로그인했을 시 삭제,수정 버튼 활성화 --%>
				<c:if test="${ loginuser.type eq 'admin' }">
					<div>
						<a class="btn btn-outline-success"
							href="/product/productUpdate/${ product.productNo }"
							role="button">수정</a> 
						<a class="btn btn-outline-secondary"
							href="/product/productDelete/${ product.productNo }"
							role="button" onclick="return confirm('삭제하시겠습니까?');">삭제</a> 
					</div>
				</c:if>
				
				<form name="form1" method="post" action="/cart/insertCart">
		        	<input type="hidden" name="memberId" value="${ loginuser.memberId }">
					<input type="hidden" name="productNo" value="${ product.productNo }">
				
					<div class="flex-r-m flex-w p-t-10">
							<div class="w-size16 flex-m flex-w">
								<div class="flex-w bo5 of-hidden m-r-22 m-t-10 m-b-10">
								
									<!-- 감소버튼 -->
									<button class="btn-num-product-down color1 flex-c-m size7 bg8 eff2">
										<i class="fs-12 fa fa-minus" aria-hidden="true"></i>
									</button>
	
									<input class="size8 m-text18 t-center num-product" type="number" name="amount" value="1">
									
									<!-- 증가버튼 -->
									<button class="btn-num-product-up color1 flex-c-m size7 bg8 eff2">
										<i class="fs-12 fa fa-plus" aria-hidden="true"></i>
									</button>
								</div>
	
								<div class="btn-addcart-product-detail size9 trans-0-4 m-t-10 m-b-10">
									<!-- Button -->
									<button type="submit" class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4">
										Add to Cart
									</button>
								</div>
							</div>
						</div>
						
				</form>
				
				<div class="p-b-45 mt-5">
					<span class="s-text8">${ product.category }</span>
				</div>

				<!-- 세부설명  -->          
				<div class="wrap-dropdown-content bo6 p-t-15 p-b-14 active-dropdown-content">
					<h5 class="js-toggle-dropdown-content flex-sb-m cs-pointer m-text19 color0-hov trans-0-4">
						Description
						<i class="down-mark fs-12 color1 fa fa-minus dis-none" aria-hidden="true"></i>
						<i class="up-mark fs-12 color1 fa fa-plus" aria-hidden="true"></i>
					</h5>
<c:set var="enter" value="
" /> 
					<div class="dropdown-content dis-none p-t-15 p-b-23">
						<p class="s-text8">${ fn:replace(product.content, enter, '<br>') }</p>
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