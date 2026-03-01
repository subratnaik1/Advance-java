<%@page import="pack1.ProductBean" %>
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
ProductBean pb=(ProductBean)request.getAttribute("product");
%>
	<center>
		<h1>
		<form action="upd" method="post">
		product code<input type="text" name="pcode" value="<%= pb.getP_code() %>"><br><br>
		product name<input type="text" name="pname" value="<%= pb.getP_name() %>"><br><br>
		product company<input type="text" name="pc" value="<%= pb.getP_company() %>"><br><br>
		product price<input type="text" name="pprice" value="<%= pb.getP_price() %>"><br><br>
		required product quantity<input type="text" name="pqty"><br><br>
		<input type="submit" value="buy">

		</form>
		</h1>
	
</body>
</html>