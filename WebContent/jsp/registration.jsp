<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fmt:setBundle basename="${sessionScope.locale}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><fmt:message key="reg.title" /></title>
<link href="../css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<h2 align="center">
		<fmt:message key="reg.h" />
	</h2>
	<div class="col-md-4 col-md-offset-4">
		<form action="../controller" method="post">
		<input type="hidden" name="command" value="register" />
			<div class="form-group">
				<label for="loginlabel"><fmt:message key="reg.login" /></label> <input
					type="text" name="login" id="loginlabel" pattern ="[A-Za-zА-Яа-яЁё0-9]{1,}" class="form-control"
					placeholder="<fmt:message key="reg.login" />" maxlength="15">
			</div>
			<div class="form-group">
				<label for="passlabel"><fmt:message key="reg.password" /></label> <input
					type="password" name="password" id="passlabel" pattern ="[A-Za-zА-Яа-яЁё0-9]{1,}" class="form-control"
					placeholder="<fmt:message key="reg.password" />" maxlength="15">
			</div>
			<div class="form-group">
				<label for="maillabel"><fmt:message key="reg.email" /></label> <input
					type="email" name="email" id="maillabel" class="form-control"
					placeholder="<fmt:message key="reg.email" />">
			</div>
			<div class="form-group">
				<label for="phonelabel"><fmt:message key="reg.phone" /></label> <input
					type="phone" name="phone" id="phonelabel" pattern ="[0-9]{7,}" class="form-control"
					placeholder="<fmt:message key="reg.phone" />" maxlength="13">
			</div>
			<div>
				<input type="submit" style="float: right;"
					class="btn btn-info btn-ms"
					value="<fmt:message key="reg.button" />" />
				<a href="../index.jsp" class="btn btn-default btn-ms"><fmt:message key="reg.mainmenu" /></a>
					
			</div>
			<c:if
				test="${requestScope.Incorrect == true}">
				<fmt:message key="reg.incorrect" />
			</c:if>
			
		</form>

	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>