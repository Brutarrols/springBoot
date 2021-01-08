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
	<h1>Top Ten Songs</h1>
	<a href="/dashboard">Dashboard</a>
	<c:forEach var="cancion" items="${canciones}">
		<p><c:out value="${cancion.getClasificacion()}"/>-<c:out value="${cancion.getTitulo()}"/>-<c:out value="${cancion.getArtista()}"/></p>
	</c:forEach>
</body>
</html>