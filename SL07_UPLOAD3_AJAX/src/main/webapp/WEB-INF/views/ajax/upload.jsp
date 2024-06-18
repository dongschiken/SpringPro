<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="shortcut icon" href="http://localhost/jspPro/images/SiSt.ico">
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
  <h1 class="main"><a href="#" style="position: absolute;top:30px;">dongs HOme</a></h1>
  <ul>
    <li><a href="#">로그인</a></li>
    <li><a href="#">회원가입</a></li>
  </ul>
</header>
<h3>
  <span class="material-symbols-outlined">view_list</span> spring days00
</h3>
<div>
  <xmp class="code">  
    /ajax/upload.jsp
  </xmp>  
  <form action="" method="post" enctype="multipart/form-data">
  	<div><input type="text" name="output" value="hello world!"></div>
  	<div>
  	<input type="file" name="attach" multiple="multiple">
  	<button id="btnUpload" type="button">ajax upload</button>
  	<script>
  		$(function(){
  			$("#btnUpload").on("click", function(){
  				//alert("xx");
  				/* 자바스크립트 객체 new formData */
  				// 1단계
  				var formData = new FormData();
  				var inputFile = $(":file[name='attach']");
  				var files = inputFile[0].files;
  				//console.log(files);
  				
  				// 2단계
  				for (var i = 0; i < files.length; i++) {
					formData.append("attachList", files[i]);
				} // for
  				
				// 3단계
				$.ajax({
					url : "uploadAjax",
					processData : false,
					contentType : false,
					data : formData,
					type : 'POST',
					success : function(result){
						alert("ajax로 파일 업로드 성공!");
						
					}
				})
  			}) // 클릭 닫기 부분
  		}) // function
  	</script>
  	</div>
  	<div><input type="text" name="wrtier" value="admin"></div>
  	<div><input type="text" name="email" value="admin@naver.com"></div>
  	<div><input type="submit"></div>
  	<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
  </form>
</div>

<script>
</script>
</body>
</html>