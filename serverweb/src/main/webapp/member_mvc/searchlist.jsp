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
	<h1>주소로 검색</h1>
	<hr>
	<form method="post" action="/serverweb/mvc/search.do">
		Keyword:<input type="text" name="search"> <input type="submit"
			value="검색">
	</form>

	<%-- 하단에 출력 --%>
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

			<td><a
				href='/serverweb/mvc/member/delete.do?id=<%=member.getId()%>'>삭제</td>
		</tr>
		<%
		}
		%>
	
</body>
</html>