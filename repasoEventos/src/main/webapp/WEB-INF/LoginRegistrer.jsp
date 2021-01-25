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
<h1>REGISTRATION</h1>
	<form:form action="/" method="post" modelAttribute="user">
		<p>
			<form:label path="firstName">First name</form:label>
			<form:errors path="firstName"/>
			<form:input path="firstName"/>
		</p>
		<p>
			<form:label path="lastName">Last Name </form:label>
			<form:errors path="lastName"/>
			<form:input path="lastName"/>
		</p>
		<p>
			<form:label path="email">E-mail</form:label>
			<form:errors path="email"/>
			<form:input path="email"/>
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
		<p>
			<form:label path="password">Password</form:label>
			<form:errors path="password"/>
			<form:password path="password"/>
		</p>
		<p>
			<form:label path="confirmPassword">Conf. Pass</form:label>
			<form:errors path="confirmPassword"/>
			<form:password path="confirmPassword"/>
		</p>
		<input type="submit" value="Registrer">
	</form:form>
	
	<h1>Login</h1>
	<p><c:out value="${error}"/></p>
	<form action="/login" method="post">
		<label>Email</label>
		<input type="email" name="email">
		<br>
		<label>Password</label>
		<input type="password" name="password">
		<br>
		<input type="submit" value="Login">
	</form>
</body>
</html>