<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		for 실행결과
		<hr>
		1
		2
		.	<table>안에
		.
		.
		10
		
	 --%>
	<h1>for 실행 결과</h1>
	<hr>
	<table border=1>
		<%
		for (int i = 1; i <= 10; i++) {
		%>
		<tr>
			<td><%=i%>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>