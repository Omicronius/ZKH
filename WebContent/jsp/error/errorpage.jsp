<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fmt:setBundle basename="${sessionScope.locale}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="reg.incorrect" /></title>
</head>
<body>
	<center>
	<h2><fmt:message key="reg.incorrect" /></h2>
	<a href="jsp/registration.jsp"/><fmt:message key="reg.comeback" /></a>
	</center>
</body>
</html>