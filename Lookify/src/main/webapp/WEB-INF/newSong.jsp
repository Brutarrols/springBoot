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
	<form:form action="/songs/new" method="post" modelAttribute="song">
		  <p>
        <form:label path="titulo">Title</form:label>
        <form:errors path="titulo"/>
        <form:input path="titulo"/>
    </p>
      <p>
        <form:label path="artista">Artist</form:label>
        <form:errors path="artista"/>
        <form:input path="artista"/>
    </p>
      <p>
        <form:label path="clasificacion">Rating</form:label>
        <form:errors path="clasificacion"/>
        <form:input type="number" path="clasificacion"/>
    </p>
    <input type="submit">
	</form:form>
</body>
</html>