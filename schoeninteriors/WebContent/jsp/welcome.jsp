<%@page import="com.schoeninteriros.model.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome <%= ((Users)session.getAttribute("user")).getUsername() %>
<br/>
<br/>
<a href="jsp/product/viewproduct.jsp">View Products</a>
<br/>
<br/>
<a href="/schoeninteriros/logout">logout</a>
</body>
</html>