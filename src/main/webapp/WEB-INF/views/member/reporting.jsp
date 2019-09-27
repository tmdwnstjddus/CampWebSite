<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html lang="ko">
<head>
	<title>레포팅</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<jsp:include page="../include/cssimport.jsp" />
	
</head>
<body class="animsition">

	<!-- Header -->
	<jsp:include page="../include/header.jsp" />
	<!-- content page -->
		
		<div class="container" style="padding-top:50;text-align:center">
		
		<table class="table table-bordered">
			<tr style="background-color: black;height: 50px" class="dark">
				<th style="width: 5%;text-align: center; color:white">아이디</th>
				<th style="width: 5%;text-align: center; color:white">카테고리</th>				
				<th style="width: 5%;text-align: center; color:white">캠핑장 이름</th>
		
			</tr>
			<c:forEach var="report" items="${ report }">
				<tr style="height: 20px; text-align: center">
					<td >
        				${ report.memberId }
       				</td>			
					<td >
        				${ report.category }
       				</td>			
					<td>
						${ report.campName }
					</td>
						
				</tr>
			</c:forEach>
		</table>		
	
		<br></br>
		</div>


	<!-- Footer -->
	<jsp:include page="../include/footer" />





	<!-- Container Selection -->
	<div id="dropDownSelect1"></div>
	<div id="dropDownSelect2"></div>


	<!-- js import -->
	<jsp:include page="../include/jsimport.jsp" />


</body>
</html>
