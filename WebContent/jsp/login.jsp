<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if
	test="${sessionScope.locale == 'locale_ru_RU' or empty sessionScope.locale}">
	<fmt:setBundle basename="locale_ru_RU" />
</c:if>
<c:if test="${sessionScope.locale == 'locale_en_US'}">
	<fmt:setBundle basename="locale_en_US" />
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><fmt:message key="index.login" /></title>
<link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<form action="controller" method="POST" style="margin: 15px">
		<input type="hidden" name="command" value="change_locale" />
		<button type="submit" class="btn btn-primary btn-xs">
			<fmt:message key="index.locale" />
		</button>
	</form>

	<div class="col-md-3 col-md-offset-0 left">
		<form name="loginForm" method="POST" action="controller">
			<div class="form-group">
				<input type="hidden" name="command" value="login" /> <label
					for="loginlabel"><fmt:message key="index.login" /></label> <input
					type="text" name="login" id="loginlabel" class="form-control"
					placeholder="<fmt:message key="index.login"/>">
			</div>
			<div class="form-group">
				<label for="passwordlabel"><fmt:message key="index.password" /></label>
				<input type="password" name="password" class="form-control"
					id="passwordlabel"
					placeholder="<fmt:message key="index.password"/>">
			</div>
			<div>${errorLoginPassMessage}</div>
			<button type="submit" class="btn btn-default">
				<fmt:message key="index.button" />
			</button>
			<a href="jsp/registration.jsp" style="margin: 35px"><fmt:message
					key="index.registration" /></a>
		</form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>

