<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html lang="ko">
<head>
	<title>Contact</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<jsp:include page="../include/cssimport.jsp" />
	
</head>
<body class="animsition">

	<!-- Header -->
	<jsp:include page="../include/header.jsp" />
	<!-- Title Page -->
	<section class="bg-title-page p-t-40 p-b-50 flex-col-c-m" style="background-image: url(images/heading-pages-06.jpg);">
		<h2 class="l-text2 t-center">
			MyPage
			
		</h2>
	</section>

	<!-- content page -->
	<section class="bgwhite p-t-66 p-b-60">
		<div class="container">
			<div>
                <div class="row2">
                    <h4 class="m-text26 p-b-36 p-t-15">Name</h4> 
                </div>
                    <!-- Button -->
                        <form class="leave-comment">
                            <!-- Edit Password start -->
                            <div class="p-t-15 p-b-14">
                                
                                <p class="flex-c-m size4 bg5 bo-rad-2 hov3 m-text2 flex-sb-m" > 
                                    Personal Information 
                                    
                                </p>
                                <div class="p-t-15 p-b-23">
                                    <div class="widget">
                                        <p class="m-text2 flex-sb-m p-b-10"> Edit Password </p>
                                        <p> Current Password </p>
                                        <div class="bo4 of-hidden size15 m-b-20">
                                            <input class="sizefull s-text7 p-l-22 p-r-22" type="text" name="email" >
                                        </div>
                                        <p> New Password </p>
                                        <div class="bo4 of-hidden size15 m-b-20">
                                                <input class="sizefull s-text7 p-l-22 p-r-22" type="text" name="email">
                                        </div>
                                        <p> Confirm New Password </p>
                                        <div class="bo4 of-hidden size15 m-b-20">
                                                <input class="sizefull s-text7 p-l-22 p-r-22" type="text" name="email">
                                        </div>

                                        <p class="m-text2 flex-sb-m p-b-10"> Edit Email </p>
                                        <p> Current Email </p>
                                        <div class="bo4 of-hidden size15 m-b-20">
                                            <input class="sizefull s-text7 p-l-22 p-r-22" type="text" name="email" >
                                        </div>
                                        <p> New Email </p>
                                        <div class="bo4 of-hidden size15 m-b-20">
                                                <input class="sizefull s-text7 p-l-22 p-r-22" type="text" name="email">
                                        </div>
                                            
                                            <div class="p-b-10 float-r">
                                                    <!-- Button -->
                                                <button class="flex-c-m size9 bg4 bo-rad-20 hov1 m-text3 trans-0-4 btn-primary" type="button" data-toggle="modal" data-target="#myModal">
                                                    <p class="s-text6 " >Edit Information</p>
                                                </button>
                                            </div>
                                    </div>
                                </div>
                            </div>
					</form>
					
				  <!-- Modal -->
				  
					<div class="modal fade swal-overlay swal-overlay--show-modal" id="myModal" role="dialog" aria-labelledby="myModalLabel" >
						<div class="modal-dialog modal-lg" role="document">
						  <div class="modal-content">
							<div class="modal-header">
							  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						   </div>
						   <form class="leave-comment">
							<!-- Edit Password start -->
								<div class="p-t-15 p-b-35">
								
									<p class="flex-c-m size4 bg5 bo-rad-2 hov3 m-text2 flex-sb-m" > 
										Edit Personal Information 
									</p>
									<div class="p-t-15 p-b-23 p-l-15 p-r-15">
									<div>
										<p class="m-text2 flex-sb-m p-b-10"> Edit Password </p>
										<p> Current Password </p>
										<div class="bo4 of-hidden size15 m-b-20">
											<input class="sizefull s-text7 p-l-22 p-r-22" type="text" name="email" >
										</div>
										<p> New Password </p>
										<div class="bo4 of-hidden size15 m-b-20">
												<input class="sizefull s-text7 p-l-22 p-r-22" type="text" name="email">
										</div>
										<p> Confirm New Password </p>
										<div class="bo4 of-hidden size15 m-b-20">
												<input class="sizefull s-text7 p-l-22 p-r-22" type="text" name="email">
										</div>

										<p class="m-text2 flex-sb-m p-b-10"> Edit Email </p>
										<p> Current Email </p>
										<div class="bo4 of-hidden size15 m-b-20">
											<input class="sizefull s-text7 p-l-22 p-r-22" type="text" name="email" >
										</div>
										<p> New Email </p>
										<div class="bo4 of-hidden size15 m-b-20">
												<input class="sizefull s-text7 p-l-22 p-r-22" type="text" name="email">
										</div>
											
										<!-- Button -->
										<div class="p-b-10 float-r">
											<button class="flex-c-m size9 bg4 bo-rad-20 hov1 m-text3 trans-0-4 btn-primary" type="button" data-toggle="modal" data-target="#myModal">
												<p class="s-text6 " >SAVE</p>
											</button>
										</div>
										</div>
								</div>

							</form>	
						</div>
					</div>
					  
                        
				</div>
			</div>
		</div>

<div class="work_area">
        <div class="container">
            
            <h4 class="m-text15 p-t-15"> My Order </h5>
            <div class="bo4">
                <div class="bs-example">
                <ul class="nav nav-tabs bg7">
                    <div class="p-t-15 p-b-14 p-l-22" >
                        <a data-toggle="tab" href="#sectionA" class="toggle-color">
                            <h6 class="s-text4 flex-sb-m cs-pointer color0-hov trans-0-4">Order1</h6>
                        </a>
                    </div>
                    <div class="p-t-15 p-b-14 p-l-22">
                        <a data-toggle="tab" href="#sectionB">
                            <h6 class="s-text4 flex-sb-m cs-pointer color0-hov trans-0-4">Order2</h6>
                        </a>
                    </div>
                    <div class="p-t-15 p-b-14 p-l-22" >
                        <a data-toggle="tab" href="#sectionC">
                            <h6 class="s-text4 flex-sb-m cs-pointer color0-hov trans-0-4">Order3</h6>
                        </a>
                    </div>

                </ul>
                <div class="tab-content">
                    <div id="sectionA" class="tab-pane fade in active p-t-15 p-b-14">
                        <table class="table-shopping-cart">
							<tr class="table-head">
								<th class="column-1"></th>
								<th class="column-2">Product</th>
								<th class="column-3">Price</th>
								<th class="column-4 p-l-70">Quantity</th>
								<th class="column-5">Total</th>
							</tr>
	
							<tr class="table-row">
								<td class="column-1">
									<div class="cart-img-product b-rad-4 o-f-hidden">
										<img src="images/item-10.jpg" alt="IMG-PRODUCT">
									</div>
								</td>
								<td class="column-2">Men Tshirt</td>
								<td class="column-3">$36.00</td>
								<td class="column-4">
									<div class="flex-w bo5 of-hidden w-size17">
										<button class="btn-num-product-down color1 flex-c-m size7 bg8 eff2">
											<i class="fs-12 fa fa-minus" aria-hidden="true"></i>
										</button>
	
										<input class="size8 m-text18 t-center num-product" type="number" name="num-product1" value="1">
	
										<button class="btn-num-product-up color1 flex-c-m size7 bg8 eff2">
											<i class="fs-12 fa fa-plus" aria-hidden="true"></i>
										</button>
									</div>
								</td>
								<td class="column-5">$36.00</td>
							</tr>

	
						</table>
                    </div>
                    <div id="sectionB" class="tab-pane fade p-t-15 p-b-14 p-l-22">
                        <h3>Order2</h3>
                        <p>Vestibulum nec erat eu nulla rhoncus fringilla ut non neque. Vivamus nibh urna, ornare id gravida ut, mollis a magna. Aliquam porttitor condimentum nisi, eu viverra ipsum porta ut. Nam hendrerit bibendum turpis, sed molestie mi fermentum id. Aenean volutpat velit sem. Sed consequat ante in rutrum convallis. Nunc facilisis leo at faucibus adipiscing.</p>
                    </div>
                    <div id="sectionC" class="tab-pane fade p-t-15 p-b-14">
                    	<table class="table table-hover">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th scope="col" colspan="2">ë¬¸ìì¬í­ ì ëª©ë¤ì´ê° ìë¦¬</th>
										<th scope="col">ëµë³ì¬ë¶</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td colspan="2">ì ëª©1 </td>
										<td>ëµë³ëê¸° <a href="#" class="badge badge-success">ìë£</a></td>
									</tr>
									<tr>
										<td>2</td>
										<td colspan="2" >ì ëª©2</td>
										<td>ëµë³ìë£ <a href="#" class="badge badge-danger">ëê¸°</a> </td>
									</tr>

								</tbody>
						</table>
					</div>
                                            
                </div>
                </div>
            </div> 
        </div>    
    </div>

</section>



	<!-- Footer -->
	<jsp:include page="../include/footer" />



	<!-- Back to top -->
	<div class="btn-back-to-top bg0-hov" id="myBtn">
		<span class="symbol-btn-back-to-top">
			<i class="fa fa-angle-double-up" aria-hidden="true"></i>
		</span>
	</div>

	<!-- Container Selection -->
	<div id="dropDownSelect1"></div>
	<div id="dropDownSelect2"></div>


	<!-- js import -->
	<jsp:include page="../include/jsimport.jsp" />


</body>
</html>
