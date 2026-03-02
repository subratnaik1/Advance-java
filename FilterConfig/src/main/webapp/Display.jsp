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
			String name=(String)request.getParameter("uname");
			String Filtername=(String)request.getAttribute("filterName");
			out.println("welcome "+name+"<br><br>");
			out.println("filtername"+Filtername+"<br><br>");
			

			%>
		</h1>
	</center>
</body>
</html>