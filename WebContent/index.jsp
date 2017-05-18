<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if
	test="${sessionScope.locale == 'locale_ru_RU' or empty sessionScope.locale}">
	<fmt:setBundle basename="locale_ru_RU" />
<%-- 	<c:set var="locale" value="locale_ru_RU" scope="session" /> --%>
</c:if>
<c:if test="${sessionScope.locale == 'locale_en_US'}">
	<fmt:setBundle basename="locale_en_US" />
<%-- 	<c:set var="locale" value="locale_en_US" scope="session" /> --%>
</c:if>
<html>
<head><title>Index</title></head>
<body>
<jsp:forward page="/jsp/login.jsp"/>
</body></html>