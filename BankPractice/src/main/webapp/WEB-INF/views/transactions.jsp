<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Transactions</title>
</head>
<body>
    <h1>Transactions</h1>
    <form action="/api/transactions/transfer" method="post">
        <label for="fromAccount">From Account:</label>
        <input type="text" id="fromAccount" name="fromAccount"><br>
        
        <label for="toAccount">To Account:</label>
        <input type="text" id="toAccount" name="toAccount"><br>
        
        <label for="amount">Amount:</label>
        <input type="number" id="amount" name="amount" step="0.01"><br>
        
        <input type="submit" value="Transfer">
    </form>
    
    <h2>Transaction History</h2>
    <c:forEach var="transaction" items="${transactions}">
        <p>${transaction.tDate} - ${transaction.tName} - ${transaction.tAmount}</p>
    </c:forEach>
</body>
</html>
