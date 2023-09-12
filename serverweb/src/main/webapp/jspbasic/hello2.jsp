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
	//java code를 쓸 수 있는 area
	//-> JSP 문서에서 작성하는 모든 tag나 java code는 serlet으로 변환될 때 _jspServic() 내부의 코드가 작성된다.
	out.print("<img src='/serverweb/images/bts1.jpeg'/>");
	out.println("<h2>Welcome</h2>");
	%>
</body>
</html>