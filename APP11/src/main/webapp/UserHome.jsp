<%@page import="pack1.UserBean"%>

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
	UserBean ub=(UserBean)request.getAttribute("UserBean");
	out.println("<u>user Data</u><br><br>");
	out.println("user nsme "+ub.getU_name()+" <br><br>");
	String pwd=ub.getU_pwd();
	String cpwd=pwd.substring(0,1)+"****"+pwd.substring(pwd.length()-1);
	out.println("password " +cpwd+"<br><br>");
	out.println("firstName "+ub.getU_fname());
	out.println("lastName "+ub.getU_lname());
	out.println("mail id "+ub.getU_mail());
	out.println("phno "+ub.getU_phn());
	
	%>	
		</h1>
	</center>
</body>
</html>