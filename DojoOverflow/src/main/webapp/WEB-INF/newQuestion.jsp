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
	<h1>What is your question?</h1>
	<form:form action="/questions/new" method="post" modelAttribute="pregunta">
	<p>
		<form:label path="question">Question:</form:label>
		<form:errors path="question"/>
		<form:textarea path="question"/>
	<p>
	<p>
		<form:label path="tags">Tags:</form:label>
		<form:errors path="tags"/>
		<form:input path="tags"/>
	</p>	
	<input type="submit" value="Submit">
	</form:form>
</body>
</html>