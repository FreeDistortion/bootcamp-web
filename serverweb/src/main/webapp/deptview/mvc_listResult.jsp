<%@page import="deptjdbc.DeptDTO"%>
<%@page import="java.util.ArrayList"%>
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
	ArrayList<DeptDTO> dList = (ArrayList<DeptDTO>) request.getAttribute("model");
	%>


	<table border='1' width='600'>
		<tr>
			<th>deptno</th>
			<th>deptname</th>
			<th>tel</th>
			<th>addr</th>
			<th>delete</th>
		</tr>
		<%
		for (DeptDTO dept : dList) {
		%>
		<tr>

			<td><%=dept.getDeptno()%></td>
			<td><%=dept.getDeptname()%></td>
			<td><%=dept.getTel()%></td>
			<td><%=dept.getAddr()%></td>
			<td><a
				href='/serverweb/dept/delete.do?deptno=<%=dept.getDeptno()%>'>Delete</td>


		</tr>
		<%
		}
		%>
	</table>
</body>
</html>