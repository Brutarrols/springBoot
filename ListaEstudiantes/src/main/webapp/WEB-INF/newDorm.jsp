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
	<h1>Dormitories</h1>
	<form:form action="/dorms/new" method="post" modelAttribute="dormitory">
		<p>
			<form:label path="name">Name</form:label>
			<form:errors path="name"/>
			<form:input path="name"/>
		</p>
		<input type="submit" value="create">
	</form:form>
</body>
</html>