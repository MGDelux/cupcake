<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <a href="${pageContext.request.contextPath}">Home</a>
    <a class href="${pageContext.request.contextPath}/products/">Products</a>
    <a href="${pageContext.request.contextPath}/ProfilePage/">Profil</a>
</nav>
<!-- Navigationpanel slutter/-->


<div class="container">
    <div class="header">
        <h1 class="ordredetalje">Ordre detaljer:</h1>
        <a>Antal af cupcakes: ${cupcakesAntal} - total pris: ${totalSum} DDK.-</a>
    </div>
    <div class="container2">
    </div>


    <!-- Ordredetaljer starter-->
    <form method="post">
    <div class="ordredetalje" align="center">
        <label>Din order:</label>
        <table id="ordre" border="1" title="Ordrelinje" class="orderBorder">
            <thead>
            <tr>

                <th align="center">Cupcake: </th>
                <th align="center">Topping: </th>
                <th align="center">Bottoms: </th>
                <th align="center">Ændre: </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${cart}" var="cartsitems">
                <tr>
                    <td align="center">
                           #${cartsitems.cartItem}
                    </td>
                    <td align="center">
                            ${cartsitems.toppings}
                    </td>
                    <td align="center">
                            ${cartsitems.bottoms}
                    </td>
                    <td align="center">
                    <input  type="checkbox" name="DeleteButton" value="Slæt" >
                    </td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>
    </form>
</div>
</body>
<fotter class="footer">
    <a> Team Jumbo Snegl: Emil, Janus og Mathias </a>
    <a href="https://github.com/MGDelux/cupcake">| Github |</a>
</fotter>
</html>