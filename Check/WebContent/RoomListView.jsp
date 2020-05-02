<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="roomlistview.css">
</head>
<body>
    <c:choose>
        <c:when test="${empty sessionScope.user}">
            <%
                Cookie cookie = new Cookie("JSESSIONID", "");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            %>
            <ol>
                <li><a href="https://localhost:8443/Check/RoomBookingController">BOOK</a></li>
                <li><a href="https://localhost:8443/Check/RoomListController">ROOM LIST</a></li>
                <li><a href="login.html" target="_self">LOG IN</a></li>
                <li><a href="signup.html" target="_self">SIGN UP</a></li>
                <li><a href="index.html">HOME</a></li>
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
    <h1>ROOM LIST</h1>
    <form action="RoomListSortController" method="POST">
        <label for="sx">Sorting options: </label>
        <select name="sort" id="sx">
            <option value="order by type">Type</option>
            <option value="order by type, bed">Price (low to high)</option>
            <option value="order by type, bed desc">Price (high to low)</option>
        </select>
        <input type="submit" value="Sort">
    </form><br><br>
    <table>
        <tr>
            <th>ID</th>
		    <th>TYPE</th>
		    <th>BED</th>
		    <th>PRICE (PER NIGHT)</th>
		    <th>IMAGE</th>
        </tr>
        <c:forEach var="ele" items="${requestScope.dsphong}">
            <tr>
                <td>${ele.id}</td>
                <td>${ele.type}</td>
                <td>${ele.bed}</td>
                <td>${ele.price} VND</td>
                <td><img alt="room's image" src="${ele.bed}bed.jpg"></td>
            </tr>
        </c:forEach>
    </table>
    
</body>
</html>