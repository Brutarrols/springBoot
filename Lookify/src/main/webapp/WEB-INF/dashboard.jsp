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
<a href="/songs/new">Add Song</a>
<a href="/search/topTen">Top Ten</a>

	<form action="/search" method="post">
		<input type="text" name="artista">
		<input type="submit" value="search Artist">
	</form>

<table>
		<thead>
        	<tr>
	            <th>Title</th>
	            <th>Rating</th>
	            <th>Action</th>
       		 </tr>
   	 	</thead>
   	 	 <tbody>
        <c:forEach items="${canciones}" var="canciones">
	        <tr>
	            <td><a href="/songs/<c:out value="${canciones.getId()}"/>"><c:out value="${canciones.getTitulo()}"/></a></td>
	            <td><c:out value="${canciones.getClasificacion()}"/></td>
	            <td>
	            	<form action="/songs/${canciones.getId()}" method="post">
	    				<input type="hidden" name="_method" value="delete">
	    				<input type="submit" value="Delete">
					</form>
				</td>
	        </tr>
        </c:forEach>
    </tbody>
	</table>
</body>
</html>