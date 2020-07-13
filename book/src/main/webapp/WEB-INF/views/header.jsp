<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<header>
	<c:if test="${authId==null }">
		<script type="text/javascript">
			alert('로그인을 하지 않으셨습니다. 로그인 화면으로 이동합니다.');
			window.location.href='login';
		</script>
	</c:if>
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