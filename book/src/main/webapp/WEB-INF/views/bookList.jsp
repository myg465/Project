<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보유 도서 목록</title>
<link rel="stylesheet" type="text/css" href="css/header.css">
</head>
<body>
	<header>
		<ul>
			<li class="menu_btn"><a href="main">메인</a></li>
			<li class="menu_btn"><a href="bookList">도서관리</a></li>
			<li class="menu_btn"><a href="rentalList">대출관리</a></li>
			<li>
				<div id="info">
					<span><strong>${name }</strong>님</span>
					<a href="logout" onclick="return confirm('로그아웃 하시겠습니까?')"><button>로그아웃</button></a>
				</div>
			</li>
		</ul>
		
	</header>
	<section>
		<h2>보유 도서 현황</h2>
		<table border="1" class="bookTable">
			<colgroup>
				<col width="5%" />
				<col width="10%" />
				<col width="15%" />
				<col width="*" />
				<col width="19%" />
				<col width="9%" />
				<col width="10%" />
				<col width="5%" />
			</colgroup>
			<tr>
				<th>No.</th>
				<th>카테고리</th>
				<th>도서명</th>
				<th>도서설명</th>
				<th>저자</th>
				<th>썸네일</th>
				<th>등록일</th>
				<th>수정/<br>삭제</th>
			</tr>
			<c:forEach var="list" items="${bookList }">
			<fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd" var="regDate" />
				<tr>
					<td>${list.bookId }</td>
					<td>${list.category }</td>
					<td>${list.bookName }</td>
					<td>${list.bookDesc }</td>
					<td>${list.author }</td>
					<td><img alt="" src="files/${list.filename }" width="80px" height="100px"></td>
					<td>${regDate }</td>
					<td>
						<a href='#'>
							<button>수정</button>
						</a>
						<br>
						<a href='#'>
							<button>삭제</button>
						</a>
					</td>
				</tr>
			</c:forEach>
			
		
		</table>
		<div class="bottom_btn">
			<a href="bookWrite"><button>도서등록</button></a>
		</div>
	</section>
	
</body>
</html>