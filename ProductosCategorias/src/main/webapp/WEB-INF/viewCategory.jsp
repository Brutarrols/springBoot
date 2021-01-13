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
	<h1><c:out value="${category.getName()}"/></h1>
	<h3>Products:</h3>
	<ul>
		<c:forEach var="producto" items="${category.products}">
			<li><c:out value="${producto.name}"/></li>
		</c:forEach>
	</ul>
	
	<form:form action="/categories/${category.getId()}" method="put" modelAttribute="category">
	<p>
	<form:input type="hidden" path="name" value="${category.name}" />
		<form:label path="products"> Add Products</form:label>
		<form:errors path="products"></form:errors>
		<form:select path="products">
			<form:option value="">---Select---</form:option>
			<form:options items="${productos}"/>
		</form:select>
	</p>
		<input type="submit" value="Add">
	</form:form>
</body>
</html>