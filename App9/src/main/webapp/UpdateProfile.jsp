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
<<center>
		<h1>
			<%
            UserBean ub=(UserBean)application.getAttribute("userBean");
			String data=(String)request.getAttribute("msg");
			out.println("this Sessipn belongs to"+ub.getU_name()+"<br><br>");
			out.println(data+"<br><br>");
			
			%>
			<a href="view">view profile</a>
			<a href="logout">logout</a>
		</h1>
</body>
</html>