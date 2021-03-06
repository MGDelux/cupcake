<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

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

    <a><c:if test="${sessionScope.user.email !=null}">
        ${sessionScope.user.email}
    </c:if> </a>
    <form method="post" >
        <button type="hidden" style="outline: 0;" class="logger" name="logger">
            <i class="fas fa-key"></i> Login/logout
        </button>
    </form>
</nav>
<!-- Navigationpanel slutter/-->

<div class="container" align="center">
    <!-- headers/tekst starter-->
    <div class="headers" align="">
        <h1><strong>Velkommen ombord.</strong></h1>
        <h2 class="header2"><strong>Øens bedste cupcakes, vælg og bestil her</strong></h2>
    </div>
</div>
<div class="streng"></div>
<div class="wrapper">
    <form method="post">
    <div class="bestillingTOP">
        <img class="topimage" src="../images/toppings.jpg" alt="error">
        <h1>Topping</h1>
        <p>Vælg:</p>
        <select id="TopToKurv" name="TopToKurv" required>
            <c:forEach items="${toppings}" var="tops">
                <option>${tops.navn}, ${tops.pris} DKK.</option>
            </c:forEach>
        </select>

    </div>
    <div class="bestillingBUT">
        <img class="topimage" src="../images/lowers.jpg" alt="error">
        <h1 class="text">Bund</h1>
        <p>Vælg:</p>
        <select name="BotToKurv" required>
          <c:forEach items="${currentButtoms}" var="buts">
              <option>${buts.navn}, ${buts.pris} DKK.</option>
          </c:forEach>
        </select>



    </div>
        <div class="Addcupcake">
            <button class="addtokurv" name="AddCupcakeToKurv" type="submit">Tilføj til kurv</button>
        </div>
</form>
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