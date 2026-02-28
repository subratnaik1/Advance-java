<%@ page import="java.util.*, pack1.ProductBean"%>
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
			   List<ProductBean> list = (List<ProductBean>) request.getAttribute("msg");
		      if(list !=null){
		    	  for(ProductBean pb:list){
		    		out.println(pb.getP_code()+" "+pb.getP_name()+" "+pb.getP_company()+" "+pb.getP_price()+" "+pb.getP_company()+ 
		    	  "<a href='buy?pcode="+pb.getP_code()+"'>Buy</a> <br><br>");
		    	  }
		      }	
				%>
		</h1>
</body>
</html>