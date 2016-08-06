/**
  * 유저 정보를 가져온다.
  */
 function getUserInfo(accessToken) {
 	FB.api('/me', function(response) {
 		$('#status').append('Thanks for logging in, ' + response.name + '!');
 		console.log("my data");
 		console.log(response);
 		var userInfo = response;
 		userInfo.token = accessToken;
 	
 		
 		$.ajax({
 			url : '/tagit/ajaxUserInfo',
 			method :'POST',
 			contentType : 'application/json;charset=UTF-8',
 			data : JSON.stringify(userInfo),
 			success : function(data){
 				location.href="tiles/home";		// 회원정보를 컨트롤러에 넘기고 성공 했을 경우 home으로 이동
 				alert("성공");
 				
 			},
 			error : function(data){
 				console.log(data);
 				alert("실패");
 			}
 		})
 		
 	});
 }
 
 /**
  * 유저의 타임라인 정보를 가져온다.
  */
 
 function getInfo(){
	FB.api('/me/feed',function(res){
		console.log(res);
	});

 }
 function getUserTimeline() {
	 /*
	 FB.api('/me', {fields: 'picture'}, function(response) {
		  console.log(response);
		  $('#im').append('<img src="' + response.picture.url +'">');
	
		});
	 FB.api('/me', {fields: 'last_name'}, function(response) {
		  console.log(response);
		
	
		});
	*/
 	FB.api('/me/feed', 'GET', { /* feed 호출 */
         fields: "picture, story,likes", /* 가져올 정보 */
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
 } 