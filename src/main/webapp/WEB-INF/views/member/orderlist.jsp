<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html lang="ko">
<head>
	<title>예약/주문 내역</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<jsp:include page="../include/cssimport.jsp" />
	
</head>
<body class="animsition">

	<!-- Header -->
	<jsp:include page="../include/header.jsp" />
	<!-- content page -->
                    <h4 class="m-text20 p-b-36 p-t-15 text-center">${ loginuser.memberId }님의 예약/주문 내역</h4> 
                    
<div class="work_area">
        <div class="container">
            <div class="bo4">
                <div class="bs-example">
                <ul class="nav nav-tabs bg7 flex-sa">
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
                    <div id="sectionC" class="tab-pane fade in active">
                        <table class="table-shopping-cart">
							<tr class="table-head">
								<th class="column-1"></th>
								<th class="column-2">주문 날짜</th>
								<th class="column-3">용품 이름</th>
								<th class="column-4">주소</th>
								<th class="column-5">가격</th>
							</tr>
							<c:forEach var="buy" items="${ buys }">  							
							<tr class="table-row">		
								<td class="column-1">
									<div class="cart-img-product b-rad-4 o-f-hidden">
										<img src="/resources/images/ran.png" alt="IMG-PRODUCT">
									</div>								
								</td>														
								<td class="column-2">${ buy.buyDate }</td>
								<td class="column-3">${ buy.name }</td>
								<td class="column-4">
										${ buy.addr1 }${ buy.addr2 }${ buy.addr3 }
								</td>
								<td class="column-5">￦${ buy.price }<a href="/qna/qna" class="badge badge-success">리뷰 남기기</a></td>

							</tr>
							</c:forEach>
						</table>
                    </div>
                    <div id="sectionA" class="tab-pane fade table">                  
                    	<table class="table table-hover text-center">
								<thead>
									<tr>
										<th class="text-center" scope="col" colspan="2">예약 날짜</th>		
										<th class="text-center" scope="col" colspan="1">캠핑장 분류</th>																		
										<th class="text-center" scope="col" colspan="1">캠핑장 이름</th>
										<th class="text-center" scope="col">캠핑장 가격</th>
									</tr>
								</thead>
								<tbody>
								    <c:forEach var="rent" items="${ rents }">  
									<tr>
										<td colspan="2">${ rent.rentDate }</td>				
										<td colspan="1">${ rent.category }</td>															
										<td colspan="1">${ rent.campName }</td>
										<td>${ rent.price }<a href="/qna/qna" class="badge badge-success">리뷰 남기기</a></td>
									</tr>
									</c:forEach>
								</tbody>
						</table>
				</div>
               </div>
              </div>
            </div> 
        </div>    
    </div>
  	<br><br><br>



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
