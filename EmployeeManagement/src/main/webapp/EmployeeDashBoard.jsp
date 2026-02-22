<%@ page import="pack1.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
UserBean user = (UserBean) session.getAttribute("user");
String employeeName = user.getUsername();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Dashboard</title>
<style>
body {
	font-family: Arial, sans-serif;
	background: #f5f5f5;
	margin: 0;
	padding: 0;
}

.header {
	background-color: #36b9cc;
	color: white;
	text-align: center;
	padding: 20px;
}

.container {
	display: flex;
	justify-content: center;
	margin-top: 40px;
	flex-wrap: wrap;
}

.card {
	background-color: white;
	width: 220px;
	height: 120px;
	margin: 15px;
	border-radius: 10px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
	text-align: center;
	padding-top: 30px;
	font-weight: bold;
	font-size: 16px;
}

.card a {
	display: block;
	margin-top: 15px;
	text-decoration: none;
	color: #36b9cc;
	font-weight: bold;
}

.card a:hover {
	color: #1e7e8c;
}
</style>
</head>
<body>

	<div class="header">
		<h1>
			Welcome,
			<%=employeeName%>!
		</h1>
	</div>

	<div class="container">
		<div class="card">
			Attendance <a href="attendance.jsp">Go</a>
		</div>
		<div class="card">
			Tasks <a href="tasks.jsp">Go</a>
		</div>
		<div class="card">
			Profile <a href="profile.jsp">Go</a>
		</div>
		<div class="card">
			Logout <a href="logout.jsp">Logout</a>
		</div>
	</div>

</body>
</html>