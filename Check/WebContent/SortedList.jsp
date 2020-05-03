<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="SortedList.css">
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
    <h1>RESULT</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>TYPE</th>
            <th>BED</th>
            <th>PRICE (PER NIGHT)</th>
            <th>BOOKED BY</th>
            <th>ARRIVAL DATE</th>
            <th>DEPARTURE DATE</th>
        </tr>
        <c:forEach var="var" items="${requestScope.result}">
            <tr>
                <td>${var.id}</td>
                <td>${var.type}</td>
                <td>${var.bed}</td>
                <td>${var.price}</td>
                <td><c:out value="${var.name}" default="empty"/></td>
                <td><c:out value="${var.start}" default="empty"/></td>
                <td><c:out value="${var.end}" default="empty"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>






















