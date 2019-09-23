<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Contact</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<jsp:include page="include/cssimport.jsp" />
</head>
<body class="animsition">

	<!-- Header -->
	<jsp:include page="include/header.jsp" />

	<!-- Title Page -->
	<section class="bg-title-page p-t-40 p-b-50 flex-col-c-m" style="background-image: url(images/heading-pages-06.jpg);">
		<h2 class="l-text2 t-center">
			Rog In	
		</h2>
	</section>

	<!-- content page -->    
	<section class="cart bgwhite p-t-70 p-b-100">
			<div class="container">
				<div>
						<div class="container">
								<div class="login-register-wrapper">
										<div class="login-register-tab-list nav">
											<a class="active" data-toggle="tab" href="#lg1">
												<h4> login </h4>
											</a>
											<a data-toggle="tab" href="#lg2">
												<h4> register </h4>
											</a>
										</div>

										<div class="tab-content">
											<!-- Log In-->
											<div id="lg1" class="tab-pane active">
												<div class="login-form-container">
													<div class="login-form">
														<form action="#" method="post">
															<input type="text" name="user-name" placeholder="Username">
															<input type="password" name="user-password" placeholder="Password">
															<div class="button-box">
																<div class="login-toggle-btn">
																	<input type="checkbox">
																	<label>Remember me</label>
																	<a href="#">Forgot Password?</a>
																</div>
																<div class="p-b-10">
																	<button  type="submit"  class="flex-c-m size9 bg4 bo-rad-20 hov1 m-text3 trans-0-4">
																		<p class="s-text6 " >Log In</p>
																	</button>
																</div>



															</div>
														</form>
													</div>
												</div>
											</div>
											<!-- Register -->
											<div id="lg2" class="tab-pane">
												<div class="login-form-container">
													<div class="login-form">
														<form action="#" method="post">
															<input type="text" name="user-name" placeholder="Username">
															<input type="password" name="user-password" placeholder="Password">
															<input name="user-email" placeholder="Email" type="email">
															<div class="button-box">
																<button  type="submit"  class="flex-c-m size9 bg4 bo-rad-20 hov1 m-text3 trans-0-4">
																	<p class="s-text6 " >Register</p>
																</button>
															</div>
														</form>
													</div>
												</div>
											</div>
										</div>
									</div>
							
						</div>

	
				</div>
			</div>
		</section>

	<!-- Footer -->
	<jsp:include page="include/jsimport" />
	



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
	<jsp:include page="include/jsimport.jsp" />
	


</body>
</html>
