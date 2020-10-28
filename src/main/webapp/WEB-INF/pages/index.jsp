<!DOCTYPE html>
<html lang="da">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <script src="https://kit.fontawesome.com/e79609ac4a.js" crossorigin="anonymous"></script>
    <title>Cupcake homepage</title>
    <style> <jsp:include page="../../css/index.css"/></style>

</head>
<body>
<!-- Banner logo i top" /-->
<div>
    <img src="../../images/olskercupcakes.png" alt="logo cupcakes" title="cupcake" style="width: 100%">
</div>
<!-- Banner logo i top slutter /-->

<!-- Navigationpanel starter /-->
<nav class="navpanel">
    <!-- Create menu in tab /-->
    <a class="fas fa-home" href="${pageContext.request.contextPath}" ></a>
    <a class ="ordrer" href="${pageContext.request.contextPath}/AdminPage/">Ordrer</a>
    <a class ="Log ind" href="${pageContext.request.contextPath}/login/"><c:if z = "${sessionScope.user !=null}">log ind</c:if></a>
    <a class ="useremail" href="profile-html"><c:if x = "${sessionScope.user !=null}">${sessionScope.user.email}</c:if></a>
    <a class="fas fa-shopping-basket" href="index.html"></a>

</nav>
<!-- Navigationpanel slutter/-->


<div class="container">
    <!-- headers/tekst starter-->
    <div class="header">
        <h1><strong>Velkommen ombord.</strong></h1>
        <h2 class="header2"><strong>Øens bedste cupcakes, vælg og bestil her</strong></h2>
    </div>
    <!-- headers/tekst slutter-->
    <div class="dropdowns">
        <!--Dropdown mneu bund-->
        <div class="dropdown-single">
            <div class="bund">
                <p><strong>Vælg bund</strong></p>
                <form>
                    <label for="bund"></label>
                    <select id="bund" name="bund">
                        <option value="Chocolate">Chocolate 5 DKK.</option>
                        <option value="Vanilla">Vanilla 5 DKK.</option>
                        <option value="Nutmeg">Nutmeg 5 DKK.</option>
                        <option value="Pistacio">Pistacio 6 DKK.</option>
                        <option value="Almond">Almond 7 DKK.</option>
                    </select>
                </form>
            </div>
        </div>
        <!--Dropdown mneu bund slutter-->

        <!--Dropdown mneu topping-->
        <div class="dropdown-single">
            <p><strong>Vælg topping</strong></p>
            <form>
                <label for="topping"></label>
                <select id="topping" name="topping">
                    <option value="Chocolate">Chocolate 5 DKK.</option>
                    <option value="Blueberry">Blueberry 5 DKK.</option>
                    <option value="Rasberry">Rasberry 5 DKK.</option>
                    <option value="Crispy">Crispy 6 DKK.</option>
                    <option value="Strawberry">Strawberry 6 DKK.</option>
                    <option value="Rum/Raisin">Rum/Raisin 7 DKK.</option>
                    <option value="Orange">Orange 8 DKK.</option>
                    <option value="Lemon">Lemon 8 DKK.</option>
                    <option value="Blue cheese">Blue cheese 9 DKK.</option>
                </select>
            </form>
        </div>
        <!--Dropdown mneu topping slutter-->

        <!--Dropdown mneu antal-->
        <div class="dropdown-single">
            <p><strong>Vælg antal</strong></p>
            <form>
                <label for="topping"></label>
                <input type="number" min="1" max="30">
            </form>
        </div>
        <!--Dropdown mneu antal slutter-->
    </div>
    <!-- "bestil ordre" button /-->
    <div class="bestil">
        <a href="receivedOrder.html" target="_blank"><input class="button" type="button" value="Bestil ordre"></a>
    </div>
    <!-- "bestil ordre" button slutter/-->
</div>

</body>
</html>