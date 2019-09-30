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
		
	<%-- <div>
	       <c:forEach var="report" items="${ reports }" varStatus="status">
             ${ report.memberId }
            </c:forEach>
	</div>
	 --%>
	<div class="container">
		<div id="chart" style="width: 1000px; height: 500px;"></div>
	</div>
	
	
	<!-- Footer -->
	<jsp:include page="../include/footer" />

	<!-- js import -->
	<jsp:include page="../include/jsimport.jsp" />
	
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawVisualization);

      function drawVisualization() {
        var data = google.visualization.arrayToDataTable([
            ['회원 아이디', '이름'],
            <c:forEach var="report" items="${ reports }" varStatus="status">
             ['${ report.memberId }', '${ report.name }'],
            </c:forEach>
            ]);

        var options = {
            title: '회원별 현황',
            subtitle: '통계 년도: 2018-2019'
                
        };

        var chart = new google.charts.Bar(document.getElementById('chart'));
        chart.draw(data, google.charts.Bar.convertOptions(options));
      }
    </script>
</body>
</html>
