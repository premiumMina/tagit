<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script>
<!--$(function(){
	var token = $("#tk").val();	// 세션에 저장된 유저 token get
	console.log(token); 
	// 토큰을 파라미터로 주면서 나의 정보를 가져옴
	FB.api('/me?access_token='+token, function(response) {
		console.log(response);
	});
})-->
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Tagit!!</h1>

<!--  session에 저장된 user정보 get -->
<c:if test="${not empty sessionScope.userLoginInfo }">
     <h2>로그인 성공 </h2>
     
        이름 : <p><c:out value="${sessionScope.userLoginInfo.name}"/></p>
 
     id : <p><c:out value="${sessionScope.userLoginInfo.id}"/></p> 
        
      
     <input id="tk" type="hidden" value="${sessionScope.userLoginInfo.token}" />

</c:if>  
</body>
</html>