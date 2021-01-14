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
	<h1><c:out value="${Clase.name}"/></h1>
	<p>Students taking this class</p>
	<table>
		<thead>
			<tr>
			 	<th>Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${Clase.students}">
				<tr>
					<td><c:out value="${student.firstName}"/> <c:out value="${student.lastName}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>