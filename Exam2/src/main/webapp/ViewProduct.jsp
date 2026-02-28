<%@page import="pack1.ProductBean" %>
<%@page import="pack1.ProductBean" %>
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
		ArrayList<ProductBean>al=(ArrayList<ProductBean>)request.getAttribute("msg");
			Iterator<ProductBean> i=al.iterator();
			while(i.hasNext()){
				ProductBean pb = i.next();
				out.println(pb.getP_id()+" "+pb.getP_name()+" "+pb.getP_price()+" "+pb.getQuantity());
							
		}
		%>
		</h1>

</body>
</html>