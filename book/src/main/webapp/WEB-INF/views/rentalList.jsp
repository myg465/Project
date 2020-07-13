<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 대여 목록</title>
<link rel="stylesheet" type="text/css" href="css/header.css">
<script type="text/javascript" src="js/rental_custom.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="./header.jsp" />
	<section>
		<h2>도서 대여 현황</h2>
		<table border="1" class="bookTable">
			<colgroup>
				<col width="5%" />
				<col width="7%" />
				<col width="13%" />
				<col width="10%" />
				<col width="10%" />
				<col width="10%" />
				<col width="*" />
				<col width="9%" />
				<col width="7%" />
				<col width="5%" />
			</colgroup>
			<tr>
				<th>No.</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>대여일</th>
				<th>반납예정일</th>
				<th>반납일</th>
				<th>대여도서이름</th>
				<th>썸네일</th>
				<th>연체</th>
				<th>반납</th>
			</tr>
			
			<c:forEach var="list" items="${rentalList }">
			<jsp:useBean id="now" class="java.util.Date" />
			<!-- 현재날짜 --> 
			<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="nowDate" /> 
			<fmt:formatDate value="${list.returnExpDate}" pattern="yyyy-MM-dd" var="returnExpDate" />
			<fmt:formatDate value="${list.rentalDate}" pattern="yyyy-MM-dd" var="rentalDate" />
			<fmt:formatDate value="${list.returnDate}" pattern="yyyy-MM-dd" var="returnDate" />
			
				<tr>
					<td>${list.rentalId }</td>
					<td>${list.rentalName }</td>
					<td>${list.rentalPhone }</td>
					<td>${rentalDate }</td>
					<td>${returnExpDate }</td>
					<td>
						<c:if test="${returnDate=='2000-01-01' }">
							반납예정
						</c:if>
						<c:if test="${returnDate!='2000-01-01' }">
							${returnDate }
						</c:if>
					</td>
					<td>${list.bookName }</td>
					<td><img alt="" src="files/${list.filename }" width="80px" height="100px"></td>
					<td>
						<c:if test="${nowDate>returnExpDate || returnDate!='2000-01-01'}">
							√
						</c:if> 
					</td>
					<td><a onclick='returnReg(${list.rentalId})'><button>반납</button></a></td>
				</tr>
			</c:forEach>
			
		
		</table>
		<div class="bottom_btn">
			<a href="rentalWrite"><button>대여등록</button></a>
			<a href="delay"><button>연체자 검색</button></a>
		</div>
	</section>
</body>
</html>