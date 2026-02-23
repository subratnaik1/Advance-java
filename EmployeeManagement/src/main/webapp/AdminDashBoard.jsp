<%@page import="pack1.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<style>
body {
    margin: 0;
    font-family: Arial, sans-serif;
}

/* Sidebar */
.sidebar {
    height: 100vh;
    width: 250px;
    position: fixed;
    top: 0;
    left: 0;
    background: linear-gradient(180deg, #0073e6, #00c6ff); /* gradient */
    color: white;
    padding-top: 30px;
}

/* Sidebar links */
.sidebar a {
    display: block;
    color: white;
    padding: 15px 25px;
    text-decoration: none;
    font-weight: bold;
    transition: 0.3s;
}

.sidebar a:hover {
    background-color: rgba(255,255,255,0.2);
    padding-left: 30px;
}

/* Header on top of sidebar */
.sidebar .admin-name {
    text-align: center;
    font-size: 20px;
    margin-bottom: 30px;
    font-weight: bold;
}

/* Main content */
.main {
    margin-left: 250px; /* same as sidebar width */
    padding: 30px;
    background: linear-gradient(135deg, #e0f7ff, #ffffff);
    min-height: 100vh;
}
</style>
</head>
<body>
<%
    UserBean user = (UserBean) session.getAttribute("user");
    String adminName = user.getUsername();
%>
<div class="sidebar">
    <div class="admin-name">Welcome, <%= adminName %></div>
    <a href="dashboard.jsp">Dashboard</a>
    <a href="viewEmployees">View Employees</a>
    <a href="addEmp.html">Add Employee</a>
    <a href="updateEmployee.jsp">Update Employee</a>
    <a href="deleteEmployee.jsp">Delete Employee</a>
    <a href="departments.jsp">Departments</a>
    <a href="addDepartment.jsp">Add Department</a>
    <a href="users.jsp">Users</a>
    <a href="reports.jsp">Reports</a>
    <a href="changePassword.jsp">Change Password</a>
    <a href="logout.jsp">Logout</a>
</div>

<div class="main">
    <h1>Admin Dashboard</h1>
</div>

</body>
</html>