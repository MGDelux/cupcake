<!DOCTYPE html>
<html lang="da">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <script src="https://kit.fontawesome.com/e79609ac4a.js" crossorigin="anonymous"></script>
    <title>Cupcake basket</title>
    <style>
        <jsp:include page="../../css/Basket.css"/>
    </style>
    <p><c:if test="${sessionScope.user.email != null}">
        ${requestScope.user.email}
    </c:if></p>
</head>
<body>
<!-- Banner logo i top" /-->
<div class="headerimage">
</div>
<!-- Banner logo i top slutter /-->

<!-- Navigationpanel starter /-->
<nav class="navpanel">
    <!-- Create menu in tab /-->
    <a href="${pageContext.request.contextPath}">TEST</a>
    <a class href="${pageContext.request.contextPath}/AdminPage/">Profil</a>
    <a href="${pageContext.request.contextPath}/login/">Login</a>
    <a class="fas fa-shopping-cart" data-fa-transform="down-6" href="index.html"></a>
</nav>
<!-- Navigationpanel slutter/-->


<div class="container">
    <div class="header">
        <h1 class="tak">Tak for din ordre, håber vi ser dig igen! </h1>
        <h2 class="ordrenr">Ordre nummer: </h2>
        <h2 class="ordredetalje">Ordre detaljer:</h2>
    </div>

    <div class="container2">

    </div>


    <!-- Ordredetaljer starter-->
    <div class="ordredetalje" align="center">
        <table id="ordre" border="1" title="Ordrelinje">
            <thead>
            <tr>
                <th>antal:</th>
                <th>bund:</th>
                <th>topping:</th>
                <th>pris:</th>
            </tr>
            </thead>
            <tbody>

            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            </tbody>
            <tfoot>

            <tr>
                <td>
                <td></td>
                </td>
            </tr>
            </tfoot>

        </table>
    </div>

</div>

</body>
<fotter class="footer">
    <a> Team Jumbo Snegl: Emil, Janus og Mathias </a>
    <a href="https://github.com/MGDelux/cupcake">| Github |</a>
    <a href="https://www.youtube.com/watch?v=YddwkMJG1Jo" class="secret">?</a>
</fotter>
</html>