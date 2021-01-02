<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h2>Oro: <c:out value="${ninja.getOro()}"></c:out></h2>
	
	<form action="/gold" method="POST">
		<h4>Granja</h4>
		<p>(ganancia de 10-20 Oro)</p>
		<input type="hidden" name="actividad" value="1">
		<input type="submit" value="Ir!">
	</form>
	<form action="/gold" method="POST">
		<h4>Mina</h4>
		<p>(ganancia 5-10 Oro)</p>
		<input type="hidden" name="actividad" value="2">
		<input type="submit" value="Ir!">
	</form>
	<form action="/gold" method="POST">
		<h4>Casa</h4>
		<p>(ganancia 2-5 Oro)</p>
		<input type="hidden" name="actividad" value="3">
		<input type="submit" value="Ir!">
	</form>
	<form action="/gold" method="POST">
		<h4>Casino!</h4>
		<p>(ganancia/perdida 0-50 Oro )</p>
		<input type="hidden" name="actividad" value="4">
		<input type="submit" value="Ir!">
	</form>
	
	<h3>Actividad</h3>
	<div style="width: 650px; height: 300px; overflow:scroll;">
		<c:forEach var="accion" items="${ninja.getHistorial()}">
			<p><c:out value="${accion}"/></p>
		</c:forEach>
	 </div>
</body>
</html>