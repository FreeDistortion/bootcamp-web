<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jsp grammar</h1>
	<h3>1. 주석문</h3>
	<!-- html주석문(client 전송) -->
	<%-- jsp주석문(client 미전송) --%>
	<%
	// java주석문(client 미전송)
	/* 
	java주석문(client 미전송)
	*/
	%>

	<h3>2. script element - scriptlet</h3>
	<%
	String str = new String("Java");
	%>

	<h3>Scriptlet은 java code를 쓸 수 있고 여러 번 사용 가능</h3>
	<hr />
	<%
	if (str.length() >= 5) {
	%>
	<h3>String length looks fine.</h3>
	<%
	} else {
	%>
	<h3 style="color: red">String length must be reprocessed.</h3>
	<%
	}
	%>


	<h3>3. script element - 표현식</h3>
	<h4><%=str%></h4>
	<h4><%=str.length()%></h4>
	<h4><%="str"%></h4>
	<h4><%=10%></h4>
	<h4><%=10.0%></h4>
	<h4><%=false%></h4>
	<h4><%=10 / 3%></h4>
	<h4><%=new Date().toString()%></h4>


	<h3>4. script element - 선언문</h3>
	<%
	int num = 1000;//_jspService method의 local variable로 정의
	%>
	<%!int num = 100000;//member variable로 정의%>
	<%!public void test() {
		System.out.println("test");
	}%>
	


</body>
</html>