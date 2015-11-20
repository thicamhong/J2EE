<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<c:choose>
	<c:when test="${sessionScope.userIsLogged == true}">
		Bonjour  ${sessionScope.userLogin}
	</c:when>
	
    <c:otherwise>
		<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    
    	<html>
			<head>
				<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
				<title>Insert title here</title>
			</head>
			
			<body>
				<h1>BIENVENUE</h1>
				
				<p>Connexion</p>
				
				<form action="index" method="POST">
					Login : <input type="text" name="login">
					<br>
					<br>
					Password : <input type="password" name="password">
					<br>
					<br> <!-- 
					Format : <input type="text" name="format">
					<br>
					<br> -->
					<input type="submit" value="Submit">
				</form>
			</body>
		</html>	
	</c:otherwise>
</c:choose>
