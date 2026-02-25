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
		AdminBean abean=(AdminBean)session.getAttribute("AdminBean");
		ArrayList<ProductBean>al=(ArrayList<ProductBean>)session.getAttribute("productList");
		if(al.size()==0){
			out.println("Products are not available in the inventory");
		}
		else{
			out.println("Hello mr "+abean.getA_fname()+"these are your product details<br><br>");
			Iterator<ProductBean> i=al.iterator();
			while(i.hasNext()){
				ProductBean pb = i.next();
				out.println(
				    pb.getP_code() + " " + pb.getP_name() + " " + pb.getP_company() + " " + pb.getP_price() + " " + pb.getP_quantity()
				    + " <a href='edit?pcode=" + pb.getP_code() + "'>Edit</a>"
				    + " <a href='delete?pcode=" + pb.getP_code() + "'>Delete</a>"
				);
				
			}
		}
		%>
		</h1>
	</center>
</body>
</html>