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
	<c:if test="${modifyResult==1 }">
	<script type="text/javascript">
		alert('저장이 완료되었습니다.');
		window.location.href='bookList';
	</script>
	</c:if>
	<c:set var="modify" value="${modifyView }" />
	<jsp:include page="./header.jsp" />
	<section>
		<form action="bookModifyOk" method="post" name="bookModifyForm" enctype="multipart/form-data">
			<input type="hidden" name="bookId" value="${modify.bookId }">
			<h2>도서수정</h2>
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
						<input type="text" name="bookName" value="${modify.bookName }" required>
					</td>
					<th>저자명</th>
					<td>
						<input type="text" name="author" value="${modify.author }" required>
					</td>
				</tr>
				<tr>
					<th>카테고리</th>
					<td>
						<input type="text" name="category" value="${modify.category }" required>
					</td>
					<th>이전파일</th>
					<td>
						<input type="hidden" name="orifile" value="${modify.filename }">
						<img alt="" src="files/${modify.filename }" width="80px" height="100px">
					</td>
				</tr>
				<tr>
					<th>새파일</th>
					<td colspan="3">
						<input type="file" name="filename">
					</td>
				</tr>
				<tr>
					<th>도서설명</th>
					<td colspan="3">
						<textarea rows="10" cols="110" name="bookDesc">
${modify.bookDesc }
						</textarea>
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