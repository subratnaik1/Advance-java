<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message</title>
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

.message-box {
    background: rgba(255, 255, 255, 0.95);
    padding: 30px 40px;
    border-radius: 20px;
    box-shadow: 0 12px 30px rgba(0,0,0,0.2);
    font-size: 18px;
    color: #0077b6;
    text-align: center;
    max-width: 500px;
}
</style>
</head>
<body>
<div class="message-box">
<%
    String data = (String) request.getAttribute("msg");
    if(data != null && !data.isEmpty()) {
        out.println(data);
    } else {
        out.println("No message available.");
    }
%>
</div>
</body>
</html>