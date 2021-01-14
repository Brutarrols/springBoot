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
	<h1><c:out value="${student.firstName }"/> <c:out value="${student.lastName}"/></h1>
	<form:form action="/students/${student.id}" method="put" modelAttribute="student">
		<p>
			<form:label path="classes">Classes:</form:label>
			<form:errors path="classes"/>
			<form:select path="classes">
				<form:option value="">---Select---</form:option>
				<form:options items="${classes}"/>
			</form:select>
		</p>
		<input type="submit" value="add">
	</form:form>
	<table>
		<thead>
			<tr>
				<th>Class name</th>
				<th>Accion</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="class" items="${student.classes}">
				<tr>
					<td><c:out value="${class.name}"/></td>
					<td><a href="/students/${student.id}/remove?class=${class.id}">Drop</a>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>