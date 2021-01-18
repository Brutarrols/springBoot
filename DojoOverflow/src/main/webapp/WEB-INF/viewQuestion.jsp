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
	<h1><c:out value="${question.question}"/></h1>
	<p>
		<c:forEach var="tag" items="${question.tags}">
			<c:out value="${tag.subject}"/> 
		</c:forEach>
	</p>
	
	<table>
		<thead>
			<tr>
				<td>Answers</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="answer" items="${question.answers}">
				<tr>
					<th><c:out value="${answer.answer}"/></th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<form:form action="/question/${question.id}" method="post" modelAttribute="answer">
		<h2>Add your answer</h2>
		<p>
			<form:label path="answer">Answer</form:label>
			<form:errors path="answer"/>
			<form:textarea path="answer"/>
		</p>
		<input type="submit" value="answer">
	</form:form>
</body>
</html>