<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<div class="login">
    <h1>Login</h1>
    <form action="${pageContext.request.contextPath}/clients/login" method="post">
        <label for="cId">ID:</label>
        <input type="text" id="cId" name="cId"><br>

        <label for="cPassword">Password:</label>
        <input type="password" id="cPassword" name="cPassword"><br>

        <input type="submit" value="Login">
    </form>
    <button onclick="window.history.back()">Back</button>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
