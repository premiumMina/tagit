window.fbAsyncInit = function() {
 	FB.init({
 		appId : '1662043397451420',
 		cookie : true,
 		xfbml : true,
 		version : 'v2.7'
 	});
 	
 	FB.Event.subscribe('auth.logout',function(res){
 		FB.logout(function(res){
 			console.log(res);
 		});
 	});
 	
 	
 
 	FB.getLoginStatus(function(response) {
 		
 		statusChangeCallback(response);
 	});
 
 };
 
 function facebookLogin(){
	 FB.login(function(response) {
		    var token = response.authResponse.accessToken;
		    var uid = response.authResponse.userID;
		    if (response.authResponse) {
		    	console.log(response);
		    	FB.api('/me', 'get', { access_token: token }, function(response) {
		        
		      });
		      
		      FB.api('/'+uid, 'get', { access_token: token }, function(response) {
		        console.log(response);
		      });
		    }
		  },{scope:'public_profile,user_posts'}

		  );
 }
 
 /**
  * user status 체크
  * @param response
  * 	로그인 status 결과값
  */
 function statusChangeCallback(response) {
	 
	 
 	if (response.status === 'connected') {
 		
 		/* 로그인 성공 */
 		getUserInfo(response.authResponse.accessToken); 		
 	} else if (response.status === 'not_authorized') {
 		/* 로그인 권한 없음 */
 	} else {
 		/* 그 외의 상태 */
 	}
 }
 
 /**
  * 로그인 상태 검사
  */
 function checkLoginState() {
 	FB.getLoginStatus(function(response) {
 		statusChangeCallback(response);
 });
 }
 
 /**
  * SDK 로드
  */
 (function(d, s, id) {
 	var js, fjs = d.getElementsByTagName(s)[0];
 if (d.getElementById(id))
 		return;
 	js = d.createElement(s);
 	js.id = id;
 	js.src = "//connect.facebook.net/en_US/sdk.js";
 	fjs.parentNode.insertBefore(js, fjs);
 }(document, 'script', 'facebook-jssdk'));