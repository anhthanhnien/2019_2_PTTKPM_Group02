<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="RoomBookingCompleted.css">
</head>
<body>
    <ol> 
        <li><a href="https://localhost:8443/Check/AccountController">${sessionScope.user.name}</a>
        <li><a href="https://localhost:8443/Check/RoomBookingController" target="_self">BOOK</a></li>
        <li><a href="https://localhost:8443/Check/RoomListController">ROOM LIST</a></li>
        <li><a href="https://localhost:8443/Check/LoginSucceeded.jsp" target="_self">HOME</a></li>
    </ol>
    <h2>Thanks for your reservation ^^</h2>
    <img src="download.jpg">
</body>
</html>