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
		
		String data=(String)request.getAttribute("msg");
		out.println("hello product updated"+"<br><br>");
		out.println(data+"<br><br>");
		%>
</body>
</html>