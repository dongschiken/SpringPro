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
     ex02_ajax_info.txt
     js ajax                
  </xmp>  
  
  서버 요청 시간 : <%= new Date().toLocaleString() %>
  <br>
  
  
  <input type="button"  value="js ajax" onclick="load('ex02_ajax_info.txt')" />
  <br>
  
  <p id="demo"></p>
  
</div>

<script>
	// 비동기 처리 객체 가져오는 함수
	let httpRequest; // XMLHttpRequest객체
	function getXMLHttpRequest(){
		if( window.ActiveXObject ){ // INTERNET EXPLORER
			try{
				return new ActiveXObject("Msxml2.XMLHTTP");
			}catch(e){
				try{
					return new ActiveXObject("Microsoft.XMLHTTP");
				}catch(e){
					return null;
				}
			}
		}else if( window.XMLHttpRequest ){
			return new XMLHttpRequest();
		}else{
			return null;
		}	
	}
	
	function load( url ){
		httpRequest = getXMLHttpRequest();
		httpRequest.onreadystatechange = callback;
		httpRequest.open("GET", url, true);
		httpRequest.send();	
	}
	
	function callback(){
		if( httpRequest.readyState == 4 ){
			if( httpRequest.status == 200 ){
				let rstxt = httpRequest.responseText;
				let names = rstxt.split(',');
				for (let name of names) {
					$("#demo").append($("<li></li>").text(name));
				}
			}
		}
	}
</script>
</body>
</html>