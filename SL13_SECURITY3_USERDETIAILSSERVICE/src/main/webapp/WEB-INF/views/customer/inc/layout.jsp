<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<link href="notice.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
	<!-- header section -->
	<tiles:insertAttribute name="header" />
	<!-- visual section -->
	<tiles:insertAttribute name="visual" />
		<div id="main">
			<div class="top-wrapper clear">
				<!-- content section -->
				<tiles:insertAttribute name="content" />
				<!-- navi section -->
				<tiles:insertAttribute name="aside" />
			</div>
		</div>
		<!-- footer section -->
		<tiles:insertAttribute name="footer" />
	</body>
<script>
	$(".top-wrapper ul a").on("click", function(){
		alert("test");
	});
</script>
</html>
