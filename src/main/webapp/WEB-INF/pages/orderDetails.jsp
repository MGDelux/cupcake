<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="da">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <link href="<c:url value="css/Basket.css"/>" rel="stylesheet"/>
    <title>Cupcake Tak for din ordrer</title>
    <style>
        <jsp:include page="../../css/Productpage.css"/>
    </style>
</head>
<body>
<!-- Banner logo i top" /-->
<!-- Banner logo i top slutter /-->

<!-- Navigationpanel starter /-->
<nav class="navpanel">
    <a class="fas fa-home" href="${pageContext.request.contextPath}" ></a>

</nav>
<!-- Navigationpanel slutter/-->



<div class="container">
    <!-- headers/tekst starter-->
    <div align="center">
        <h2 class="ordredetalje">Ordre detaljer:</h2>
        <!-- Ordretaljer starter-->
    </div>
    <div class="ordredetalje" align="center">
        <label>Din order:</label>
        <table id="ordre" border="1" title="Ordrelinje" class="orderBorder">
            <thead>
            <tr>

                <th align="center">Cupcake:</th>
                <th align="center">Topping:</th>
                <th align="center">Bottom:</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${orderContent}" var="cartsitems">
                <tr>
                    <td align="center">
                        #${cartsitems.cupcake}
                    </td>
                    <td align="center">
                            ${cartsitems.top}
                    </td>
                    <td align="center">
                            ${cartsitems.bot}
                    </td>

                </tr>
            </c:forEach>
            </tbody>

        </table>
        <a href="${pageContext.request.contextPath}/profilepage/"><input class="backbutton" type="button" value="Tilbage"></a>

    </div>
    <!-- "bestil ordre" button /-->

    <!-- "bestil ordre" button slutter/-->
</div>
</body>
</html>