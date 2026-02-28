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
		String username=request.getParameter("username");
		String msg1=(String)application.getAttribute("msg1");
		String msg2=(String)application.getInitParameter("msg2");
		String S_name=(String)request.getAttribute("servletName");
		String msg3=(String)request.getAttribute("msg3");
		
		out.println("welcomee"+username+"<br><br>");
		out.println("servletContext :"+msg1+"<br><br>");
		out.println("servletContext :"+msg2+"<br><br>");
		out.println("servletname :"+application.getServerInfo()+"<br><br>");
		out.println("servletConfig :"+msg3+"<br><br>");
		
		
		%>
		</h1>
	</center>
</body>
</html>