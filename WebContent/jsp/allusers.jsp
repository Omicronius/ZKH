<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:if test="${not empty requestScope.userList}">
<div class="col-md-10 col-md-offset-0 left">
<div style="margin: 15px">
<table class="table table-bordered">
	<tr>
		<th><fmt:message key="table.id" /></th>
		<th><fmt:message key="table.login" /></th>
		<th><fmt:message key="table.role" /></th>
		<th><fmt:message key="table.email" /></th>
		<th><fmt:message key="table.phone" /></th>
	</tr>
<c:forEach items="${userList}" var="item">
	<tr>
		<td> ${item.id}</td>
		<td> ${item.login}</td>
		<td> ${item.role}</td>
		<td> ${item.email}</td>
		<td> ${item.phone}</td>
	</tr>
</c:forEach>
</table>
</div></div>
</c:if>