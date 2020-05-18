<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="ko">
	<head>
	  <meta charset="UTF-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <title>상품리스트</title>
	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
	  <link rel="stylesheet" href="css/style.css">
	  <link rel="stylesheet" href="css/product_list.css">
	  <jsp:include page="common/config.jsp"/>
	</head>
	<body>
	  <jsp:include page="common/top-nav.jsp"/>
	  <section>
	    <div id="whole_content_wrap"><!-- 전체 div -->
			<div id="top_menu">
				<h2>COOKIT 메뉴</h2>
			</div>
			<div id="content_top">	<!-- 컨텐츠 상단 -->
				<div id="list_notice">
					<h2>3월 20일 ~ 3월 26일 배송 가능한 메뉴입니다.</h2>
					<p>COOKIT의 주문마감은 오전 7시입니다.</p>
				</div>
				<div id="list_sort"><!-- 메뉴 정렬 -->
					<ul>
					<li>
					<input type="radio" id="list_sort1" checked>
					<label for="list_sort1">신메뉴순</label> | 
					</li>
					<li>
					<input type="radio" id="list_sort1" checked>
					<label for="list_sort1">인기메뉴순</label> | 
					</li>
					<li>
					<input type="radio" id="list_sort1" checked>
					<label for="list_sort1">높은 가격순</label> | 
					</li>
					<li>
					<input type="radio" id="list_sort1" checked>
					<label for="list_sort1">낮은 가격순</label> | 
					</li>
					<li>
					<input type="radio" id="list_s	ort1" checked>
					<label for="list_sort1">만족도순</label> | 
					</li>
					</ul>
				</div>
			</div>
			<div id="product_list">
				<ul>
					<c:forEach var="plist" items="${list }">
						<li>
							<a href="pcontent_view.do?pId=${plist.pId }&rnum=${plist.rnum}&page="> 
								<img alt="${plist.pName }" src="pupload/${plist.pContentimg1 }" id="item_image">
								<div class="item_text_wrap">
									<div class="item_flag">
										<span>NEW</span>
									</div>
									<div class="item_info">
										<span class="item_first" >${plist.pAmount }인분</span> |
										<span class="item_rest">조리 ${plist.pTime }분</span> |
										<span class="item_rest">적당히 매운맛 <i class=""></i> </span> 
									</div>
									<div class="item_name">
										<span>${plist.pName }</span>
									</div>
									<div id="item_price">
										<span class="price_name">핫딜</span>
										<span class="price">
											<fmt:formatNumber value="${plist.pPrice }" pattern="#,###"/> 원
										</span>
										<span class="price_hide">
											<fmt:formatNumber value="${plist.pPrice*1.1 }" pattern="#,###"/> 원
										</span>
									</div>
									<div id="item_review">
										<span class="star">
											<span id="rating_star1"></span>
										</span>
										<span class="reviw_num">리뷰 353</span>
									</div>
								</div>
							</a>
							<div id="item_buttons">
									<button type="button" class="btn_interest"></button>
									<button type="button" class="btn_cart"></button>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>		
		</div>
	    <!-- 하단버튼 -->
		<div id="page-wrap">
		    <ul class="page-num">
		    	<!-- 첫페이지 이동 -->
		      		<a href="plist.do?page=1">
		      	<li class="first"></li>
		      </a>
		      <!-- 이전페이지 이동 -->
		      <c:if test="${page<=1 }">
		      	<li class="prev"></li>
		      </c:if>
		      
		      <c:if test="${page>1 }">
		      		<a href="plist.do?page=${page-1 }">
		      		<li class="prev"></li>
		      	</a>
		      </c:if>
		      
		      <!-- 순차적 페이지 번호 출력 -->
		      <c:forEach var="a" begin="${startpage }" end="${endpage }" step="1">
		      	<c:choose>
					<c:when test="${a==page }">
						<li class="num"  style="background: #dfdfdf ;">
							  <div>${a }</div>
						</li>
					</c:when>
					
					<c:when test="${a!=page }">
			      			<a href="plist.do?page=${a }">
							<li class="num">
								  <div>${a }</div>
							 </li>
						</a>
					</c:when>
				</c:choose>
		      </c:forEach>
		      
		      <!-- 다음페이지 이동 -->
		      <c:if test="${page>=maxpage }">
		      	<li class="next"></li>
		      </c:if>
		      <c:if test="${page<maxpage }">
		     	<a href="pelist.do?page=${page+1 }">
			    	<li class="next"></li>
			    </a>
		      </c:if>
		      
		      <!-- 마지막페이지 이동 -->
		      <a href="plist.do?page=${maxpage }">
		    	  <li class="last"></li>
		      </a>
		    </ul>
	    </div>
	  </section>
	  <jsp:include page="common/footer.jsp"/>
	</body>
</html>