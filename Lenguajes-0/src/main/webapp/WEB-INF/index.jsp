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
	<table>
		<thead>
        	<tr>
	            <th>Nombre</th>
	            <th>Creador</th>
	            <th>Version</th>
	            <th>Accion</th>
       		 </tr>
   	 	</thead>
   	 	 <tbody>
        <c:forEach items="${lenguajes}" var="lenguaje">
	        <tr>
	            <td><a href="/languages/<c:out value="${lenguaje.getId()}"/>"><c:out value="${lenguaje.getName()}"/></a></td>
	            <td><c:out value="${lenguaje.getCreator()}"/></td>
	            <td><c:out value="${lenguaje.getCurrentVersion()}"/></td>
	            <td><a href="/languages/<c:out value="${lenguaje.getId()}"/>/edit">Editar</a> | <form action="/languages/${lenguaje.getId()}" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete">
	</form></td>
	        </tr>
        </c:forEach>
    </tbody>
	</table>
	<form:form action="/languages" method="post" modelAttribute="lenguaje">
		  <p>
        <form:label path="name">Nombre</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
      <p>
        <form:label path="creator">Creador</form:label>
        <form:errors path="creator"/>
        <form:input path="creator"/>
    </p>
      <p>
        <form:label path="currentVersion">Version</form:label>
        <form:errors path="currentVersion"/>
        <form:input path="currentVersion"/>
    </p>
    <input type="submit">
	</form:form>
	
</body>
</html>