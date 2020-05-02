<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="passwordmodification.css">
</head>
<body>
    <c:choose>
        <c:when test="${sessionScope.user.role eq 'client'}">
            <ol> 
                <li><a href="https://localhost:8443/Check/AccountController">${sessionScope.user.name}</a>
                <li><a href="https://localhost:8443/Check/RoomBookingController" target="_self">BOOK</a></li>
                <li><a href="https://localhost:8443/Check/RoomListController">ROOM LIST</a></li>
                <li><a href="https://localhost:8443/Check/LoginSucceeded.jsp" target="_self">HOME</a></li>
            </ol>
        </c:when>
        <c:otherwise>
            <ol> 
                <li><a href="https://localhost:8443/Check/AccountController">${sessionScope.user.name}</a>
                <li><a href="https://localhost:8443/Check/checkout.jsp">CHECK OUT</a></li>
                <li><a href="https://localhost:8443/Check/searching.jsp">SEARCH</a>
                <li><a href="https://localhost:8443/Check/roomlist.jsp">ROOM LIST</a></li>
                <li><a href="https://localhost:8443/Check/turnover.jsp">TURNOVER</a></li>
                <li><a href="https://localhost:8443/Check/AdminLoginSucceeded.jsp" target="_self">HOME</a></li>
            </ol>
        </c:otherwise>
    </c:choose>
    <h1>PASSWORD CHANGING FORM</h1>
    <form action="PasswordChanging" method="POST">
        <label for="old">Old password</label><br><br>
        <input type="password" id="old" name="oldpassword" required/><br><br>
        <label for="new">New password</label><br><br>
        <input type="password" id="new" name="newpassword1" required/><br><br>
        <label for="repeat">Reenter the new password</label><br><br>
        <input type="password" id="repeat" name="newpassword2" required/><br><br>
        <input type="submit" id="submit" value="Change"/>
    </form>
</body>
</html>