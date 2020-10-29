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
        <jsp:include page="../../css/Productpage.css"/>
    </style>
    <div class="headerimage">
    </div>
</head>
<body>
<!-- Banner logo i top" /-->

<!-- Banner logo i top slutter /-->

<!-- Navigationpanel starter /-->
<nav class="navpanel">
    <!-- Create menu in tab /-->
    <c:forEach items="${requestScope.navbar.GetNavBarLink()}" var="navLink">
  <a href="<c:url value="${navLink.url}"/>">${navLink.name} <c:if test="${navLink.active}"></c:if> </a>
    </c:forEach>
    <a class="userMail"><c:if test="${sessionScope.loggedIn == true}">
        ${sessionScope.user.email}
    </c:if></a>
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
        <form method="post">
        <img class="topimage" src="../images/toppings.jpg" alt="error">
        <h1>Toppings</h1>
        <p>Vælg:</p>
        <select id="TopToKurv" name="TopToKurv" required>
            <c:forEach items="${toppings}" var="tops">
                <option>${tops.navn} ${tops.pris} DKK.</option>
            </c:forEach>
        </select>
        <button name="sumbitTopsTilKurv" type="submit">Tilføj til kurv</button>
            </form>
    </div>
    <div class="bestillingBUT">
        <form method="post">
        <img class="topimage" src="../images/lowers.jpg" alt="error">
        <h1>Buttoms</h1>
        <p>Vælg:</p>
        <select name="BotToKurv" required>
          <c:forEach items="${currentButtoms}" var="buts">
              <option>${buts.navn} ${buts.pris} DKK.</option>
          </c:forEach>
        </select>
        <button  name="sumbitBotsTilKurv" type="submit">Tilføj til kurv</button>
        </form>
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