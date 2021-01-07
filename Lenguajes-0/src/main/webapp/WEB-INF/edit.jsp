<%@ page isErrorPage="true" %>    
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
	   
	<h1>Editar</h1>
	<a href="/languages" >Principal</a>
	<form action="/languages/${lenguaje.getId()}" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete">
	</form>
	<form:form action="/languages/${lenguaje.getId()}" method="post" modelAttribute="lenguaje">
	    <input type="hidden" name="_method" value="put">
	    <p>
	        <form:label path="name">Nombre</form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:label path="creator">Creador</form:label>
	        <form:errors path="creator"/>
	        <form:textarea path="creator"/>
	    </p>
	    <p>
	        <form:label path="currentVersion">Version</form:label>
	        <form:errors path="currentVersion"/>
	        <form:input path="currentVersion"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form>
</body>
</html>