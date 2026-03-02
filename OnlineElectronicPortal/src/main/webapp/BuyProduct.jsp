<%@page import="pack1.ProductBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buy Product</title>
<style>
    /* Animated sky-blue gradient background */
    body {
        margin: 0;
        min-height: 100vh;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        display: flex;
        justify-content: center;
        align-items: center;
        background: linear-gradient(45deg, #87cefa, #00bfff, #1e90ff, #00f2fe, #87ceeb);
        background-size: 600% 600%;
        animation: gradientBG 20s ease infinite;
    }

    @keyframes gradientBG {
        0% {background-position: 0% 50%;}
        25% {background-position: 50% 50%;}
        50% {background-position: 100% 50%;}
        75% {background-position: 50% 50%;}
        100% {background-position: 0% 50%;}
    }

    /* Form container */
    .form-container {
        background: rgba(255,255,255,0.95);
        padding: 30px 40px;
        border-radius: 20px;
        box-shadow: 0 12px 30px rgba(0,0,0,0.25);
        width: 400px;
    }

    h1 {
        text-align: center;
        color: #0077b6;
        margin-bottom: 25px;
        font-size: 24px;
        border-bottom: 2px solid #00bfff;
        padding-bottom: 8px;
    }

    /* Form styling */
    form {
        display: flex;
        flex-direction: column;
    }

    label {
        font-weight: bold;
        margin-bottom: 5px;
        font-size: 14px;
    }

    input[type="text"] {
        padding: 10px;
        margin-bottom: 15px;
        border-radius: 10px;
        border: 1px solid #ccc;
        font-size: 14px;
    }

    input[type="submit"] {
        padding: 10px;
        border: none;
        border-radius: 12px;
        font-weight: bold;
        background: linear-gradient(to right, #00c6ff, #0072ff);
        color: white;
        font-size: 16px;
        cursor: pointer;
        transition: 0.3s;
    }

    input[type="submit"]:hover {
        background: linear-gradient(to right, #0072ff, #00c6ff);
    }
</style>
</head>
<body>
<%
ProductBean pb=(ProductBean)request.getAttribute("product");
%>
    <div class="form-container">
        <h1>Buy Product</h1>
        <form action="upd" method="post">
            <label>Product Code</label>
            <input type="text" name="pcode" value="<%= pb.getP_code() %>" readonly>

            <label>Product Name</label>
            <input type="text" name="pname" value="<%= pb.getP_name() %>" readonly>

            <label>Product Company</label>
            <input type="text" name="pc" value="<%= pb.getP_company() %>" readonly>

            <label>Product Price</label>
            <input type="text" name="pprice" value="<%= pb.getP_price() %>" readonly>

            <label>Required Quantity</label>
            <input type="text" name="pqty" placeholder="Enter quantity">

            <input type="submit" value="Buy">
        </form>
    </div>
</body>
</html>