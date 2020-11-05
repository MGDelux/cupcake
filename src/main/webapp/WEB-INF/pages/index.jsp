<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="da">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <script src="https://kit.fontawesome.com/e79609ac4a.js" crossorigin="anonymous"></script>
    <title>Cupcake homepage</title>
    <link href="<c:url value="css/index.css"/>" rel="stylesheet"/>
    <p><c:if test="${sessionScope.user.email != null}">
        ${requestScope.user.email}
    </c:if></p>

    <div class="headerimage">
    </div>
</head>
<body>

<!-- Navigationpanel starter /-->
<nav class="navpanel">
    <!-- Create menu in tab /-->
    <c:forEach items="${requestScope.indexNavbar.GetNavBarLink()}" var="navLink">
        <a href="<c:url value="${navLink.url}"/>">${navLink.name} <c:if test="${navLink.active}"></c:if> </a>
    </c:forEach>
    <a><c:if test="${sessionScope.user.email !=null}">
        ${sessionScope.user.email}
    </c:if> </a>
    <form method="post" >
        <button type="hidden" style="outline: 0;" class="logger">
            <i class="fas fa-key"></i> Login/logout

        </button>
    </form>
</nav>
<!-- Navigationpanel slutter/-->




<div class="container" align="center">
    <!-- headers/tekst starter-->
    <div class="headers">
        <h1><strong>Velkommen ombord.</strong></h1>
        <h2 class="header2"><strong>Øens bedste cupcakes, vælg og bestil her</strong></h2>
        <img id="Choko" onclick="changeImage()" class="Choko"
             src="https://www.amo.dk/siteassets/2.-opskrifter/chokolade-cupcake.jpg?maxwidth=1440" alt="Choko cupcake">
        <br>
        <p class="brødtekst"> Olsker Cupcakes er en nyopstartet iværksættervirksomhed med base på Bornholm. Olskers
            cupcakes startede i 2020 med en vision om at bringe lokal samfundet sammen omkring den lille søde dessert.
            Olsker Cupcakes sætter økologi i førersædet og har dermed fundet frem til den helt rigtige opskrift.
            Med vores lokale råvarer og sans for kvalitet formårer vi at producere ikke mindst miljøvenlige, men også
            førsteklasses cupcakes til en pris som alle kan være med på.
            <br><br><br><br>
        </p>
    </div>
</div>

</body>
<div class="footer">
    <a> Team Jumbo Snegl: Emil, Janus og Mathias </a>
    <a href="https://github.com/MGDelux/cupcake">| Github |</a>
    <a href="https://www.youtube.com/watch?v=YddwkMJG1Jo" class="secret">?</a>
</div>
</body>
</html>
