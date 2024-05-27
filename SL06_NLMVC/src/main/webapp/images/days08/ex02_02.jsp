<%@page import="java.util.Date"%>
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
<link rel="stylesheet" href="/jspPro/resources/cdn-main/example.css">
<script src="/jspPro/resources/cdn-main/example.js"></script>
<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }
</style>
</head>
<body>
<header>
  <h1 class="main"><a href="#" style="position: absolute;top:30px;">kenik HOme</a></h1>
  <ul>
    <li><a href="#">로그인</a></li>
    <li><a href="#">회원가입</a></li>
  </ul>
</header>
<h3>
  <span class="material-symbols-outlined">view_list</span> jsp days00
</h3>
<div>
  <xmp class="code">
                     
  </xmp>  
  
   서버 요청 시간 : <%= new Date().toLocaleString() %>
  <br>
  
  
  <input type="button"  value="jquery ajax" />
  <br>
  
  <p id="demo"></p>
  
</div>

<script>

	$( function (){
		$("input").on("click", function(){
			// jquery ajax method : load
			// load 메서드는 읽어온 모든 데이터를 먼저 출력하고
			// 요청이 다시 들어오면 그전 데이터를 삭제하고 다시 출력해준다.
			$("#demo").load(
				'ex02_ajax_info.txt'			// jquery비동기 객체 == jqXHR
				, function( responseText, textStatus, jqXHR){
					if( textStatus == "success" ){
						var rtxt = responseText;
						let names = rtxt.split(",");
						for( let name of names ){
							 $("#demo")
							.append($("<li></li>").text(name)); 
						}
					}else if(textStatus == "error"){
						alert("error");
					}
				}
			);
		
		});
	} );
</script>
</body>
</html>