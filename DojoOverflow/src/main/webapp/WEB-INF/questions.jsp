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
	<h1>Question Dashboard</h1>
	<table>
		<thead>
			<tr>
				<th>Question</th>
				<th>Tags</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="question" items="${questions}">
				<tr>
					<td><a href="questions/${question.id}"><c:out value="${question.name}"/></a></td>
					<td>
						<c:forEach var="tag" items="${question.tags}">
							<c:out value="${tag}"/>,
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="/questions/new">New Question</a>
</body>
</html>