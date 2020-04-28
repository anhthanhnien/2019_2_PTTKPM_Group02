<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="BookingApplicationView.css">
</head>
<body>
    <ol> 
        <li><a href="https://localhost:8443/Check/AccountController">${sessionScope.user.name}</a>
        <li><a href="https://localhost:8443/Check/RoomBookingController" target="_self">BOOK</a></li>
        <li><a href="https://localhost:8443/Check/RoomListController">ROOM LIST</a></li>
        <li><a href="https://localhost:8443/Check/LoginSucceeded.jsp" target="_self">HOME</a></li>
    </ol>
    <c:choose>
        <c:when test="${not empty requestScope.bookinginfo}">
            <h1>YOUR BOOKING ORDER(S)</h1>
            <c:forEach var="var1" items="${bookinginfo}">
                <table>
                    <tr>
                        <th colspan="2">ARRIVAL DATE: ${var1[0].start}</th>
                        <th colspan="2">DEPARTURE DATE: ${var1[0].end}</th>
                        <th colspan="1"><button><a href="https://localhost:8443/Check/CancelOrder?start=${var1[0].start}&end=${var1[0].end}">CANCEL ORDER</a></button></th>
                    </tr>
                    <tr id="exception">
                        <th>ID</th>
                        <th>TYPE</th>
                        <th>BED</th>
                        <th>NIGHT</th>
                        <th>PRICE (PER NIGHT)</th>
                    </tr>
                    <c:forEach var="var2" items="${var1}">
                        <tr>
                            <td>${var2.id}</td>
                            <td>${var2.type}</td>
                            <td>${var2.bed}</td>
                            <td>${var2.night}</td>
                            <td>${var2.price} VND</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <h1>YOUR BOOKING ORDER IS EMPTY</h1>
        </c:otherwise>
    </c:choose>
</body>
</html>

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 