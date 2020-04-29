<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="feedback.css">
</head>
<body>
    <ol> 
        <li><a href="https://localhost:8443/Check/AccountController">${sessionScope.user.name}</a>
        <li><a href="https://localhost:8443/Check/RoomBookingController" target="_self">BOOK</a></li>
        <li><a href="https://localhost:8443/Check/RoomListController">ROOM LIST</a></li>
        <li><a href="https://localhost:8443/Check/LoginSucceeded.jsp" target="_self">HOME</a></li>
    </ol>
    <h1>FEEDBACK FORM</h1>
    <form action="FeedbackController">
        <label id="nx">Feedback</label><br><br>
        <textarea rows="7" cols="50" id="nx" name="fb" required></textarea><br><br>
        <label id="dg">Rate</label><br><br>
        <input type="number" min="0" max="10" id="dg" name="rate" placeholder="based on 10 point scale (Exp: 9)" required/><br><br>
        <input type="submit" id="submit" value="Send feedback"/>
    </form>
</body>
</html>