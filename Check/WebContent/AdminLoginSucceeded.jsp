<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="AdminLoginSucceeded.css">
</head>
<body>
    <ol> 
        <li><a href="https://localhost:8443/Check/AccountController">${sessionScope.user.name}</a>
        <li><a href="https://localhost:8443/Check/checkout.jsp">CHECK OUT</a></li>
        <li><a href="https://localhost:8443/Check/searching.jsp">SEARCH</a>
        <li><a href="https://localhost:8443/Check/roomlist.jsp">ROOM LIST</a></li>
        <li><a href="https://localhost:8443/Check/turnover.jsp">TURNOVER</a></li>
        <li><a href="https://localhost:8443/Check/AdminLoginSucceeded.jsp" target="_self">HOME</a></li>
    </ol>
</body>
</html>