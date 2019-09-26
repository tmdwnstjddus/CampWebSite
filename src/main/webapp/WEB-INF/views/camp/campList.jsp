<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<title>Product</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
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
			여러 종류의 캠프방법
		</p>
	</section>


	<!-- Content page -->
	<section class="bgwhite p-t-55 p-b-65">
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-md-4 col-lg-3 p-b-50">
					<div class="leftbar p-r-20 p-r-0-sm">
						<!--  -->
						<h4 class="m-text14 p-b-7">
							Categories
						</h4>
						<form name="selectform" method="GET" action="campKind">
						<ul class="p-b-54">
							<li class="p-t-4">
							<input type="radio" class="s-text13 active1" name="category" value="all" id="all" /><label for="all">ALL</label>
								<!-- <button class="s-text13 active1" id="All" data-category="all">All</button> -->
							</li>

							<li class="p-t-4">
							<input type="radio" class="s-text13 active1" name="category" value="tent" id="tent" <c:if test="${param.category eq 'tent'}"></c:if>/><label for="tent">텐트</label>
								<!-- <button class="s-text13 active1" id="Tent" data-category="tent">텐트</button> -->
								
							</li>

							<li class="p-t-4">
							<input type="radio" class="s-text13 active1" name="category" value="caravan" id="caravan" <c:if test="${param.category eq 'caravan'}"></c:if>/><label for="caravan">카라반</label>
								<!-- <button class="s-text13 active1" id="Cravan" data-category="caravan">카라반</button> -->
								
							</li>

							<li class="p-t-4">
							<input type="radio" class="s-text13 active1" name="category" value="glamping" id="glamping" <c:if test="${param.category eq 'glamping'}"></c:if>/><label for="glamping">글램핑</label>
								<!-- <button class="s-text13 active1" id="Glamping" data-category="glamping">글램핑</button> -->
								
							</li>

							<li class="p-t-4">
								<a href="#" class="s-text13">
									
								</a>
							</li>
						</ul>
						</form>
						<!--  -->
						<h4 class="m-text14 p-b-32">
							Search
						</h4>
						<div class="filter-price p-t-22 p-b-50 bo3">
							<div class="m-text15 p-b-17">
								<c:if test="${loginuser.userType eq 'admin' }">
								 	<a href="pr-write"> <input type="button" value="Write" class="btn btn-dark" style="width:100px"></a>	 
								</c:if>
							</div>

							

							<div class="flex-sb-m flex-w p-t-16">
								

								<div class="s-text3 p-t-10 p-b-10">
									
								</div>
							</div>
						</div>

						<div class="search-product pos-relative bo4 of-hidden">
							
						</div>
					</div>
				</div>

				<div class="col-sm-6 col-md-8 col-lg-9 p-b-50">
					<!--  -->
					<div class="flex-sb-m flex-w p-b-35">
						<div class="flex-w">
							
						</div>

						<span class="s-text8 p-t-5 p-b-5">
							
						</span>
					</div>

					<!-- Product -->
					<div class="row">
					
					<c:forEach var="camp" items="${camps}">
						<div class="col-sm-12 col-md-6 col-lg-4 p-b-50">
							<!-- Block2 -->
							<div class="block2">
								<div class="block2-img wrap-pic-w of-hidden pos-relative block2-labelnew">
									<a href="/camp/campDetail/${camp.campNo}">
										<img src="/resources/images/item-02.jpg" alt="IMG-PRODUCT">
									</a>								
								</div>

								<div class="block2-txt p-t-20">
									<a href="/camp/campDetail/${ camp.campNo }" class="block2-name dis-block s-text3 p-b-5">
										${camp.campName }
									</a>

									<span class="block2-price m-text6 p-r-5">
										${camp.price }
									</span>
								</div>
							</div>
						</div>
					</c:forEach>

						
					</div>

					<!-- Pagination -->
					<div class="pagination flex-m flex-w p-t-26">
						<a href="#" class="item-pagination flex-c-m trans-0-4 active-pagination">1</a>
						<a href="#" class="item-pagination flex-c-m trans-0-4">2</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<jsp:include page="../include/footer.jsp" />

	<!-- Back to top -->
	<div class="btn-back-to-top bg0-hov" id="myBtn">
		<span class="symbol-btn-back-to-top">
			<i class="fa fa-angle-double-up" aria-hidden="true"></i>
		</span>
	</div>

	<!-- Container Selection -->
	<div id="dropDownSelect1"></div>
	<div id="dropDownSelect2"></div>

	<jsp:include page="../include/jsimport.jsp" />
	<script type="text/javascript">	 
	$(function(){
   		
   			
   			/* $('button[data-category]').on('click', function(event) {

   	   			var category = $(this).attr('data-category');
   				$.ajax({
   	   				url:"campKind",
   	   				data: "category=" + category,
   	   				method: "GET",
   	   				success: function(data, status, xhr) {
   	   	   					alert(data);
   	   	   					
   	   	   			}
	   	   			, error: function(xhr, status, err){
						alert(err);
						
		   	   		}
   	   	   		});
   			}); */
   			
		$('#all').on('change', function(event){
			location.href="/camp/campList";
		 			
		 	});
		$('#tent').on('change', function(event){
				this.form.submit();
			});
		$('#caravan').on('change', function(event){
			this.form.submit();
		});
		$('#glamping').on('change', function(event){
			this.form.submit();
		});
   			
   		 			
			});
	
		
	</script>

</body>
</html>
