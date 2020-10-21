<!DOCTYPE html>
<!--@author Mathias .css snips from: CodingNepal -->

<html lang="en" dir="ltr">
<head>
    <title>CupCAKES register</title>
    <style> <jsp:include page="css/Loginstyle.css"/></style>
    <meta charset="utf-8">
    <!-- Somehow I got an error, so I comment the title, just uncomment to show -->
    <!-- <title>Popup Login Form Design | CodingNepal</title> -->
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<body>
<div class="center">
    <div class="container">
        <div class="text">
            Register
        </div>
        <form action="FrontController" name="register" method="post" >
            <input type="hidden" name="target" value="register">
            <div class="data">
                <label>Email:</label>
                <input type="text" value="dinEmail@mail.dk" name="email1" required>
            </div>
            <div class="data">
                <label>Kodeord:</label>
                <input type="password" name="password1" value="password" minlength="5" required>
            </div>
            <div class="data">
                <label>Indtast Kodeord igen:</label>
                <input type="password" name="password2" value="password" minlength="5" required>
            </div>
            <div class="btn">
                <div class="inner">
                </div>
                <button type="submit">Register</button>
            </div>
            <div class="signup-link">
                Allerede en bruger? <a href="index.jsp">klik her.</a></div>
            <div class="error-text"> <c:if x="${requestScope.error!= null}">
                ${requestScope.error}
            </c:if></div>
        </form>
    </div>
</div>
</body>
</html>
