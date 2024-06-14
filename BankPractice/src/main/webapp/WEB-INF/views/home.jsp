<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
    <div class="container">
        <h1>Welcome to the BankPractice</h1>
        <c:choose>
            <c:when test="${not empty sessionScope.client}">
                <p>Hello, ${sessionScope.client.cName}!</p>
                <a href="${pageContext.request.contextPath}/accounts/create">Create Account</a>
                <a href="${pageContext.request.contextPath}/transactions">Transactions</a>
                <a href="${pageContext.request.contextPath}/logout">Logout</a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/clients/register">Register</a>
                <a href="${pageContext.request.contextPath}/login">Login</a>
            </c:otherwise>
        </c:choose>
    </div>
    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
