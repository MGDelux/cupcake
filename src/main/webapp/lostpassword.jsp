<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <!--@author Mathias .css snips from: CodingNepal -->
    <title>CupCAKES password recovery</title>
    <style> <jsp:include page="css/Loginstyle.css"/></style>
    <meta charset="utf-8">
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<body>
<div class="center">
    <div class="container">
        <div class="text">
            Nulstil kodeord
        </div>
        <form action="FrontController" name="passwordReset" method="post" >
            <input type="hidden" name="target" value="passwordReset">
            <div class="data">
                <label>Email:</label>
                <input type="text" value="dinEmail@mail.dk" name="email" required>
            </div>
            <div class="data">
                <label>last remembered password:</label>
                <input type="password" name="password1" value="password" required>
            </div>
            <div class="inner">
                <button type="submit">reset</button>
            </div>

            <div class="signup-link">
                Ny Bruger? <a href="register.jsp">opret dig nu!</a></div>
            <div class="error-text"> <c:if test="${requestScope.error!= null}">
                ${requestScope.error}
            </c:if></div>
        </form>
    </div>
</div>
</body>
</html>
