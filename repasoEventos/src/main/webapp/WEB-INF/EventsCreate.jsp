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
	<h2>Welcome <c:out value="${user.firstName}"/></h2>
	<a href="/logout">Logout</a>
	<p>Events in your Area</p>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>Host</th>
				<th>Action / Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="event" items="${events_by_state}">
				<tr>
					<td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
					<td><c:out value="${event.date}"/></td>
					<td><c:out value="${event.location}"/></td>
					<td><c:out value="${event.host.firstName}"/></td>
					<td>
						 <a href="/events/${event.id}/edit">Edit</a>
						 <a href="/events/${event.id}/delete">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>Events in other States</p>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>State</th>
				<th>Host</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="event" items="${events_no_state}">
				<tr>
					<td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
					<td><c:out value="${event.date}"/></td>
					<td><c:out value="${event.location}"/></td>
					<td><c:out value="${event.state}"/></td>
					<td><c:out value="${event.host.firstName}"/></td>
					<td> <a>Join</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form:form action="/events" method="post" modelAttribute="event">
		<p>
			<form:label path="name">Name</form:label>
			<form:errors path="name"/>
			<form:input path="name"/>
		</p>
		<p>
			<form:label path="date">Date</form:label>
			<form:errors path="date"/>
			<form:input type="date" path="date"/>
		</p>
		<p>
			<form:label path="location">Location</form:label>
			<form:errors path="location"/>
			<form:input path="location"/>
		</p>
		<p>
			<form:label path="state">State</form:label>
			<form:errors path="state"/>
			<form:input path="state"/>
		</p>
		<input type="submit" value="Create Event">
	</form:form>
</body>
</html>