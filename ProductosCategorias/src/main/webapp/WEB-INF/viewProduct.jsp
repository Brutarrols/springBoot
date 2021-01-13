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
	<h1><c:out value="${product.name}"/></h1>
	<h3>Categories:</h3>
	<ul>
		<c:forEach var="categoria" items="${product.categories}">
			<li><c:out value="${categoria.name}"/></li>
		</c:forEach>
	</ul>
	<form:form action="/products/${product.id}" method="put" modelAttribute="product">
	<p>
	<form:input type="hidden" path="name" value="${product.name}" />
	<form:input type="hidden" path="description" value="${product.description}" />
	<form:input type="hidden" path="price" value="${product.price}" />
		<form:label path="categories"> Add Category</form:label>
		<form:errors path="categories"/>
		<form:select path="categories">
			<form:option value="">---Select---</form:option>
			<form:options items="${categorias}"/>
		</form:select>
		<input type="submit" value="Add">
	</p>
	</form:form>
	
</body>
</html>