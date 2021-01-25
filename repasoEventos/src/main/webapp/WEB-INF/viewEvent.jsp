<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1><c:out value="${event.name}"></c:out></h1>
	
	<p>
		Host: <c:out value="${event.host.firstName}"/> <c:out value="${event.host.lastName}"/><br>
		Date: <c:out value="${event.date}"/><br>
		Location: <c:out value="${event.location}"/> <c:out value="${event.state}"/><br>
		People that are attending this event: <c:out value="${event.users.size()}"/>
	</p>
	
	<table>
		<thead>
		<tr>
			<th>Name</th>
			<th>Location</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${event.users}">
				<tr>
					<td><c:out value="${user.firstName}"/> <c:out value="${user.lastName}"/></td>
					<td><c:out value="${user.location}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h2>Message Wall</h2>
	<div>
		<c:forEach var="messge" items="${event.mensages}">
			<label><c:out value="${messge.user.firstName}"/> <c:out value="${messge.user.lastName}"/> says: <c:out value="${messge.mensage}"/></label><br>
			<label>----------------------------------------------------------------------------</label><br>
		</c:forEach>
	</div>
	
	<p>add coment</p>
	<form:form action="/events/${event.id}" method="post" modelAttribute="mensage">
		<p>
			<form:label path="mensage">Message:</form:label>
			<form:errors path="mensage"/>
			<form:textarea path="mensage"/>
		</p>
		<input type="submit">
	</form:form>
	
</body>
</html>