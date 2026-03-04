<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page errorPage="Error.jsp" %>
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
		String s=request.getParameter("choice");
		if("Add".equals(s))
		{
		%>
		<jsp:forword page="Addition.jsp">
		<jsp:prarm name="date" value="<%= new java.util.Date  %>"/>
		</jsp:forword>
		<%		
		}
		else
			%>	
		{
		<jsp:forward page="Subtraction.jsp">
		<jsp:param name="data" value="<% new java.util.Date() %>"/>
		</jsp:forward>	
		<%
		}
		%>		
		
		</h1>
	</center>
</body>
</html>