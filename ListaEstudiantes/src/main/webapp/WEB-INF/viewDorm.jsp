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
	<h1><c:out value="${dormitory.name}"/> Dormitory</h1>
	<form:form action="/dorms/${dormitory.id}" method="put" modelAttribute="dormitory">
 		<form:input type="hidden" path="name" value="${dormitory.name}"/>
		<p>
			<form:label path="students">Students:</form:label>
			<form:errors path="students"/>
			<form:select path="students">
				<form:option value=" ">---Select---</form:option>
				<form:options items="${estudiantes}"/>
			</form:select>
		</p>
		<input type="submit" value="add"> 
	</form:form>
	
	<table>
		<thead>
			<tr>
				<td>Name</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${dormitory.students}">
				<tr>
					<th><c:out value="${student.firstName}"/> <c:out value="${student.lastName}"/></th>
					<th><a href="/dorms/${dormitory.id}/remove?student=${student.id}">Remove</a></th> 
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>