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
			String msg = (String) request.getAttribute("msg");
			out.println("hello " + cb.getC_fname());
			out.println(msg);
			out.println("your order is placed successfully");
			%>
		</h1>
	</center>
</body>
</html>