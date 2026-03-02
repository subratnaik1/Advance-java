<%@page import="pack1.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Welcome</title>
<style>
    /* Animated multi-gradient background */
    body {
        margin: 0;
        height: 100vh;
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

    /* Centered card */
    .welcome-card {
        background: rgba(255, 255, 255, 0.9);
        border-radius: 25px;
        padding: 40px 35px;
        width: 360px;
        box-shadow: 0 12px 30px rgba(0, 0, 0, 0.2);
        text-align: center;
    }

    /* Heading */
    .welcome-card h1 {
        margin-bottom: 30px;
        font-size: 28px;
        color: #0077b6;
        letter-spacing: 1px;
        border-bottom: 2px solid #00bfff;
        display: inline-block;
        padding-bottom: 8px;
    }

    /* Buttons/links */
    .welcome-card a {
        display: block;
        width: 100%;
        margin: 15px 0;
        padding: 12px 0;
        text-decoration: none;
        color: white;
        font-weight: bold;
        border-radius: 15px;
        background: linear-gradient(to right, #00c6ff, #0072ff);
        transition: 0.3s;
    }

    .welcome-card a:hover {
        background: linear-gradient(to right, #0072ff, #00c6ff);
    }
</style>
</head>
<body>
    <div class="welcome-card">
        <h1>
        <% 
            CustomerBean cb = (CustomerBean) session.getAttribute("customerBean");
            if(cb != null) {
                out.println("Welcome " + cb.getC_fname());
            } else {
                out.println("Welcome Customer");
            }
        %>
        </h1>

        <a href="view2">View Products</a>
        <a href="Logout2">Logout</a>
    </div>
</body>
</html>