
function returnReg(rentalId_){
	
	var rentalId=encodeURI(rentalId_);
	if(confirm('반납등록을 하시겠습니까?')){
	  $.ajax({
	        url : "returnReg",
	        type : "POST",
	        data: JSON.stringify({rentalId:rentalId}),
	        contentType: "application/json",
	        success : function(data){
	        	console.log(data.result);
	        	var result=data.result;
	           if(result == 'yes'){
	        	   alert(rentalId+'번 도서를 반납등록 하였습니다.');
	        	   location.reload();
	           }
	           
	        },
	        error : function(){
	           alert("통신 중 오류가 발생하였습니다. 잠시 후 다시 시도해주세요.\n오류가 반복될 경우, 고객센터로 문의 부탁드립니다.\n(error_code: updateError)");
	        }
	     }); 
	}
	
}