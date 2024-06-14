<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Account</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<div class="create-account">
    <h1>Create Account</h1>
    <form action="${pageContext.request.contextPath}/account/create" method="post">
        <h2>Terms and Conditions</h2>
        <label><input type="checkbox" name="terms" value="agree"> Agree to terms</label><br>
        <label><input type="checkbox" name="privacy" value="agree"> Agree to privacy policy</label><br>
        
        <h2>Select Product</h2>
        <select name="product">
            <option value="1">Savings Product 1</option>
            <option value="2">Savings Product 2</option>
            <option value="3">Savings Product 3</option>
            <option value="4">Deposit Product 1</option>
            <option value="5">Deposit Product 2</option>
            <option value="6">Deposit Product 3</option>
        </select><br>

        <label for="acName">Account Name:</label>
        <input type="text" id="acName" name="acName"><br>
        
        <label for="acPassword">Account Password:</label>
        <input type="password" id="acPassword" name="acPassword"><br>
        
        <input type="submit" value="Create Account">
    </form>
    <button onclick="window.history.back()">Back</button>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>
