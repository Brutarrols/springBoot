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
<h1>New Category</h1>
	<form:form action="/categories/new" method="post" modelAttribute="category">
		<p>
			<form:label path="name">Name</form:label>
			<form:errors path="name"></form:errors>
			<form:input path="name"/>
		</p>
		<input type="submit" value="create">
	</form:form>
</body>
</html>