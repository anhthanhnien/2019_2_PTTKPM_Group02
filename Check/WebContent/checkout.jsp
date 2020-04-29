<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="checkout.css">
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
    <h1>ROOM INFORMATION</h1>
    <form action="RoomCheckOut" method="POST">
        <label for="ma">Enter room's id you want to check out</label><br><br>
        <input type="text" id="ma" name="id" pattern="\d+|(\d+,\s*)+(\d+)$" placeholder="You can enter more than one room's id, each one is separated by a comma." size="70" required/><br><br>
        <label for="e">Enter customer's email</label><br><br>
        <input type="email" id="e" name="email" required><br><br>
        <input type="submit" id="submit" value="Search"/>
    </form>
</body>
</html>