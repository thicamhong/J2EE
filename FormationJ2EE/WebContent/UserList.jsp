<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="com.m2i.formation.j2ee.assurance.User,java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- La base est message. Le reste est local et concatener plus tard -->
<!-- Si message se trouvait ailleurs, il faudrait donner le chemin -->
<fmt:setBundle basename="message" var="msg"/>



<jsp:include page="login.jsp"></jsp:include>

</br>
</br>

<!-- items : collection dans laquelle je vais chercher -->
<!-- var : -->
<table>
		<tr>
			<th> <fmt:message bundle="${msg}"  key="id"></fmt:message> </th>
			<th> <fmt:message bundle="${msg}"  key="firstName"></fmt:message> </th>
			<th> <fmt:message bundle="${msg}"  key="lastName"></fmt:message> </th>
			<th> <fmt:message bundle="${msg}"  key="address"></fmt:message> </th>
		</tr>
		<c:forEach items="${sessionScope.userList}" var="user">
	
			<tr>
				<td> <a href='detail?id=${user.id}'> ${user.id} </a> </td>
				<td> ${user.firstName} </td>
				<td> ${user.lastName} </td>
				<td> ${user.address} </td>
				<td> <a href='<c:url value='/user/detail?id=${user.id}'/>'>Details </a> </td>
				<td> <a href='/user/delete?id=${user.id}'>Delete </a> </td>
				<td> <br> </td>
				
			</tr>
		</c:forEach>
	</table>





</body>
</html>