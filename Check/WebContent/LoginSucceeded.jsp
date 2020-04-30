<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<link rel="stylesheet" href="mainpage.css"/>
</head>
<body id="body">
    <ol> 
        <li><a href="https://localhost:8443/Check/AccountController">${sessionScope.user.name}</a>
        <li><a href="https://localhost:8443/Check/RoomBookingController" target="_self">BOOK</a></li>
        <li><a href="https://localhost:8443/Check/RoomListController">ROOM LIST</a></li>
        <li><a href="https://localhost:8443/Check/LoginSucceeded.jsp" target="_self">HOME</a></li>
    </ol>
    <div id="dichvu">
        <ul>
	        <li><a href="https://localhost:8443/Check/feedback.jsp"  target="_self">Rate</a></li>
		    <li><a href="https://localhost:8443/Check/contact2.jsp"  target="_self">Contact</a></li>
		    <li><a href="https://localhost:8443/Check/service2.jsp"  target="_self">Service</a></li>
	        <li><a href="https://localhost:8443/Check/food2.jsp"  target="_self">Food</a></li>		
	    </ul>
    </div>
</body>
</html>