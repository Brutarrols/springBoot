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
	<h1>Consulta 1</h1>
	<table>
	<thead>
		<tr>
			<th>resultado</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="item" items="${slovene}">
			<tr>
				<td><c:out value="${item[0]}"/> <c:out value="${item[1]}"/> <c:out value="${item[2]}"/> <c:out value="${item[3]}"/></td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<h1>Consulta 2</h1>
	<table>
	<thead>
		<tr>
			<th>resultado</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="item" items="${dos}">
			<tr>
				<td><c:out value="${item[0]}"/> <c:out value="${item[1]}"/> <c:out value="${item[2]}"/> <c:out value="${item[3]}"/></td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<h1>Consulta 3</h1>
	<table>
	<thead>
		<tr>
			<th>resultado</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="item" items="${tres}">
			<tr>
				<td><c:out value="${item[0]}"/> <c:out value="${item[1]}"/> <c:out value="${item[2]}"/> <c:out value="${item[3]}"/></td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<h1>Consulta 4</h1>
	<table>
	<thead>
		<tr>
			<th>resultado</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="item" items="${cuatro}">
			<tr>
				<td><c:out value="${item[0]}"/> <c:out value="${item[1]}"/> <c:out value="${item[2]}"/> <c:out value="${item[3]}"/></td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<h1>Consulta 5</h1>
	<table>
	<thead>
		<tr>
			<th>resultado</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="item" items="${cinco}">
			<tr>
				<td><c:out value="${item[0]}"/> <c:out value="${item[1]}"/> <c:out value="${item[2]}"/> <c:out value="${item[3]}"/></td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<h1>Consulta 6</h1>
	<table>
	<thead>
		<tr>
			<th>resultado</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="item" items="${seis}">
			<tr>
				<td><c:out value="${item[0]}"/> <c:out value="${item[1]}"/> <c:out value="${item[2]}"/> <c:out value="${item[3]}"/></td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<h1>Consulta 7</h1>
	<table>
	<thead>
		<tr>
			<th>resultado</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="item" items="${siete}">
			<tr>
				<td><c:out value="${item[0]}"/> <c:out value="${item[1]}"/> <c:out value="${item[2]}"/> <c:out value="${item[3]}"/></td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<h1>Consulta 8</h1>
	<table>
	<thead>
		<tr>
			<th>resultado</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="item" items="${ocho}">
			<tr>
				<td><c:out value="${item[0]}"/> <c:out value="${item[1]}"/> <c:out value="${item[2]}"/> <c:out value="${item[3]}"/></td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
</body>
</html>