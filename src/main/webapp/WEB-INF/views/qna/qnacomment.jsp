<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>

		<!-- 관리자만 가능하게 차후 수정할것 -->
		<c:choose>
			<c:when test="${ true }">
				<div id="Unregistered" class="s-text7 size20 bo4 p-l-22 p-r-22 p-t-13 m-b-25 bg8 t-center">
					<p class="p-t-35 p-b-8">아직 답변이 등록되지않았습니다.</p>
					<!-- eq 관리자 -->
					<c:if test="${ true }">
						<h5>
							<a href="#" id="UnregisteredBtn" class="badge badge-dark">답변달기</a>
						</h5>
					</c:if>
				</div>
				
			<!-- 답변등록 폼 -->
					<div id="answer">
					<form id="answerform">
						<input type="hidden" id="writer" value="${ loginuser.memberId }" />
						<input type="hidden" id="answerQaNo" value=${ qna.qaNo }/>
						<textarea class="dis-block s-text7 size20 bo4 p-l-22 p-r-22 p-t-13 m-b-25 sizefull" id="answerText"></textarea>
		
						<div class="p-b-10 t-right">
							<!-- Button -->
							<button type="button" class="btn btn-secondary" id="answerSubmitButton">답변등록</button>
						</div>
					</form>
					</div>
				
			</c:when>
			<c:otherwise>
				<div class="dis-block s-text7 size25 bo4 p-l-22 p-r-22 p-t-13 m-b-25" name="success-anser"></div>
				<div class="p-b-10 t-right">
					<c:if test="${ true }">
						<button type="button" class="btn btn-secondary"onclick ="location.href ='/qna/qna'">수정</button>
						<button type="button" class="btn btn-secondary" >삭제</button>
					</c:if>
				</div>
			</c:otherwise>
		
		</c:choose>
		

