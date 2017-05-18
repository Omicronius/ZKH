<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My orders</title>
</head>
<body>

<div style="margin: 15px">
<table class="table table-bordered">
<c:if
	test="${not empty requestScope.orderList}">
	<tr>
		<th><fmt:message key="table.id" /></th>
		<th><fmt:message key="table.worktype" /></th>
		<th><fmt:message key="table.details" /></th>
		<th><fmt:message key="table.deleteOrder" /></th>
	</tr>
</c:if>
<c:forEach items="${orderList}" var="item">
	<tr>
		<td> ${item.id}</td>
		<td> ${item.workType}</td>
		<td> ${item.details}</td>
		<td>
			<form action="controller" method="post">
				<input type="hidden" name="command" value="delete_order"/>
				<input type="hidden" name="oid" value="${item.id}">
				<input type="submit" name="submit" value="<fmt:message key="table.delete"/>" class="btn btn-default  btn-sm"/>
			</form>
		</td>
	</tr>
</c:forEach>
</table>
</div>
</body>
</html>