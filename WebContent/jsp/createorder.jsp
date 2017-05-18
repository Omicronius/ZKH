<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<div style="margin: 15px">
		<c:if test="${not empty requestScope.createOrderForm}">
			<form action="controller" method="post">
				<input type="hidden" name="command" value="create_order" /> 
				<div class="form-group">
				<label for="categorylabel"><fmt:message key="order.category" /></label> 
				<input class="form-control" type="text" name="worktype" id="categorylabel">
				</div>
				<div class="form-group">
				<label for="detailslabel"><fmt:message key="order.details" /></label>
				<textarea class="form-control" rows="3" name="description" id="detailslabel"></textarea>
				</div>
				<div>
				<input type="submit" style="float: right;"
					class="btn btn-info btn-ms"
					value="<fmt:message key="order.button" />" />	
			</div>
			</form>
		</c:if>

	</div>