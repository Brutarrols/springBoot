<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h1 id="hora"><c:out value="${fecha.getHour()}"/>:<c:out value="${fecha.getMinute()}"/>:<c:out value="${fecha.getSecond()}"/></h1>
</body>
<script src="/js/script.js"></script>
</html>