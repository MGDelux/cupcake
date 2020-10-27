<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>

    <!--@author Mathias .css snips from: CodingNepal -->
    <title>CupCAKES lohin</title>
    <style> <jsp:include page="../../css/Loginstyle.css"/></style>
    <meta charset="utf-8">
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<body>
<div class="center">
    <div class="container">
        <div class="text">
            login
        </div>
        <form method="post" >
            <input type="hidden" name="target" value="login">
            <div class="data">
                <label>Email:</label>
                <input type="text" value="dinEmail@mail.dk" name="email" required>
            </div>
            <div class="data">
                <label>Kodeord:</label>
                <input type="password" name="password" value="password" required>
            </div>
            <div class="forgot-pass">
                <a href="lostpassword.jsp">Glemt dit kodeord?</a></div>
            <div class="btn">
                <div class="inner">
                </div>
                <button type="submit">login</button>
            </div>
            <div class="signup-link">
                Ny Bruger? <a href="register.jsp">opret en bruger nu!</a></div>
            <div class="error-text"> <c:if test="${requestScope.error!= null}">
                ${requestScope.error}
            </c:if></div>
        </form>
    </div>
</div>
</body>
</html>