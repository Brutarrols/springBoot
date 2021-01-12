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
<form:form action="/dojos/new" method="post" modelAttribute="dojo">
    <p>
        <form:label path="Name">Name</form:label>
        <form:errors path="Name"/>
        <form:input path="Name"/>
    </p>   
    <input type="submit" value="Create"/>
</form:form>
</body>
</html>