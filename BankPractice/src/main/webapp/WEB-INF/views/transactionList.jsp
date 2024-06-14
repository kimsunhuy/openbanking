<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transaction List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <header>
        <h1>Bank Practice</h1>
    </header>
    <nav>
        <a href="${pageContext.request.contextPath}/home">Home</a>
        <a href="${pageContext.request.contextPath}/register">Register</a>
        <a href="${pageContext.request.contextPath}/login">Login</a>
    </nav>
    <div class="container">
        <h1>Transaction List</h1>
        <c:if test="${not empty transactions}">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Account Number</th>
                        <th>Name</th>
                        <th>Amount</th>
                        <th>Date</th>
                        <th>Type</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="transaction" items="${transactions}">
                        <tr>
                            <td>${transaction.tId}</td>
                            <td>${transaction.tAccount_number}</td>
                            <td>${transaction.tName}</td>
                            <td>${transaction.tAmount}</td>
                            <td>${transaction.tDate}</td>
                            <td>${transaction.tType}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <button class="back-button" onclick="window.history.back();">Back</button>
    </div>
</body>
</html>
