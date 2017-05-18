<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fmt:setBundle basename="${sessionScope.locale}" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<html>
<head>
<title><fmt:message key="admin.title" /></title>
</head>
<link href="css/bootstrap.css" rel="stylesheet">
<body>
<%@include file="locale.jsp"%>
	<div class="col-md-2 col-md-offset-0 left margin:15px">
		<br />
		<pre class="text-center">${user}<fmt:message key="index.hello"/>
		</pre>
		<hr />
		<br />
		<form action="controller" method="post">
			<input type="hidden" name="command" value="show_all_users" /> <input
				type="submit" class="btn btn-default btn-block"
				value="<fmt:message key="button.allusers"/>">
		</form>
		<form action="controller" method="post">
			<input type="hidden" name="command" value="show_all_orders" /> <input
				type="submit" class="btn btn-default btn-block"
				value="<fmt:message key="button.allorders"/>">
		</form>
		<div style="text-align: center">
		<a href="controller?command=logout"><fmt:message
				key="index.logout" /></a>
		</div>
	</div>
	<%@include file="allusers.jsp"%>
	<%@include file="allorders.jsp"%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>