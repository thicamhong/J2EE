<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="login.jsp"></jsp:include>
	
	
	<c:choose>
		<c:when test="${empty  sessionScope.idUser}">
			<form action='update' method='POST'>
				<h4> Client <input type='text' name='id'/> </h4>
				First Name : <input type='text' name='firstName'/> </br>
				Last Name : <input type='text' name='lastName'/> </br>
				Address : <input type='text' name='address'/> </br>
				</br>
				<button>CREATE</button>
			</form>
			
			
		</c:when>
		
		<c:otherwise>
			<form action='update' method='POST'>
				<h4> Client <input type='text' name='id' value='${sessionScope.user.id}'/> </h4>
				First Name : <input type='text' name='firstName' value='${sessionScope.user.firstName}'/> </br>
				Last Name : <input type='text' name='lastName' value='${sessionScope.user.lastName}'/> </br>
				Address : <input type='text' name='address' value='${sessionScope.user.address}'/> </br>
				</br>
				<button>UPDATE</button>
			</form>
		</c:otherwise>
	</c:choose>	
	</br>
	</br>
	<a href='<c:url value='/user/list'/>'><button>BACK</button></a>
</body>
</html>