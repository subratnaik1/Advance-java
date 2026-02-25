<%@page import="pack1.ProductBean" %>
<%@page import="pack1.AdminBean" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Iterator" %>
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
		AdminBean abean=(AdminBean) session.getAttribute("AdminBean");
		String data=(String)request.getAttribute("msg");
		out.println("hello"+abean.getA_fname()+"<br><br>");
		out.println(data+"<br><br>");
		%>
		<a href="AddProduct.html">add products</a><br><br>
			<a href="view1">view products</a> <br><br>
			<a href="Logout">logout</a>
		</h1>
	</center>
</body>
</html>