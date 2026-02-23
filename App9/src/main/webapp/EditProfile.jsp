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
			String uname=(String)request.getAttribute("user_name");
			out.println("this Sessipn belongs to"+uname+"<br><br>");
			out.println("<u>Edit profile</u><br><br>");
			
			%>
		</h1>
		<form action="update" method="post">
		first name<input type="text" name="u_fname" value="<%= ub.getU_fname()%>"><br><br>
		last name<input type="text" name="u_lname" value="<%= ub.getU_lname()%>"><br><br>
		mail id<input type="text" name="u_mail" value="<%=ub.getU_mail()%>"><br><br>
		Phone no<input type="text" name="u_phn" value="<%= ub.getU_phn()%>"><br><br>
		<input type="submit" value="update">
		</form>
	</center>
</body>s
</html>