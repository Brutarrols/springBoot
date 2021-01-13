<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>All Students</h1>
	<table>
		<thead>
			<tr>
				<td>Name</td>
				<td>Age</td>
				<td>Address</td>
				<td>City</td>
				<td>State</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${students}">
				<tr>
					<td><c:out value="${student.firstName}"/> <c:out value="${student.lastName}"/></td>
					<td><c:out value="${student.age}"/></td>
					<td><c:out value="${student.contact.address}"/></td>
					<td><c:out value="${student.contact.city}"/></td>
					<td><c:out value="${student.contact.state}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>