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
		String uname=(String)request.getAttribute("user_name");
		UserBean ub=(UserBean)application.getAttribute("userBean");
		
		out.println("this session belongs to "+uname+"<br><br>");
		out.println("<u>profile Details</u><br><br>");
		String pwd=ub.getU_pwd();
		String encryptPass=pwd.substring(0,1)+"*****"+pwd.substring(pwd.length()-1);
		out.println(ub.getU_name()+" "+encryptPass+" "+ub.getU_fname()+" "+ub.getU_lname()+" "+ub.getU_mail()+" "+ub.getU_phn());
		%>
		<a href="edit">Edit profile</a><br><br>
		<a href="logout">logout</a>
		</h1>	
</body>
</html>