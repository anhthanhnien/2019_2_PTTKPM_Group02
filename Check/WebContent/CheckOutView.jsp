<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="CheckOutView.css">
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
    <h1>CHECK OUT CONFIRMATION</h1>
    <table id="fuck">
        <tr>
            <th>CLIENT'S NAME</th>
            <th>ID</th>
            <th>TYPE</th>
            <th>BED</th>
            <th>ARRIVAL DATE</th>
            <th>DEPARTURE DATE</th>
            <th>NIGHT</th>
            <th>PRICE (PER NIGHT)</th>
            <th>TOTAL PRICE</th>
        </tr>
        <c:forEach var="ele" items="${requestScope.bill}">
            <tr>
                <td>${ele.name}</td>
                <td>${ele.id}</td>
                <td>${ele.type}</td>
                <td>${ele.bed}</td>
                <td>${ele.start}</td>
                <td>${ele.end}</td>
                <td>${ele.night}</td>
                <td>${ele.price1} VND</td>
                <td>${ele.price2} VND</td>
            </tr>
        </c:forEach>
    </table><br>
    <table id="exception">
        <tr>
            <th>BILL</th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th></th>
            <th>${requestScope.billvalue} VND</th>
        </tr>
    </table><br><br>
    <button id="cancel"><a href="https://localhost:8443/Check/AdminLoginSucceeded.jsp">Cancel</a></button>
    <button id="confirm"><a href="https://localhost:8443/Check/CheckOutCompleted?email=${requestScope.bill[0].email}">Confirm</a></button>
</body>
</html>


