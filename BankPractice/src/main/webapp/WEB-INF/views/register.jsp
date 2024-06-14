<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    <script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
    <script>
        function execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {
                    document.getElementById('cAdress').value = data.address;
                }
            }).open();
        }

        function sendVerificationCode() {
            const phoneNumber = document.getElementById('cPhone_num').value;
            fetch('${pageContext.request.contextPath}/clients/sendVerificationCode', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: new URLSearchParams({ phoneNumber: phoneNumber }),
            })
            .then(response => response.text())
            .then(data => {
                alert(data);
            })
            .catch(error => {
                console.error('Error:', error);
            });
        }

        function checkForm() {
            let f = document.signUpForm;
            let name = f.cName;
            let id = f.cId;
            let password = f.cPassword;
            let phone = f.cPhone_num;
            let email = f.cEmail;
            let address = f.cAdress;
            let birth = f.cBirth;
            let verificationCode = f.verification_Code;

            const specialChars = /[`~!@#$%^&*()\-_=+{};:'|,.<>\/?]+/g;
            const repeatedChars = /(.)\1{2,}/g;
            const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;

            if (name.value === '') {
                alert("성함을 입력해주세요.");
                name.focus();
                return false;
            }

            if (id.value === '') {
                alert("ID를 입력해주세요.");
                id.focus();
                return false;
            }

            if (id.value.length < 9) {
                alert("ID는 9글자 이상으로 만들어주세요.");
                id.focus();
                return false;
            }

            if (id.value.indexOf('admin', 'administrator', 'manager') === 0) {
                alert("사용 금지된 단어가 포함되어 있습니다.");
                id.focus();
                return false;
            }

            if (password.value === '') {
                alert("비밀번호를 입력해주세요.");
                password.focus();
                return false;
            }

            if (password.value.length < 9 || !specialChars.test(password.value)) {
                alert("비밀번호는 최소 9글자 이상, 영문자 + 특수문자의 조합이어야 합니다.");
                password.focus();
                return false;
            }

            if (repeatedChars.test(password.value)) {
                alert("연속된 문자가 포함될 수 없습니다.");
                password.focus();
                return false;
            }

            if (phone.value === '') {
                alert("핸드폰 번호를 입력해주세요.");
                phone.focus();
                return false;
            }

            if (verificationCode.value === '') {
                alert("인증번호를 입력해주세요.");
                verificationCode.focus();
                return false;
            }

            if (address.value === '') {
                alert("주소를 입력해주세요.");
                address.focus();
                return false;
            }

            if (email.value === '' || !emailRegex.test(email.value)) {
                alert("유효하지 않은 메일주소입니다.");
                email.focus();
                return false;
            }

            if (birth.value === '') {
                alert("생년월일을 선택해 주세요.");
                birth.focus();
                return false;
            }

            return true;
        }
        function checkId() {
            var cId = $('#cId').val();
            $.ajax({
                url: '${pageContext.request.contextPath}/clients/checkId',
                type: 'GET',
                data: { cId: cId },
                success: function(response) {
                    if (response) {
                        $('#idCheckResult').text('ID already exists.').css('color', 'red');
                    } else {
                        $('#idCheckResult').text('ID is available.').css('color', 'green');
                    }
                }
            });
        }
    </script>
</head>
<body>
    <h1>Register</h1>
    <form:form name="signUpForm" modelAttribute="client" action="${pageContext.request.contextPath}/clients/register"  method="post" onsubmit="return checkForm()">
        <form:label path="cName">Name:</form:label>
        <form:input path="cName" required="true" placeholder="성함"/><br/>

        <form:label path="cId">ID:</form:label>
        <form:input path="cId" required="true" placeholder="계정은 9자 이상으로 만들어주세요"/><br/>

        <form:label path="cPassword">Password:</form:label>
        <form:password path="cPassword" required="true" onkeyup="checkId()" placeholder="영문자,숫자,특수문자 포함 9자이상"/><br/>
		<span id="idCheckResult"></span><br>

        <form:label path="cPhone_num">Phone Number:</form:label>
        <form:input path="cPhone_num" id="cPhone_num" required="true" placeholder="'-' 없이 입력" /><br/>
        <button type="button" onclick="sendVerificationCode()">Send Verification Code</button><br/>

        <form:label path="verification_Code">Verification Code:</form:label>
        <form:input path="verification_Code" placeholder="인증코드" /><br/>

        <form:label path="cBirth">Birth Date:</form:label>
        <form:input path="cBirth" required="true" placeholder="yyyy-mm-dd"/><br/>

        <form:label path="cAdress">Address:</form:label>
        <form:input path="cAdress" id="cAdress" required="true" onclick="execDaumPostcode()" placeholder="거주지 주소를 입력해주세요."/>
        <br/>

        <form:label path="cEmail">Email:</form:label>
        <form:input path="cEmail" type="email" required="true" placeholder="example@exam.com"/><br/>

        <input type="submit" value="Register"/>
    </form:form>

    <c:if test="${not empty errorMessage}">
        <div class="error">${errorMessage}</div>
    </c:if>
</body>
</html>
