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
	<p><c:out value="${mensaje}"/></p>
	<form action="/code" method="post">
		<input type="text" name="codigo">
		<br>
		<label>Cual es el codigo?</label>
		<br>
		<input type="submit">Ingresar</input>
	</form>
</body>
</html>