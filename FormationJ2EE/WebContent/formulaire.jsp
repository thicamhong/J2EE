<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <title>Insert title here <%out.println(request.getAttribute("title")); %></title> -->
<title>Insert title here <%=(request.getAttribute("title"))%></title>
</head>
<body>
	<h1>
		HELLO WORLD
	</h1>
	
	quel est votre nom?
	<form action='ServletP2' method='POST'>
		<input type='text' name='firstName'/>
		<input type='text' name='lastName'/>
		<button> GOOOOOO </button>
	</form>
	
	<a href ='http://localhost:8080/FormationJ2EE/ServletP2'>Page 2</a>
	

</body>
</html>