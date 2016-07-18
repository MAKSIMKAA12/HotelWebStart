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

	<jsp:useBean id="Name" class="java.lang.String" scope="request" />
	<jsp:useBean id="LastName" class="java.lang.String" scope="request" />
	<jsp:useBean id="email" class="java.lang.String" scope="request" />
	<jsp:useBean id="login" class="java.lang.String" scope="request" />
	<jsp:useBean id="password" class="java.lang.String" scope="request" />

	<br />

	<form action="Controller" method="post">
		<input type="hidden" name="command" value="updete_personal_accaunt" />
		 Name: 
		 <br />		
		<i> <c:out value="${Name}" /></i><br />
				
		 Last Name:
		<br />
		 <i> <c:out value="${LastName}" /></i>
		<br />
		
		
		E-mail:
		<br />
		<i> <c:out value="${email}" /></i>
		<br />
		
		
		Login:
		<br />
		<i> <c:out value="${login}" /></i>
		
		
		
		<br />
		Password:
		<br />
		<i> <c:out value="${password}" /></i>
		<br /> <br /> <input
			type="submit" name="change" value="Change" />

	</form>


</body>
</html>