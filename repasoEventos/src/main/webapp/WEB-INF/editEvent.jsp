<%@ page isErrorPage="true" %>    
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
	<h1><c:out value="${event.name}"/></h1>
	<form:form action="/events/${event.id}/edit" method="post" modelAttribute="event">
		<input type="hidden" name="_method" value="put">
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
		<input type="submit" value="Edit">
	</form:form>
</body>
</html>