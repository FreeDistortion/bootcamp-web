<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<%
		for (int row = 1; row <= 9; row++) {
		%>
		<tr>
			<%
			for (int data = 1; data <= 9; data++) {
			%>
			<%
			if (row == data) {
			%>
			<td><img alt="" src="../images/bts1.jpeg"></td>
			<%
			} else {
			%>
			<td><%=row%>*<%=data%>=<%=(row * data)%></td>
			<%
			}
			}
			%>
		</tr>
		<%
		}
		%>

	</table>
</body>
</html>