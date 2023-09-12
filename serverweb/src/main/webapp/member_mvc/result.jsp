<%@page import="basic.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>요청재지정으로 실행되는jsp - servlet이 공유해준 data를 꺼내서 web page에 출력하기</h2>
	<%
	// servlet이 공유한 data 꺼내기
	MemberDTO data = (MemberDTO) request.getAttribute("mydata");
	%>
	<h2><%=data.getId()%>님, 환영합니다.
	</h2>
</body>
</html>