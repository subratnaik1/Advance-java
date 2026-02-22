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
	String P_name=request.getParameter("pname");
	String P_pid=request.getParameter("pid");
	String P_pqty=request.getParameter("pqty");
	String P_price=request.getParameter("price");
	
	out.println("product name "+P_name+"<br><br>");
	out.println("product id "+P_pid+"<br><br>");
	out.println("product quantity "+P_pqty+"<br><br>");
	out.println("product price "+P_price+"<br><br>");
	%>
	</h1>
	
</body>
</html>