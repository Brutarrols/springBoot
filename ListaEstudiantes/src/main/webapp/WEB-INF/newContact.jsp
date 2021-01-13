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
	<h1>ontact Info</h1>
	<form:form action="/contacts/new" method="post" modelAttribute="contact">
		<p>
			<form:label path="student">Student</form:label>
			<form:errors path="student"/>
			<form:select path="student">
				<form:option value=" ">---Select---</form:option>
				<form:options items="${students}"/>
			</form:select>
		</p>
		<p>
			<form:label path="address">Address</form:label>
			<form:errors path="address"/>
			<form:input path="address"/>
		</p>
		<p>
			<form:label path="city">City</form:label>
			<form:errors path="city"/>
			<form:input path="city"/>
		</p>
		<p>
			<form:label path="state">State</form:label>
			<form:errors path="state"/>
			<form:input path="state"/>
		</p>
		<input type="submit" value="create"/>
	</form:form>
</body>
</html>