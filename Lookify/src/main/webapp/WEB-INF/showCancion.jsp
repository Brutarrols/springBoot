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
	<a href="/dashboard" >Dashboard</a>
	<h3>Title: <c:out value="${cancion.getTitulo()}"/></h3>
	<p>Artist:  <c:out value="${cancion.getArtista()}"/></p>
	<p>Rating (1-10): <c:out value="${cancion.getClasificacion()}"/></p>
	<form action="/songs/<c:out value="${cancion.getId()}"/>" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete">
	</form>
</body>
</html>