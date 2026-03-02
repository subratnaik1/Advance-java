<%@ page import="java.util.*, pack1.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Products</title>
<style>
    /* Animated multi-gradient background */
    body {
        margin: 0;
        min-height: 100vh;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        display: flex;
        justify-content: center;
        align-items: flex-start;
        background: linear-gradient(45deg, #87cefa, #00bfff, #1e90ff, #00f2fe, #87ceeb);
        background-size: 600% 600%;
        animation: gradientBG 20s ease infinite;
        padding-top: 50px;
    }

    @keyframes gradientBG {
        0% {background-position: 0% 50%;}
        25% {background-position: 50% 50%;}
        50% {background-position: 100% 50%;}
        75% {background-position: 50% 50%;}
        100% {background-position: 0% 50%;}
    }

    /* Container for the table */
    .product-container {
        background: rgba(255, 255, 255, 0.95);
        border-radius: 25px;
        padding: 30px 40px;
        width: 850px;
        box-shadow: 0 12px 30px rgba(0, 0, 0, 0.25);
        overflow-x: auto;
    }

    h1 {
        text-align: center;
        color: #0077b6;
        margin-bottom: 30px;
        border-bottom: 2px solid #00bfff;
        display: inline-block;
        padding-bottom: 8px;
        font-size: 24px;
    }

    /* Table styling */
    table {
        width: 100%;
        border-collapse: separate;       /* separate cells */
        border-spacing: 0 10px;           /* vertical spacing between rows */
        text-align: left;
        font-size: 14px;                  /* smaller text */
    }

    th, td {
        padding: 10px 15px;               /* more space inside cells */
    }

    th {
        background: linear-gradient(to right, #00c6ff, #0072ff);
        color: white;
        font-size: 13px;                  /* smaller headers */
        border-radius: 8px 8px 0 0;
    }

    tr td {
        background: #f0f8ff;
        border-radius: 6px;
    }

    tr:hover td {
        background: #e0f7ff;             /* hover highlight */
    }

    /* Buy button */
    .buy-btn {
        padding: 6px 12px;
        text-decoration: none;
        color: white;
        font-weight: bold;
        border-radius: 12px;
        background: linear-gradient(to right, #00c6ff, #0072ff);
        transition: 0.3s;
        font-size: 13px;                  /* smaller button text */
    }

    .buy-btn:hover {
        background: linear-gradient(to right, #0072ff, #00c6ff);
    }
</style>
</head>
<body>
    <div class="product-container">
        <h1>Available Products</h1>
        <%
            List<ProductBean> list = (List<ProductBean>) request.getAttribute("msg");
            if(list != null && !list.isEmpty()){
        %>
        <table>
            <tr>
                <th>Product Code</th>
                <th>Product Name</th>
                <th>Product Company</th>
                <th>Product Price</th>
                <th>Action</th>
            </tr>
            <%
                for(ProductBean pb : list){
            %>
            <tr>
                <td><%= pb.getP_code() %></td>
                <td><%= pb.getP_name() %></td>
                <td><%= pb.getP_company() %></td>
                <td>₹<%= pb.getP_price() %></td>
                <td><a class="buy-btn" href="buy?pcode=<%= pb.getP_code() %>">Buy</a></td>
            </tr>
            <%
                }
            %>
        </table>
        <%
            } else {
        %>
            <p style="text-align:center;">No products available.</p>
        <%
            }
        %>
    </div>
</body>
</html>