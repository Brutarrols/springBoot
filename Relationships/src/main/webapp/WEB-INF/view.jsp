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
	<h1><c:out value="${persona.getFirstName()}"/> <c:out value="${persona.getLastName()}"/></h1>
	<p>License number: <c:out value="${persona.getNumber()}"/></p>
	<p>Stater: <c:out value="${persona.getState()}"/></p>
	<p>Expiration date: <c:out value="${persona.getExpirationDate()}"/></p>
</body>
</html>