<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script>
$(function(){
	var token = $("#tk").val();	// 세션에 저장된 유저 token get
	console.log(token); 
	// 토큰을 파라미터로 주면서 나의 타임라인 정보를 가져옴
	FB.api('/me/feed?access_token='+token, 'GET', { /* feed 호출 */
        fields: "picture, story,likes,link", /* 가져올 정보 */
       limit: 15 /* 개수 제한 */
    }, function(response) {
   	
    	var rawData = response.data;
    	console.log(rawData);
    	rawData.forEach(function(data) {
    		/* 체이닝으로 DOM을 생성한다. */
    		$('<div></div>').append('<img src="' + data.picture +'">')
    		.append('<br/>').append('Story : ' + data.story).appendTo('.timeline');
    	})
	});
})
</script>




<!-- CSS -->
<link rel="stylesheet" type="text/css"
	href="/tagit/resources/css/facebook.css">

<title></title>
</head>
<body>
<input id="tk" type="hidden" value="${sessionScope.userLoginInfo.token}" />
	<!-- 가져온 타임라인의 결과를 뿌려줄 곳 -->
	<div class="timeline"></div>
	
	

</body>
</html>