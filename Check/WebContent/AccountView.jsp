<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="AccountView.css">
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
    <h1>PROFILE</h1>
    <p>FULL NAME: ${sessionScope.user.name}</p>
    <p>EMAIL: ${sessionScope.user.email}</p>
    <p>ROLE: ${sessionScope.user.role}</p>
    <c:if test="${sessionScope.user.role ne 'admin'}">
        <p>YOUR BOOKING ORDER(S): ${sessionScope.application}</p>
        <button><a href="https://localhost:8443/Check/BookingApplicationController">Booking orders' details</a></button>    
    </c:if>
    <button><a href="https://localhost:8443/Check/passwordmodification.jsp">Change password</a></button>
    <c:if test="${sessionScope.user.role eq 'client'}">
        <button><a href="https://localhost:8443/Check/namemodification.jsp">Change name</a></button>
    </c:if>
    <button><a href="https://localhost:8443/Check/LogOutController">Sign out</a></button>
</body>
</html>




