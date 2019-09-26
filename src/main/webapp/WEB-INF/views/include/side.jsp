<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${ pageContext.request.contextPath }"/>


        <div id="mySidepanel" class="sidepanel">
                <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                <div class="nevpanner"> 
                  <div class="rightbar">
        
                    <!-- 마이페이지 -->
                    <h4 class="m-text23 p-t-56 p-b-34">
                      	카테고리
                    </h4>
                    
        
                    <ul>
                      <li class="p-t-6 p-b-8 bo6">
                        <a href="/member/mypage?memberId=${loginuser.memberId }" class="s-text13 p-t-5 p-b-5">
                          	마이페이지
                        </a>
                      </li>
        
                      <li class="p-t-6 p-b-8 bo7">
                        <a href="#" class="s-text13 p-t-5 p-b-5">
                          2
                        </a>
                      </li>
        
                      <li class="p-t-6 p-b-8 bo7">
                        <a href="#" class="s-text13 p-t-5 p-b-5">
                         3
                        </a>
                      </li>
        
                      <li class="p-t-6 p-b-8 bo7">
                        <a href="#" class="s-text13 p-t-5 p-b-5">
                          4
                        </a>
                      </li>
        
                      <li class="p-t-6 p-b-8 bo7">
                        <a href="#" class="s-text13 p-t-5 p-b-5">
                          5
                        </a>
                      </li>
                    </ul>
        
<!--                     Featured Products
                    <h4 class="m-text23 p-t-65 p-b-34">
                      Featured Products
                    </h4>
        
                    <ul class="bgwhite">
                      <li class="flex-w p-b-20">
                        <a href="product-detail.html" class="dis-block wrap-pic-w w-size22 m-r-20 trans-0-4 hov4">
                          <img src="images/item-16.jpg" alt="IMG-PRODUCT">
                        </a>
        
                        <div class="w-size23 p-t-5">
                          <a href="product-detail.html" class="s-text20">
                            White Shirt With Pleat Detail Back
                          </a>
        
                          <span class="dis-block s-text17 p-t-6">
                            $19.00
                          </span>
                        </div>
                      </li>
        
                      <li class="flex-w p-b-20">
                        <a href="product-detail.html" class="dis-block wrap-pic-w w-size22 m-r-20 trans-0-4 hov4">
                          <img src="images/item-17.jpg" alt="IMG-PRODUCT">
                        </a>
        
                        <div class="w-size23 p-t-5">
                          <a href="product-detail.html" class="s-text20">
                            Converse All Star Hi Black Canvas
                          </a>
        
                          <span class="dis-block s-text17 p-t-6">
                            $39.00
                          </span>
                        </div>
                      </li>
        
                      <li class="flex-w p-b-20">
                        <a href="product-detail.html" class="dis-block wrap-pic-w w-size22 m-r-20 trans-0-4 hov4">
                          <img src="images/item-08.jpg" alt="IMG-PRODUCT">
                        </a>
        
                        <div class="w-size23 p-t-5">
                          <a href="product-detail.html" class="s-text20">
                            Nixon Porter Leather Watch In Tan
                          </a>
        
                          <span class="dis-block s-text17 p-t-6">
                            $17.00
                          </span>
                        </div>
                      </li>
        
                      <li class="flex-w p-b-20">
                        <a href="product-detail.html" class="dis-block wrap-pic-w w-size22 m-r-20 trans-0-4 hov4">
                          <img src="images/item-03.jpg" alt="IMG-PRODUCT">
                        </a>
        
                        <div class="w-size23 p-t-5">
                          <a href="product-detail.html" class="s-text20">
                            Denim jacket blue
                          </a>
        
                          <span class="dis-block s-text17 p-t-6">
                            $39.00
                          </span>
                        </div>
                      </li>
        
                      <li class="flex-w p-b-20">
                        <a href="product-detail.html" class="dis-block wrap-pic-w w-size22 m-r-20 trans-0-4 hov4">
                          <img src="images/item-05.jpg" alt="IMG-PRODUCT">
                        </a>
        
                        <div class="w-size23 p-t-5">
                          <a href="product-detail.html" class="s-text20">
                            Nixon Porter Leather Watch In Tan
                          </a>
        
                          <span class="dis-block s-text17 p-t-6">
                            $17.00
                          </span>
                        </div>
                      </li>
                    </ul> -->
                    <div class="p-t-10 t-right logout-btn">
                    	<button class="btn btn-outline-primary" onclick="location.href='/account/logout'">
							<i class="fa fa-sign-out" aria-hidden="true"></i>
							<span>로그아웃</span>
						</button>
					</div>
                  </div>
                </div>
          </div>
        </div>