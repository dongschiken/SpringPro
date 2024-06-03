<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
      <title> <tiles:getAsString name="title"></tiles:getAsString> </title>
      <link href="${pageContext.request.contextPath}/index.css" type="text/css" rel="stylesheet" />
</head>
<body>
   <!-- header 영역 -->
   <tiles:insertAttribute name="header"></tiles:insertAttribute>
   <div id="main">
      <!-- index페이지 content부분 -->
      <tiles:insertAttribute name="content"></tiles:insertAttribute>
   </div>
   <!-- footer 영역 -->
   <tiles:insertAttribute name="footer"></tiles:insertAttribute>
</body>
</html>