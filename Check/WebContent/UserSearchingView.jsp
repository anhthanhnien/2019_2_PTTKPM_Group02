<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="UserSearchingView.css">
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
    <h1>USER INFORMATION</h1>
    <table>
        <c:forEach var="var" items="${requestScope.findingrs}" varStatus="loop">
            <tr>
                <th colspan="2">FULL NAME: ${var[0].name}</th>
                <th colspan="1">EMAIL: ${var[0].email}</th>
                <th colspan="1">ROLE: ${var[0].role}</th>
            </tr>
            <tr id="exception">
                <th>BOOKED ROOM'S ID</th>
                <th>ARRIVAL DATE</th>
                <th>DEPARTURE DATE</th>
                <th>TOTAL PRICE</th>
            </tr>
            <c:forEach var="ele" items="${var}">
                <tr>
                    <td><c:out value="${ele.code}" default="empty"/></td>
                    <td><c:out value="${ele.start}" default="empty"/></td>
                    <td><c:out value="${ele.end}" default="empty"/></td>
                    <td><c:out value="${ele.price} VND" default="empty"/></td>
                </tr>
            </c:forEach>
        </c:forEach>
    </table>
</body>
</html>





