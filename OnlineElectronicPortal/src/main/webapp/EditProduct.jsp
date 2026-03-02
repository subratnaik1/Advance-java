<%@page import="pack1.ProductBean" %>
<%@page import="pack1.AdminBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Product</title>
<style>
body {
    margin: 0;
    min-height: 100vh;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    display: flex;
    justify-content: center;
    align-items: flex-start;
    background: linear-gradient(120deg, #87cefa, #00bfff, #1e90ff, #87ceeb);
    background-size: 400% 400%;
    animation: gradientBG 15s ease infinite;
    padding-top: 50px;
}

@keyframes gradientBG {
    0% {background-position: 0% 50%;}
    50% {background-position: 100% 50%;}
    100% {background-position: 0% 50%;}
}

.container {
    background: rgba(255, 255, 255, 0.95);
    border-radius: 25px;
    padding: 40px 50px;
    text-align: center;
    box-shadow: 0 12px 30px rgba(0,0,0,0.25);
    min-width: 400px;
}

h1 {
    color: #0077b6;
    margin-bottom: 30px;
    font-size: 26px;
    border-bottom: 2px solid #00bfff;
    display: inline-block;
    padding-bottom: 8px;
}

/* Form styling */
form {
    display: flex;
    flex-direction: column;
    gap: 20px;
    margin-top: 20px;
}

input[type="text"] {
    padding: 10px;
    border-radius: 12px;
    border: 1px solid #ccc;
    font-size: 16px;
    width: 100%;
    box-sizing: border-box;
}

button {
    padding: 12px;
    font-size: 16px;
    border-radius: 12px;
    border: none;
    font-weight: bold;
    color: white;
    background: linear-gradient(to right, #00c6ff, #0072ff);
    cursor: pointer;
    transition: 0.3s;
}

button:hover {
    background: linear-gradient(to right, #0072ff, #00c6ff);
    transform: scale(1.05);
}
</style>
</head>
<body>
<div class="container">
<%
   AdminBean abean = (AdminBean)session.getAttribute("AdminBean");
   ProductBean pbean = (ProductBean)request.getAttribute("p_bean");
%>
<h1><%= abean.getA_fname() %>, edit the product below</h1>

<form action="update" method="post">
    <label>Product Price:</label>
    <input type="text" name="price" value="<%= pbean.getP_price() %>">
    
    <label>Product Quantity:</label>
    <input type="text" name="qty" value="<%= pbean.getP_quantity() %>">
    
    <input type="hidden" name="pcode" value="<%= pbean.getP_code() %>">
    
    <button type="submit">Update</button>
</form>
</div>
</body>
