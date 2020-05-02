<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="RoomBookingSearch.css">
</head>
<body>
    <ol> 
        <li><a href="https://localhost:8443/Check/AccountController">${sessionScope.user.name}</a>
        <li><a href="https://localhost:8443/Check/RoomBookingCancel">HOME</a></li>
    </ol>
    <h1>ROOM LIST</h1>
    <form action="RoomBookingConclusion" method="POST">
        <label for="dem">NIGHT</label><br><br>
        <input type="number" id="dem" name="night" placeholder="Enter the number of nights you want to stay" required><br><br>
        <label for="loai">ROOM TYPE (PLEASE CHOOSE AT LEAST ONE TYPE OR PRESS CANCEL TO CANCEL THE BOOKING PROCESS)</label><br><br>
        <table>
            <tr>
                <th>ID</th>
		        <th>TYPE</th>
		        <th>BED</th>
		        <th>PRICE (PER NIGHT)</th>
		        <th>IMAGE</th>
            </tr>
            <c:forEach var="room" items="${sessionScope.roomlist}">
                <tr>
                    <td><input type="checkbox" id="loai" name="choice" value="${room.id}">${room.id}</td>
                    <td>${room.type}</td>
                    <td>${room.bed}</td>
                    <td>${room.price} VND</td>
                    <td><img alt="room's image" src="${room.bed}bed.jpg"></td>
                </tr>
            </c:forEach>
        </table><br>
        <input type="submit" value="Book" id="submit">
    </form>
    <button id="cancel"><a href="https://localhost:8443/Check/RoomBookingCancel">Cancel</a></button>
</body>
</html>

        
        
        
    
        
        
        
        
        
        
        
        
        
        
        