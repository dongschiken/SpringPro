<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>index</title>
<!-- <link href="join.css" type="text/css" rel="stylesheet" />
 -->
<link  href='<tiles:getAsString name="css"></tiles:getAsString>' type="text/css" rel="stylesheet"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery-3.7.0.js"></script>
</head>
<body>
	<!-- header 영역 -->
	<tiles:insertAttribute name="header"></tiles:insertAttribute>
	<!-- visual 영역 -->
	<tiles:insertAttribute name="visual"></tiles:insertAttribute>
	<div id="main">
		<div class="top-wrapper clear">
			<!-- content 영역  -->
			<tiles:insertAttribute name="content"></tiles:insertAttribute>
			<!-- navi 영역 -->
			<tiles:insertAttribute name="aside"></tiles:insertAttribute>
		</div>
	</div>
	<!-- footer 영역 -->
	<tiles:insertAttribute name="footer"></tiles:insertAttribute>
</body>
</html>
