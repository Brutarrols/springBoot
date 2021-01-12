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
	<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
    <p>
        <form:label path="Dojo">Dojo</form:label>
        <form:errors path="Dojo"/>
        <form:select path="Dojo">
        	<form:option value="none">---Select---</form:option>
        	<form:options items="${dojos}"></form:options>
        </form:select>
    </p>
    <p>
        <form:label path="firstName">First Name</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </p> 
     <p>
        <form:label path="lastName">Last Name</form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    </p>   
     <p>
        <form:label path="age">Age</form:label>
        <form:errors path="age"/>
        <form:input type="number" path="age"/>
    </p>      
    <input type="submit" value="Create"/>
</form:form>
</body>
</html>