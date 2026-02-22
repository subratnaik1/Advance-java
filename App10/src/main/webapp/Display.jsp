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
      String data = (String)request.getAttribute("name");
    out.println(data);
      String data2 = (String)request.getAttribute("age");
    out.println(data2);
      String data3 = (String)request.getAttribute("gen");
    out.println(data3);
      String data4 = (String)request.getAttribute("addr");
    out.println(data4);
      String data5 = (String)request.getAttribute("marry");
    out.println(data5);
      String data6 = (String)request.getAttribute("quali");
    out.println(data6);
      String data7 = (String)request.getAttribute("hobby");
    out.println(data7);
     %>
</h1>
</body>
</html>