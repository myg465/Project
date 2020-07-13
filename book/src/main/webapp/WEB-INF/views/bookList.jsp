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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	function bookDelete(bookId){
		if(confirm('정말로 삭제하시겠습니까?')){
			$.ajax({
		        url : "bookDelete",
		        type : "POST",
		        data: JSON.stringify({bookId:bookId}),
		        contentType: "application/json",
		        success : function(data){
		           if(data.result == "ok"){
		        	 alert('삭제가 완료되었습니다.');
		        	 $("#"+bookId).hide();
		           }
		        },
		        error : function(){
		           alert("통신 중 오류가 발생하였습니다. 잠시 후 다시 시도해주세요.\n오류가 반복될 경우, 고객센터로 문의 부탁드립니다.\n(error_code: deleteError)");
		        }
		     });
		}
	}

</script>
</head>
<body>

	<jsp:include page="./header.jsp" />
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
				<tr id="${list.bookId }">
					<td>${list.bookId }</td>
					<td>${list.category }</td>
					<td>${list.bookName }</td>
					<td>${list.bookDesc }</td>
					<td>${list.author }</td>
					<td><img alt="" src="files/${list.filename }" width="80px" height="100px"></td>
					<td>${regDate }</td>
					<td>
						<a href='bookModify?bookId=${list.bookId }'>
							<button>수정</button>
						</a>
						<br>
						<a onclick='bookDelete(<c:out value='${list.bookId}'/>)'>
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