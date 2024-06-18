<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>
   #list th:nth-child(1) { width: 150px; }
   #list th:nth-child(2) { width: auto; }
   #list td:nth-child(1) { text-align: center; }
</style>
</head>
<body>
   <!-- list.jsp -->
   <h1>Elasticsearch <small>List</small></h1>

   <div class="seperate">
      <span></span>
      <button type="button" class="add" onclick="location.href='/es/add';">문서추가하기</button>
   </div>

    <table id="list">
      <tr>
         <th>(문서)아이디</th>
         <th>메시지</th>
      </tr>
      <!-- <tr>
         <td></td>
         <td></td>
      </tr> -->
      <c:forEach items="${list}" var="map">
      <tr>
         <td>${map.id}</td>
         <td>${map.message}</td>
      </tr>
      </c:forEach><c:forEach items="${list}" var="map">
      <tr>
         <td>${map.id}</td>
         <td>${map.message}</td>
      </tr>
      </c:forEach>
   </table>
   
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

</script>
</body>
</html>