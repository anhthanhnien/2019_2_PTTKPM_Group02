<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="RoomBookingView.css">
</head>
<body>
    <ol> 
        <li><a href="https://localhost:8443/Check/AccountController">${sessionScope.user.name}</a>
        <li><a href="https://localhost:8443/Check/RoomBookingController" target="_self">BOOK</a></li>
        <li><a href="https://localhost:8443/Check/RoomListController">ROOM LIST</a></li>
        <li><a href="https://localhost:8443/Check/LoginSucceeded.jsp" target="_self">HOME</a></li>
    </ol>
    <h1>BOOKING INFORMATION</h1>
    <form action="RoomBookingProcess" method="POST">
        <label for="sl">Bed</label><br><br>
        <input type="number" name="quantity" id="sl" placeholder="We just have three kinds of rooms: 1 bed, 2 beds and 3 beds" required><br><br>
        <label for="kind">Type</label><br><br>
        <select id="kind" name="type">
            <option value="deluxe">Deluxe</option>
            <option value="classic">Classic</option>
        </select><br><br>
        <label for="arrival">Arrival date</label><br><br>
        <input type="date" id="arrival" name="start" required><br><br>
        <label for="departure">Departure date</label><br><br>
        <input type="date" id="departure" name="end" required><br><br>
        <input type="submit" value="Search" id="submit"> 
    </form>
</body>
</html>