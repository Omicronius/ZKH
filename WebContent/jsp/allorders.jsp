<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:if test="${not empty requestScope.ordersList}">
<div class="col-md-10 col-md-offset-0 left">
<div style="margin: 15px">
<table class="table table-bordered">
	<tr>
		<th><fmt:message key="table.id" /></th>
		<th><fmt:message key="table.worktype" /></th>
		<th><fmt:message key="table.details" /></th>
		<th><fmt:message key="table.userid" /></th>
	</tr>
<c:forEach items="${ordersList}" var="item">
	<tr>
		<td> ${item.id}</td>
		<td> ${item.workType}</td>
		<td> ${item.details}</td>
		<td> ${item.uid}</td>
	</tr>
</c:forEach>
</table>
</div></div>
</c:if>