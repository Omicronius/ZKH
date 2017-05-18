<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<form action="controller" method="POST" style="margin: 15px">
	<input type="hidden" name="command" value="change_locale" />
	<button type="submit" class="btn btn-primary btn-xs">
		<fmt:message key="index.locale" />
	</button>
</form>
