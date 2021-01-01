<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Informacion Enviada</h2>
	<label>Nombre: </label><label><c:out value="${resultado.getNombre()}"/></label><br>
	<label>Dojo: </label><label><c:out value="${resultado.getDojo()}"/></label><br>
	<label>Lenguaje favorito: </label><label><c:out value="${resultado.getLenguaje()}"/></label><br>
	<label>Cometario: </label><label><c:out value="${resultado.getComentario()}"/></label><br>
</body>
</html>