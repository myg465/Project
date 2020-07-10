<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>BOOK RENTAL SYSTEM</title>
		<link rel="stylesheet" type="text/css" href="css/header.css">
		
	</head>
	<body>
	<c:if test="${authId==null }">
		<script type="text/javascript">
			alert('로그인을 하지 않으셨습니다. 로그인 화면으로 이동합니다.');
			window.location.href='login';
		</script>
	</c:if>
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
			<h1>도서관리 시스템 메인</h1>
			<div id="main_list">
				<h2>test</h2>
				<div class="list_count">testtesttesttesttest</div>
				<div>
					<table border="1">
						<tr>
							<th>회원 아이디</th>
							<th>비밀번호</th>
							<th>이름</th>
							<th>이메일</th>
							<th>주소</th>
							<th>휴대전화</th>
							<th>생년월일</th>
							<th>성별</th>
							<th>뉴스레터 수신여부</th>
							<th>SMS 수신여부</th>
						</tr>
							<tr>
								<td>test</td>
								<td>test</td>
								<td>test</td>
								<td>test</td>
								<td>test</td>
								<td>test</td>
								<td>test</td>
								<td>test</td>
								<td>test</td>
								<td>test</td>
							</tr>
					    </table>
				</div>
			</div>
		</section>
	</body>
</html>