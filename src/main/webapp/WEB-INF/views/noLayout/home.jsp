<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page session="false"%>
<html>
<head>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
 <!-- 페이스북 로그인 관련 스크립트 -->
<script type="text/javascript" src="/tagit/resources/js/facebook/login.js"></script>
 
 <!-- 페이스북에서 유저 정보 및 타임라인을 가져오는 스크립트 -->
 <script type="text/javascript" src="/tagit/resources/js/facebook/userInfo.js"></script>
 
 <!-- CSS -->
 <link rel="stylesheet" type="text/css" href="/tagit/resources/css/facebook.css">
	<title>Home</title>
</head>
<body>
<!-- Controller에서 보낸 오브젝트를 이렇게 받아서 쓴다. -->
 	<h2>${message}</h2>
 	
 	<!-- 로그인 버튼 / Facebook API에서 제공한다. -->
 	<!--<fb:login-button scope="public_profile,email" onlogin="checkLoginState();"></fb:login-button>-->
	<button onclick="facebookLogin()">로그인</button>
	<button onclick="FB.logout();">로그아웃</button>
	
 	<!-- 로그인 결과값이 출력된다. -->
 	<div id="status"></div>
 	
 	<div id="im"></div>
 		
</body>
</html>
