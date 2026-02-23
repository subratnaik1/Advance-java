<%@page import="java.util.Iterator" %>
<%@page import="com.pack1.EmpBean" %>
<%@page import="java.util.ArrayList" %>
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
		<u>Employee Data</u><br>
		</h1>
		<h3>
		<%
		ArrayList<EmpBean> al=(ArrayList<EmpBean>)request.getAttribute("list");
		if(al.size()==0)
			out.println("Employee table is empety");
		else{
			Iterator<EmpBean> i=al.iterator();
			while(i.hasNext()){
				EmpBean eb=i.next();
				out.println(eb.getEmp_id()+" "+eb.getEmp_fname()+" "+eb.getEmp_lname()+" "+eb.getEmp_sal()+" "+eb.getEmp_addr()+"<br><br> ");
			}
		}
		%>
		</h3>
		<jsp:include page="index.html"/>
	</body>
</html>