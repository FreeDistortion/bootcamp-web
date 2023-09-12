<%@page import="basic.MemberDTO"%>
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
	ArrayList<MemberDTO> memberList = (ArrayList<MemberDTO>) request.getAttribute("list");
	%>
	<table border='1' width='600'>
		<tr>
			<th>id</th>
			<th>pw</th>
			<th>name</th>
			<th>addr</th>
			<th>regdate</th>
			<th>point</th>
			<th>info</th>
			<th>delete</th>
		</tr>
		<%
		for (MemberDTO member : memberList) {
		%>
		<tr>
			<td><%=member.getId()%></td>
			<td><%=member.getPass()%></td>
			<td><%=member.getName()%></td>
			<td><%=member.getAddr()%></td>
			<td><%=member.getRegdate()%></td>
			<td><%=member.getPoint()%></td>
			<td><%=member.getInfo()%></td>

		</tr>
		<%
		}
		%>
	</table>
</body>
</html>