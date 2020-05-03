<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="searching.css">
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
    <h1>USER INFORMATION</h1>
    <p>No users found, please double-check everything you enter before submitting and try again</p>
    <form action="UserSearching" method="POST">
        <label for="fn">Full name or first name</label><br><br>
        <input type="text" id="fn" name="name"/><br><br>
        <input type="submit" id="submit" value="Search"/>
    </form>
</body>
</html>