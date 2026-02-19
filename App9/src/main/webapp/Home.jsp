<%@page import="pack1.UserBean" %>
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
		UserBean ub=(UserBean)application.getAttribute("userBean");
		out.println("welcome "+ub.getU_fname()+"<br><br>");
		%>
		<a href="edit">view profile</a><br><br>
		<a href="logout">Logout</a><br><br>		
		</h1>
	</center>
</body>
</html>