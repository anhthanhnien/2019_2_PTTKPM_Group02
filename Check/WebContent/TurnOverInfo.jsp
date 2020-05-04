<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="TurnOverInfo.css">
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
    <c:choose>
        <c:when test="${empty requestScope.ans}">
            <h1>THE TURN OVER IS EMPTY</h1>
        </c:when>
        <c:otherwise>
            <h1>TURNOVER FROM EACH ORDER</h1>
            <table id="fuck">
                <tr>
                    <th>FROM</th>
                    <th>TO</th>
                    <th>TURNOVER</th>
                </tr>
                <c:forEach var="var" items="${requestScope.ans}">
                    <tr>
                        <td>${var.start}</td>
                        <td>${var.end}</td>
                        <td>${var.total} VND</td>
                    </tr>
                </c:forEach>
            </table>
            <table id="exception">
                <tr>
                    <th>TOTAL TURNOVER</th>
                    <th></th>
                    <th>${requestScope.sum} VND</th>
                </tr>
            </table>
        </c:otherwise>
    </c:choose>
</body>
</html>


