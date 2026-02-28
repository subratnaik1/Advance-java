<%@page import="pack1.AdminBean"%>

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
			AdminBean ab = (AdminBean) session.getAttribute("AdminBean");
			out.println("welcome " + ab.getA_fname() + "<br><br>");
			%>
			<a href="AddProduct.html">add products</a><br><br>
			<a href="view1">view products</a> <br><br>
			<a href="Logout">logout</a>
		</h1>
	</center>

</body>
</html>