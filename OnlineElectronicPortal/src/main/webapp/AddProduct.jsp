
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
	<%
	AdminBean abean = (AdminBean) session.getAttribute("AdminBean");
    String data=(String)request.getAttribute("msg");
	out.println("welcome " + abean.getA_fname() + "<br><br>");

	%>
	<a href="AddProduct.html">add products</a><br><br>
			<a href="view1">view products</a> <br><br>
			<a href="Logout">logout</a>
</body>
</html>