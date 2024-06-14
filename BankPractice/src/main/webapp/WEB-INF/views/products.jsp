<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Products</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <h1>Products</h1>
    <table>
        <tr>
            <th>Type</th>
            <th>Name</th>
            <th>Detail</th>
            <th>Interest Rate</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.dsType}</td>
                <td>${product.dsName}</td>
                <td>${product.dsDetail}</td>
                <td>${product.dsInterest}</td>
            </tr>
        </c:forEach>
    </table>
    <button onclick="window.history.back();">Back</button>
</body>
</html>
