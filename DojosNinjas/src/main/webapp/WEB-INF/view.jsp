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
	<h1><c:out value="${dojo.getName()}" /> Location Ninjas</h1>
	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ninja" items="${dojo.getNinjas()}">
				<tr>
					<td><c:out value="${ninja.getFirstName()}" /></td>
					<td><c:out value="${ninja.getLastName()}" /></td>
					<td><c:out value="${ninja.getAge()}" /></td>
				<tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>