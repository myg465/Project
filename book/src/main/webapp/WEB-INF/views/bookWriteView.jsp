<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서등록</title>
<link rel="stylesheet" type="text/css" href="css/header.css">
</head>
<body>
	<c:if test="${writeResult==1 }">
	<script type="text/javascript">
		alert('저장이 완료되었습니다.');
		window.location.href='bookList';
	</script>
	</c:if>
	<jsp:include page="./header.jsp" />
	<section>
		<form action="bookWriteOk" method="post" name="bookForm" enctype="multipart/form-data">
			<h2>도서등록</h2>
			<table border="1" class="bookTable">
				<colgroup>
					<col width="20%" />
					<col width="30%" />
					<col width="20%" />
					<col width="30%" />
				</colgroup>
				<tr>
					<th>도서명</th>
					<td>
						<input type="text" name="bookName" required>
					</td>
					<th>저자명</th>
					<td>
						<input type="text" name="author" required>
					</td>
				</tr>
				<tr>
					<th>카테고리</th>
					<td>
						<input type="text" name="category" required>
					</td>
					<th>썸네일</th>
					<td>
						<input type="file" name="filename" required>
					</td>
				</tr>
				<tr>
					<th>도서설명</th>
					<td colspan="3">
						<textarea rows="10" cols="110" name="bookDesc"></textarea>
					</td>
				</tr>
				
			</table>
			<div class="bottom_btn">
				<input type="submit" value="등록">
				<input type="reset" value="취소">
			</div>
		</form>
	</section>
	
</body>
</html>