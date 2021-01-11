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
<form:form action="/licenses/new" method="post" modelAttribute="license">
    <p>
        <form:label path="person">Person</form:label>
        <form:errors path="person"/>
        <form:select path="person">
        	<form:option value="none">---Select---</form:option>
        	<form:options items="${listPerson}"></form:options>
        </form:select>
    </p>
    <p>
        <form:label path="state">State</form:label>
        <form:errors path="state"/>
        <form:input path="state"/>
    </p>
    <p>
        <form:label path="expirationDate">Expiration Date</form:label>
        <form:errors path="expirationDate"/>
        <form:input  type="date" path="expirationDate"/>
    </p>
     <p>
        <form:label path="number"></form:label>
        <form:errors path="number"/>
        <form:input  type="hidden" path="number"/>
    </p>
    <input type="submit" value="Create"/>
</form:form>
</body>
</html>