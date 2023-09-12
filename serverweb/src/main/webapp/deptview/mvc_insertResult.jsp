<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int r = (Integer) request.getAttribute("model");
	%>
	
	<h1><%= r %> data was inserted.</h1>
	
</body>
</html>