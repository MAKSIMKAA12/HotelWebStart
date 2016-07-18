<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:setLocale value="${sessionScope.locale}" />
	<!-- locale = ru -->
	<fmt:setBundle basename="resources.locale" var="loc" />
	<!-- locale_ru  -->

	<fmt:message bundle="${loc}" key="locale.change_language.ru" var="ru" />

	<jsp:useBean id="errorMessage" class="java.lang.String" scope="request" />


	<a href="Controller?command=change_language&language=ru">${ru}</a>|
	<a href="Controller?command=change_language&language=en">en</a>

	<br />

	<br />


	<br />


	<form action="Controller" method="post">
		<input type="hidden" name="command" value="go_logination" /> <input
			type="submit" name="sing in" value="Go logination" />
	</form>

	<br />

	<form action="Controller" method="post">
		<input type="hidden" name="command" value="go_registration" /> <input
			type="submit" name="sing in" value="Go registration" />
	</form>










</body>
</html>