<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="scripts/JQuery/JQuery-1.11.1.min.js"></script>
<script type="text/javascript" src="scripts/JQuery/foodportal.js"></script>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
		<tiles:insertAttribute name="header"/>
		<tiles:insertAttribute name="leftmenu" />		
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="rightmenu"/>
    	<tiles:insertAttribute name="footer" />
</body>
</html>
