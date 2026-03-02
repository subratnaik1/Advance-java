<%@page import="pack1.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<style>
body {
    margin: 0;
    min-height: 100vh;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    display: flex;
    justify-content: center;
    align-items: center;
    background: linear-gradient(120deg, #87cefa, #00bfff, #1e90ff, #87ceeb);
    background-size: 400% 400%;
    animation: gradientBG 15s ease infinite;
}

@keyframes gradientBG {
    0% {background-position: 0% 50%;}
    50% {background-position: 100% 50%;}
    100% {background-position: 0% 50%;}
}

.container {
    background: rgba(255, 255, 255, 0.95);
    border-radius: 25px;
    padding: 50px 60px;
    text-align: center;
    box-shadow: 0 12px 30px rgba(0,0,0,0.25);
    min-width: 400px;
}

h1 {
    color: #0077b6;
    margin-bottom: 40px;
    font-size: 28px;
    border-bottom: 2px solid #00bfff;
    display: inline-block;
    padding-bottom: 8px;
}

/* Dashboard buttons */
.dashboard {
    display: flex;
    justify-content: center;
    gap: 40px;
    margin-bottom: 40px;
    flex-wrap: wrap;
}

.round-btn {
    width: 140px;
    height: 140px;
    border-radius: 50%;
    display: flex;
    justify-content: center;
    align-items: center;
    text-decoration: none;
    font-weight: bold;
    color: white;
    background: linear-gradient(to right, #00c6ff, #0072ff);
    transition: 0.3s;
    font-size: 16px;
    text-align: center;
    padding: 10px;
    box-shadow: 0 6px 15px rgba(0,0,0,0.2);
}

.round-btn:hover {
    background: linear-gradient(to right, #0072ff, #00c6ff);
    transform: scale(1.05);
}

/* Logout button */
.logout-btn {
    padding: 12px 30px;
    text-decoration: none;
    font-weight: bold;
    color: white;
    border-radius: 12px;
    background: linear-gradient(to right, #ff416c, #ff4b2b);
    transition: 0.3s;
    font-size: 16px;
    display: inline-block;
}

.logout-btn:hover {
    background: linear-gradient(to right, #ff4b2b, #ff416c);
    transform: scale(1.05);
}
</style>
</head>
<body>
<div class="container">
<%
    AdminBean abean = (AdminBean) session.getAttribute("AdminBean");
    String data = (String) request.getAttribute("msg");
%>

<h1>Welcome, <%= abean.getA_fname() %></h1>

<% if(data != null) { %>
<p><%= data %></p>
<% } %>

<div class="dashboard">
    <a class="round-btn" href="AddProduct.html">Add Product</a>
    <a class="round-btn" href="view1">View Products</a>
</div>

<a class="logout-btn" href="Logout">Logout</a>
</div>
</body>
</html>