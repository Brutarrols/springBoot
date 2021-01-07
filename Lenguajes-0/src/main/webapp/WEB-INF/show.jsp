<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/languages" >Principal</a>
	<h3><c:out value="${lenguaje.getName()}"/></h3>
	<p><c:out value="${lenguaje.getCreator()}"/></p>
	<p><c:out value="${lenguaje.getCurrentVersion()}"/></p>
	<a href="/lenguages/<c:out value="${lenguaje.getId()}"/>/edit">Editar</a>
	<form action="/lenguages/<c:out value="${lenguaje.getId()}"/>" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete">
	</form>
</body>
</html>