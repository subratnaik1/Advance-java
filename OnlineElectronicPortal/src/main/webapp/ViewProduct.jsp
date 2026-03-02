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
<title>View Products</title>
<style>
    /* Animated sky-blue gradient background */
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

    /* Container */
    .product-container {
        background: rgba(255, 255, 255, 0.95);
        border-radius: 25px;
        padding: 30px 40px;
        width: 700px;
        box-shadow: 0 12px 30px rgba(0, 0, 0, 0.2);
    }

    h1 {
        text-align: center;
        color: #0077b6;
        margin-bottom: 30px;
        border-bottom: 2px solid #00bfff;
        display: inline-block;
        padding-bottom: 8px;
    }

    /* Product box */
    .product-item {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 20px;
        padding: 12px 15px;
        border-radius: 12px;
        background: #f0f8ff;
        transition: transform 0.2s;
    }

    .product-item:hover {
        transform: scale(1.02);
        box-shadow: 0 4px 12px rgba(0,0,0,0.1);
    }

    .product-info {
        font-size: 16px;
        color: #333;
        flex: 1;
    }

    .product-actions a {
        margin-left: 10px;
        text-decoration: none;
        padding: 6px 12px;
        border-radius: 8px;
        background: linear-gradient(to right, #00c6ff, #0072ff);
        color: white;
        font-weight: bold;
        transition: 0.3s;
    }

    .product-actions a:hover {
        background: linear-gradient(to right, #0072ff, #00c6ff);
    }
</style>
</head>
<body>
<div class="product-container">
<%
    AdminBean abean = (AdminBean) session.getAttribute("AdminBean");
    ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("productList");

    if (al == null || al.size() == 0) {
%>
    <h1>Hello Mr <%= abean.getA_fname() %>, no products are available in the inventory.</h1>
<%
    } else {
%>
    <h1>Hello Mr <%= abean.getA_fname() %>, these are your product details:</h1>
<%
        Iterator<ProductBean> i = al.iterator();
        while(i.hasNext()) {
            ProductBean pb = i.next();
%>
    <div class="product-item">
        <div class="product-info">
            <strong>Code:</strong> <%= pb.getP_code() %> |
            <strong>Name:</strong> <%= pb.getP_name() %> |
            <strong>Company:</strong> <%= pb.getP_company() %> |
            <strong>Price:</strong> ₹<%= pb.getP_price() %> |
            <strong>Quantity:</strong> <%= pb.getP_quantity() %>
        </div>
        <div class="product-actions">
            <a href="edit?pcode=<%= pb.getP_code() %>">Edit</a>
            <a href="delete?pcode=<%= pb.getP_code() %>">Delete</a>
        </div>
    </div>
<%
        }
    }
%>
</div>
</body>
</html>