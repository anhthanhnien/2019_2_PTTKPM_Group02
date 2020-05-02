<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="roomlist.css">
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
    <h1>SORTING OPTIONS</h1>
    <form action="RoomSort" method="POST">
        <label for="sx">Sorted by price</label><br><br>
        <select id="sx" name="value">
            <option value="none">default</option>
            <option value="room.price desc">high to low</option>
            <option value="room.price asc">low to high</option>
        </select><br><br>
        <label for="loai">Sorted by type</label>
        <input type="checkbox" id="loai" name="type" value="room.type"/><br><br>
        <label for="empty">Sorted by availability</label>
        <input type="checkbox" id="empty" name="avail" value="booking.start desc, booking.end desc"/><br><br>
        <input type="submit" id="submit" value="Search"/>
    </form>
</body>
</html>