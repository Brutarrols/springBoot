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
	<h1>New Student</h1>
	<form:form action="/students/new" method="post" modelAttribute="student">
		<p>
			<form:label path="firstName">First Name</form:label>
			<form:errors path="firstName"/>
			<form:input path="firstName"/>
		</p>
		<p>
			<form:label path="lastName">Last Name</form:label>
			<form:errors path="lastName"/>
			<form:input path="lastName"/>
		</p>
		<p>
			<form:label path="age">Age</form:label>
			<form:errors path="age"/>
			<form:input path="age"/>
		</p>
		<input type="submit" value="create"/>
	</form:form>
</body>
</html>