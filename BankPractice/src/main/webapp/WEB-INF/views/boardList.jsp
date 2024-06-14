<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Board List</title>
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
        <h1>Board List</h1>
        <c:if test="${not empty boards}">
            <table>
                <thead>
                    <tr>
                        <th>Type</th>
                        <th>Number</th>
                        <th>Title</th>
                        <th>Writer</th>
                        <th>Content</th>
                        <th>Regdate</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="board" items="${boards}">
                        <tr>
                            <td>${board.bType}</td>
                            <td>${board.bNumber}</td>
                            <td>${board.bTitle}</td>
                            <td>${board.bWriter}</td>
                            <td>${board.bContent}</td>
                            <td>${board.bRegdate}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</body>
</html>
