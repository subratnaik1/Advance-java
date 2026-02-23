<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*, pack1.EmpBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Employees</title>

<style>
body {
	margin: 0;
	font-family: 'Segoe UI', sans-serif;
	background: linear-gradient(135deg, #87CEFA, #00BFFF);
}

.header {
	background-color: #0d6efd;
	color: white;
	padding: 15px 30px;
	font-size: 20px;
	font-weight: 600;
}

.container {
	width: 95%;
	max-width: 1200px;
	margin: 30px auto;
}

.card {
	background-color: white;
	padding: 25px;
	border-radius: 12px;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

h2 {
	margin-bottom: 20px;
	color: #333;
}

table {
	width: 100%;
	border-collapse: collapse;
}

th {
	background-color: #e9ecef;
	padding: 12px;
	text-align: center;
	font-size: 14px;
	color: #333;
}

td {
	padding: 12px;
	text-align: center;
	border-bottom: 1px solid #dee2e6;
}

tr:hover {
	background-color: #f1f3f5;
}

.active {
	background-color: #d1e7dd;
	color: #0f5132;
	padding: 4px 8px;
	border-radius: 12px;
	font-size: 12px;
}

.inactive {
	background-color: #f8d7da;
	color: #842029;
	padding: 4px 8px;
	border-radius: 12px;
	font-size: 12px;
}
</style>
</head>
<body>

	<div class="header">Employee Management System</div>

	<div class="container">
		<div class="card">

			<h2>Employee List</h2>

			<table>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Department</th>
					<th>Salary</th>
					<th>Status</th>
				</tr>

				<%
				List<EmpBean> list = (List<EmpBean>) request.getAttribute("msg");

				if (list != null && !list.isEmpty()) {
					for (EmpBean emp : list) {
				%>
				<tr>
					<td><%=emp.getEmp_id()%></td>
					<td><%=emp.getName()%></td>
					<td><%=emp.getEmail()%></td>
					<td><%=emp.getPhone()%></td>
					<td><%=emp.getDepartmant_id()%></td>
					<td>₹ <%=emp.getSalary()%></td>

					<td
						class="<%="Active".equalsIgnoreCase(emp.getStatus()) ? "active" : "inactive"%>">
						<%=emp.getStatus()%>
					</td>
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td colspan="7">No Employees Found</td>
				</tr>
				<%
				}
				%>

			</table>

		</div>
	</div>

</body>
</html>