<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="da">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <script src="https://kit.fontawesome.com/e79609ac4a.js" crossorigin="anonymous"></script>
    <title>Cupcake homepage</title>
    <style>
        <jsp:include page="../../css/index.css"/>
    </style>
    <p><c:if test="${sessionScope.user.email != null}">
        ${requestScope.user.email}
    </c:if></p>
    <div class="headerimage">
    </div>
</head>
<body>
<!-- Banner logo i top" /-->

<!-- Banner logo i top slutter /-->

<!-- Navigationpanel starter /-->
<nav class="navpanel">
    <!-- Create menu in tab /-->
    <a href="${pageContext.request.contextPath}">TEST</a>
    <a class href="${pageContext.request.contextPath}/AdminPage/">Profil</a>
    <a class="fas fa-shopping-cart" data-fa-transform="down-6" href="index.html"></a>
</nav>
<!-- Navigationpanel slutter/-->


<div class="container" align="center">
    <!-- headers/tekst starter-->
    <div class="headers">
        <h1><strong>Velkommen ombord.</strong></h1>
        <h2 class="header2"><strong>Øens bedste cupcakes, vælg og bestil her</strong></h2>
    </div>
</div>
<div class="streng"></div>
<div class="wrapper">
    <div class="bestillingTOP">
        <img class="topimage" src="../images/toppings.jpg" alt="error">
        <h1>Toppings</h1>
        <p>Vælg:</p>
        <select id="topping" name="topping">
            <c:forEach items="${toppings}" var="tops">
                <option>${tops.navn} ${tops.pris} DKK.</option>
            </c:forEach>
        </select>
        <button>Tilføj til kurv</button>
    </div>


    <div class="bestillingBUT">
        <img class="topimage" src="../images/lowers.jpg" alt="error">
        <h1>Buttoms</h1>
        <p>Vælg:</p>
        <select id="bund" name="bund">
          <c:forEach items="${currentButtoms}" var="buts">
              <option>${buts.navn} ${buts.pris} DKK.</option>
          </c:forEach>
        </select>
        <button>Tilføj til kurv</button>
    </div>

</div>
<!-- "bestil ordre" button /-->

<!-- "bestil ordre" button slutter/-->

</body>
<div class="footer">
    <a> Team Jumbo Snegl: Emil, Janus og Mathias </a>
    <a href="https://github.com/MGDelux/cupcake">| Github |</a>
    <a href="https://www.youtube.com/watch?v=YddwkMJG1Jo" class="secret">?</a>
</div>
</body>
</html>