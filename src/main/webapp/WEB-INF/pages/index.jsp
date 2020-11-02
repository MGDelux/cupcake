<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="da">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <script src="https://kit.fontawesome.com/e79609ac4a.js" crossorigin="anonymous"></script>
    <title>Cupcake homepage</title>
    <link href="<c:url value="css/index.css"/>" rel="stylesheet" />
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
    <a href="${pageContext.request.contextPath}">TEST</a>
    <a class href="${pageContext.request.contextPath}/AdminPage/">Profil</a>
    <a href="${pageContext.request.contextPath}/login/">Login</a>
    <a class="fas fa-shopping-cart" data-fa-transform="down-6" href="${pageContext.request.contextPath}/basket/"></a>
</nav>
<!-- Navigationpanel slutter/-->

<div class="container" align="center">
    <!-- headers/tekst starter-->
    <div class="headers">
        <h1><strong>Velkommen ombord.</strong></h1>
        <h2 class="header2"><strong>Øens bedste cupcakes, vælg og bestil her</strong></h2>
        <img id="Choko" onclick="changeImage()" class="Choko" src="https://www.amo.dk/siteassets/2.-opskrifter/chokolade-cupcake.jpg?maxwidth=1440" alt="Choko cupcake">
        <p class="brødtekst">The earliest extant description of what is now often called a cupcake was in 1796, when a recipe for "a light cake to bake in small cups" was written in American Cookery by Amelia Simmons.
            The earliest extant documentation of the term cupcake itself was in "Seventy-five Receipts for Pastry, Cakes, and Sweetmeats" in 1828 in Eliza Leslie's Receipts cookbook.

            In the early 19th century, there were two different uses for the term cup cake or cupcake. In previous centuries, before muffin tins were widely available, the cakes were often baked in individual pottery cups, ramekins, or molds and took their name from the cups they were baked in.
            This is the use of the name that has remained, and the name of "cupcake" is now given to any small, round cake that is about the size of a teacup. While English fairy cakes vary in size more than American cupcake, they are traditionally smaller and are rarely topped with elaborate frosting.

            The other kind of "cup cake" referred to a cake whose ingredients were measured by volume, using a standard-sized cup, instead of being weighed.
            Recipes whose ingredients were measured using a standard-sized cup could also be baked in cups; however, they were more commonly baked in tins as layers or loaves.
            In later years, when the use of volume measurements was firmly established in home kitchens, these recipes became known as 1234 cakes or quarter cakes, so called because they are made up of four ingredients: one cup of butter, two cups of sugar, three cups of flour, and four eggs.
            They are plain yellow cakes, somewhat less rich and less expensive than pound cake, due to using about half as much butter and eggs compared to pound cake.

            The names of these two major classes of cakes were intended to signal the method to the baker; "cup cake" uses a volume measurement, and "pound cake" uses a weight measurement.
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
