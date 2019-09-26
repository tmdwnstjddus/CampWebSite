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
	<!-- content page -->
                    <h4 class="m-text20 p-b-36 p-t-15 text-center">주문 내역</h4> 

<div class="work_area">
        <div class="container">
            <div class="bo4">
                <div class="bs-example">
                <ul class="nav nav-tabs bg7">
                    <div class="p-t-15 p-b-14 p-l-22" >
                        <a data-toggle="tab" href="#sectionA" class="toggle-color">
                            <h6 class="s-text4 flex-sb-m cs-pointer color0-hov trans-0-4">캠핑장 예약 내역</h6>
                        </a>
                    </div>
                    <div class="p-t-15 p-b-14 p-l-22" >
                        <a data-toggle="tab" href="#sectionC">
                            <h6 class="s-text4 flex-sb-m cs-pointer color0-hov trans-0-4">용품 구매 내역</h6>
                        </a>
                    </div>

                </ul>
                <div class="tab-content">
                    <div id="sectionC" class="tab-pane fade in active p-t-15 p-b-14">
                        <table class="table-shopping-cart">
							<tr class="table-head">
								<th class="column-1"></th>
								<th class="column-2">주문 날짜</th>
								<th class="column-3">용품 이름</th>
								<th class="column-4">개수</th>
								<th class="column-5">가격</th>
							</tr>
	
							<tr class="table-row">
								<td class="column-1">
									<div class="cart-img-product b-rad-4 o-f-hidden">
										<img src="/resources/images/ran.png" alt="IMG-PRODUCT">
									</div>
								</td>
								<td class="column-2">2019-09-26</td>
								<td class="column-3">빨간색 랜턴</td>
								<td class="column-4">
										1
								</td>
								<td class="column-5">￦22,000</td>
							</tr>

	
						</table>
                    </div>
                    <div id="sectionA" class="tab-pane fade p-t-15 p-b-14">
                    	<table class="table table-hover">
								<thead>
									<tr>
										<th scope="col" colspan="2">예약 날짜</th>		
										<th scope="col" colspan="1">캠핑장 분류</th>																		
										<th scope="col" colspan="1">캠핑장 이름</th>
										<th scope="col">캠핑장 가격</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td colspan="2">2019-09-26</td>				
										<td colspan="1">카라반</td>															
										<td colspan="1">카라반 디럭스</td>
										<td>￦50,000<a href="#" class="badge badge-success">예약 완료</a></td>
									</tr>
								</tbody>
						</table>
					</div>
                                            
                </div>
                </div>
            </div> 
        </div>    
    </div>



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
