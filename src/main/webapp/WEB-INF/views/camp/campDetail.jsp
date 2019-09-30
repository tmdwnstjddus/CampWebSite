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
<style>
.datepick {
	position: relative;
	border: 0;
	background-color: #704de4;
	color: wheat;
}

.nowDay {
	background: blue;
}

.timepick {
	background: #704de4;
	color: wheat;
}

.calender {
	margin: auto;
	border: 1px solid #ccccff;
	width: -webkit-fill-available;
}

.time {
	text-align: -webkit-center;
	width: 37px;
	height: 37px;
	border-radius: 50px;
}

/* rating */
.starrr {
	display: inline-block;
}

.starrr a {
	font-size: 16px;
	padding: 0 1px;
	cursor: pointer;
	color: #FFD119;
	text-decoration: none;
}
</style>
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
					<div class="wrap-slick3-dots"></div>								
					<div class="slick3">
						<c:forEach var="file" items="${ camp.fileList }">
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
					${ camp.campName }
				</h4>
				
				<span class="m-text17">
					${ camp.price }
				</span>
				
				<%-- 관리자가 로그인했을 시 삭제,수정 버튼 활성화 --%>
				<c:if test="${ loginuser.type eq 'admin' }">
					<div>
						<a class="btn btn-outline-success"
							href="/camp/campUpdate/${ camp.campNo }"
							role="button">수정</a> 
						<a class="btn btn-outline-secondary"
							href="/camp/campDelete/${ camp.campNo }"
							role="button" onclick="return confirm('삭제하시겠습니까?');">삭제</a> 
					</div>
				</c:if>

				<form action="/camp/campRent" method="post" id="rentform">
					<input type="hidden" name="campNo" id="campNo" value="${ camp.campNo }">
					<h5 class="pt-3">날짜 선택</h5>
					<h6 class="px-3 row justify-content-end">
						<select name="year" id="y" onchange="change()" class="border">
							<c:forEach var="y" begin="${ nowYear }" end="${ nowYear+1 }" varStatus="y_status">
								<option <c:if test="${ y eq nowYear }">selected</c:if>>${ y_status.index }</option>
							</c:forEach>
						</select>년도&nbsp;&nbsp;&nbsp; 
						<select name="month" id="m" onchange="change()" class="border">
							<c:forEach var="m" begin="1" end="12" varStatus="m_status">
								<option <c:if test="${ m eq nowMonth }">selected</c:if>>${ m_status.index }</option>
							</c:forEach>
						</select>월
					</h6>
					<!-- // 요일출력 start -->
					<table id="calendar-table" class="calender">
						<tr bgcolor="#ccccff">
							<c:forEach var="week" varStatus="i" items="${ strWeek }">
								<td class="text-center py-1 px-2">
									<font color=<c:choose>
										<c:when test="${ i.index eq 0 }">"red"</c:when>
										<c:when test="${ i.index eq 6 }">"blue"</c:when>
										<c:otherwise>"black"</c:otherwise>
									</c:choose>><b>${ week }</b>
									</font>
								</td>
							</c:forEach>
						</tr>
						<c:forEach var="i" begin="1" end="${ lastDay }">
							<c:if test="${ i eq 1 }">
								<tr>
									<%-- <c:forEach begin="0" end="${ week-1 }">
										<td>&nbsp;</td>
									</c:forEach> --%>
							</c:if>
							<td class="text-center py-1 px-2"
								<c:if test="${ i eq nowDay }">style="background:#e2d6b79e"</c:if>
								<c:if test="${ i < nowDay }">style="background: #a9a9a92e;color: #c1c1c1;"</c:if>
								<c:if test="${ i > nowDay }">style="cursor: pointer;"</c:if>>

								<c:if test="${ i > nowDay }">
									<input type="radio" id="day${i}" name="day" value="${i}"
										hidden="hidden" onclick="javascript:dayCheck(${ i })">
								</c:if> <label for="day${i}" class="date m-0">${i}</label>
							</td>

							<c:if test="${ i eq lastDay }">
								<c:forEach begin="${ week+1 }" end="6">
									<td>&nbsp;</td>
								</c:forEach>
							</c:if>

							<c:set var="week" value="${week+1}" />
							<c:if test="${ week > 6 }">
								<c:set var="week" value="0" />
								</tr>
								<tr>
							</c:if>
						</c:forEach>
						</tr>
					</table>

					<h5 class="pt-4">시간 선택</h5>
					<div class="pt-2 row justify-content-center col-sm-12 m-0" id="time-table">날짜를 먼저 선택해주세요.</div>
					<div class="row justify-content-end">
						<input class="btn btn-primary" type="button" id="rent_submit" name="rent_submit" value="예약" />
					</div>
				</form>

				<div class="p-b-45 mt-5">
					<span class="s-text8">${ camp.category }</span>
				</div>

				<!-- 세부설명 -->          
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