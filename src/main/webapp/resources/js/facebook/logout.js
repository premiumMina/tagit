function ckFB(){
	  	FB.getLoginStatus(function(response){
	  		if(response.status=='connected'){
	  			//로그인 되어있으면 로그아웃시킴
				FB.logout();
	  		}else{
	  			console.log(response);
	  			//로그인 안되있으면 로그인 시킴
	  			FB.login(function(response) {
		        }, {scope: 'publish_stream, email, user_birthday, user_likes'}); // <-- 로그인시킬때 권한  	 
	  		}
	  	},
	  	{scope: 'read_stream,publish_stream'}
	  	);
  }