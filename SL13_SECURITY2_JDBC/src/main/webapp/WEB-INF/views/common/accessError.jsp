<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>지뢰찾기</title>
<link rel="shortcut icon" type="image/x-icon" href="http://localhost/images/favicon_mine.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/cdn-main/example.css">
<script src="/resources/cdn-main/example.js"></script>
<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }
</style>
</head>
<body>
<header>
	<h1 class="main"><a href="#" style="position: absolute;top:30px;">Jin Home</a></h1>
	<ul>
		<li><a href="#">로그인</a></li>
		<li><a href="#">회원가입</a></li>
	</ul>
</header>
<h3>
	<span class="material-symbols-outlined">view_list</span>Spring days00
</h3>
<div>
	<pre class="code">  
		
	</pre>
	<div>
     <h1>My Access Denied Page</h1>
     <h2><c:out value="${SPRING_SECURITY_403_EXCEPTION.getMessage()}" /></h2>
     <h2><c:out value="${msg}"/></h2>
     기타 오류 설명 부분
   </div>   
</div>
</body>
<script>
</script>
</html>