<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TOTODLE</title>
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
  <h1 class="main"><a href="#" style="position: absolute;top:30px;">Daannnnn</a></h1>
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
        1. [Ajax] 에이작스, 아작스
        [A]synchronous [J]avascript [A]nd [X]ML
        비동기적인       자바스크립트   +   XML         
        =>    XML 데이터(JSON)를 자바스크립트언어   자바스크립트언어
           비동기적으로 처리하는 기술.
        2. 비동기적 ([A]synchronous)?
        페이지 로드된 후에도 웹 서버에서 데이터를 읽어와서 사용 가능.
        페이지 전체가 새로고침 되지 않고 웹 페이지 일부분만 업데이트 가능.
        현재 페이지는 유지된 채로 백그라운드에서 웹 서버와 통신하는 것. 
        
        3.  네이버 메인 페이지의 환율, 증시, 날씨 정보...
        4.    ajax 장점
           성능 향상
           개발 향상
           각각 서버로부터 분산 처리 가능
        5.    ajax 단점
           js 보안적인측면이 취약하다.
           차별화 X
           브라우저 호환성 체크 
        6. js ajax 처리 순서 (과정). 
           1 ) 웹 페이지에서 이벤트 발생.
           2 ) XMLHttpRequest 객체 생성. (비동기 처리할 수 있는 객체 브라우저로부터 갖고 옴)
           3 ) XMLHttpRequest 객체 설정. 
                 ㄱ. 요청 설정
                    open() 메서드 - 요청 필요한 설정
                    
                    A ) get  방식
                    XMLHttpRequest객체.open("GET", "/test.jsp?id=admin",true);
                    XMLHttpRequest객체.send();
                    
                    B ) post 방식
                    XMLHttpRequest객체.open("POST", "/test.jsp",true);
                    XMLHttpRequest객체.send("id=admin")
                    send() 메서드 - 실제 서버에 요청하러 감. 
                 ㄴ. XMLHttpRequest 객체.on readystatechange 이벤트 속성
                    if ( 잘 갔다왔니? 일은 마무리 잘하고 )
                       // 응답 데이터
                       1 ) 텍스트 (JSON)    - responseText 속성
                       2 ) xml          - responseXML 속성
                       
           실습 )    js ajax            ex02.jsp
                 jquery ajax         ex02_02.jsp
        
         
  </xmp>  
</div>

<script>
</script>
</body>
</html>