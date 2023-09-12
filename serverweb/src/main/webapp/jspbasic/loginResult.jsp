<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Result(request implicit object)</h1>
	<hr>
	<%
	//servlet에서 하던 작업 그대로 처리 가능.
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	%>
	<h3>
		id:
		<%=id%></h3>
	<h3>
		pw:
		<%=pass%></h3>
	<br>



	<%
	if (id.equals("java")) {
	%>
	<h3><%=id%>, login succeed.
	</h3>
	<%
	} else {
	response.sendRedirect("./login.jsp");
	}
	%>

	<!-- 
	id가 java면
	id님 login success message!!
	
	else
	sendRedirect를 이용해 login.jsp로 되돌아가게
 -->

</body>
</html>