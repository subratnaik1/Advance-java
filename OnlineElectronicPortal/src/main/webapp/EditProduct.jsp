<%@page import="pack1.ProductBean" %>
<%@page import="pack1.AdminBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
   <h1>
      <% 
       AdminBean abean = (AdminBean)session.getAttribute("AdminBean");
       ProductBean pbean = (ProductBean)request.getAttribute("p_bean");
       out.println(abean.getA_fname()+" below is the data available to edit<br><br>");      
      %>
      <form action="update" method="post">
       Product Price: <input type="text" name="price" value="<%= pbean.getP_price() %>"> <br><br>
       Product Quantity: <input type="text" name="qty" value="<%= pbean.getP_quantity() %>"> <br><br>
       <input type="hidden" name=pcode value="<%= pbean.getP_code() %>">
       <button>Update</button>
      </form>
   </h1>
</body>
</html>