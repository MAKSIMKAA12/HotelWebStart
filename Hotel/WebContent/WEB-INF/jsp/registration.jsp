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

	<jsp:useBean id="errorMessageName" class="java.lang.String" scope="request" />
	<jsp:useBean id="errorMessageLastName" class="java.lang.String" scope="request" />
	<jsp:useBean id="email" class="java.lang.String" scope="request" />
	<jsp:useBean id="login" class="java.lang.String" scope="request" />
	<jsp:useBean id="password" class="java.lang.String" scope="request" />

	<br />

	<form action="Controller" method="post">
		<input type="hidden" name="command" value="registration" />
		 Name: 
		 <br />		
		<input type="text" name="name" value="" /><i> <c:out value="${errorMessageName}" /></i><br />
				
		 Last Name:
		<br />
		 <input type="text" name="lastname" value="" />		<i> <c:out value="${errorMessageLastName}" /></i>
		<br />
		
		
		E-mail
		<br />
		<input type="text" name="email" value="" /> <i> <c:out value="${email}" /></i>
		<br />
		
		
		Login:
		<br /> <input type="text" name="login" value="" />   <i> <c:out value="${login}" /></i>
		
		
		
		<br />
		Password:
		<br /> <input type="text" name="password" value="" /><i> <c:out value="${password}" /></i>
		<br /> <br /> <input
			type="submit" name="registration" value="Registration" />

	</form>


</body>
</html>