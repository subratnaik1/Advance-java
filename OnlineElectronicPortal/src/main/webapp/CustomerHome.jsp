<%@page import="pack1.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
		<h1>
			<%			
			CustomerBean cb = (CustomerBean) session.getAttribute("customerBean");
			out.println("welcome " + cb.getC_fname() + "<br><br>");
			%>
			<a href="view1">view products</a> <br><br>
			<a href="Logout">logout</a>
		</h1>
	</center>
</body>
</html>