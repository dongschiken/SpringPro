<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Main Page - ${ user }
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p>${ username }</p>
<h3><a href="/time">/time</a></h3>
</body>
</html>
