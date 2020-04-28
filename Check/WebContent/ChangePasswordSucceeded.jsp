<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="ChangePasswordSucceeded.css">
</head>
<body>
    <c:choose>
        <c:when test="${sessionScope.user.role eq 'admin'}">
            <ol> 
                <li><a href="https://localhost:8443/Check/AccountController">${sessionScope.user.name}</a>
                <li><a href="https://localhost:8443/Check/checkout.jsp">CHECK OUT</a></li>
                <li><a href="https://localhost:8443/Check/searching.jsp">SEARCH</a>
                <li><a href="https://localhost:8443/Check/roomlist.jsp">ROOM LIST</a></li>
                <li><a href="https://localhost:8443/Check/turnover.jsp">TURNOVER</a></li>
                <li><a href="https://localhost:8443/Check/AdminLoginSucceeded.jsp" target="_self">HOME</a></li>
            </ol>
        </c:when>
        <c:otherwise>
            <ol> 
                <li><a href="https://localhost:8443/Check/AccountController">${sessionScope.user.name}</a>
                <li><a href="https://localhost:8443/Check/RoomBookingController" target="_self">BOOK</a></li>
                <li><a href="https://localhost:8443/Check/RoomListController">ROOM LIST</a></li>
                <li><a href="https://localhost:8443/Check/LoginSucceeded.jsp" target="_self">HOME</a></li>
            </ol>
        </c:otherwise>
    </c:choose>
    <h2>CHANGE PASSWORD SUCCESSFULLY</h2>
    <img alt="succeeded" src="kiss.png">
</body>
</html>