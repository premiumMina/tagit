<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script>
$(function(){
	$('#default_btn').click(function(){	/*버튼을 클릭하면 발생하는 이벤트 함수*/
		getUserWithAjax();
	});
	
	function getUserWithAjax(){ /*/tagit/ajaxTest 이라는 url로 get 방식으로 json 데이타를 요청 성공하면 success 콜백함수에 데이터 반환*/
		$.ajax({
 			url : '/tagit/ajaxTest', /* Controller에서 받아줄 URL */
 			method : 'GET', /* GET과 POST의 차이는? */
 			dataType:'json',
 			complete : function(data) {
 				/* 완료한 경우 */
 				alert('Complete!');
 			},
 			success : function(data) {
 				/* 성공한 경우 */
 				$('#p1').append(data.name);
 			},
 			error : function(data) {
 				alert("실패");
 				/* 실패한 경우  */
 			}
 		})
	 }
	
	
});


</script>
</head>
<body>
	<button type="button" id="default_btn" class="btn btn-default">디폴트</button>
	<p id="p1"></p>
</body>
</html>