<!DOCTYPE html>
<html lang="da">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cupcake homepage</title>
    <style>

        body {
            background-color: rgb(70, 22, 110);
        }

        .navpanel {
            background-color: #E3E3E3;
            font-size: 20px;
        }

        .home{
            padding-left: 20px;
        }
        .ordrer{
            padding-left: 30px;
        }

        .Log{
            margin-left: 1400px;
        }

        .basket{
            margin-left: 200px;
        }

        .container {
            background-color: #E3E3E3;
            padding-bottom: 100px;

        }

        .header {
            position: relative;
            left: 70px;
        }

        .header2 {
            position: relative;
            top: -20px;
        }

        .bund {
            position: relative; left: 70px;
        }

        * {
            box-sizing: border-box;
        }

        .dropdown-single {
            float: left;
            width: 33.33%;
            padding: 10px;
        }

        .dropdowns::after {
            content: "";
            clear: both;
            display: table;
        }

        .button{
            background-color: rgb(70, 22, 110);
            margin-left: 1265px;
            margin-top: 20px;
            text-align: center;
            font-size: 20px;
            display: inline-block;
            cursor: pointer;
            padding: 5px 10px;
            border: none;
            color: #E3E3E3;
        }


    </style>

</head>
<body>
<!-- Banner logo i top" /-->
<div>
    <img src="Images/olskercupcakes.png" alt="logo cupcakes" style="width:1900px;height:430px"/>
</div>
<!-- Banner logo i top slutter /-->

<!-- Navigationpanel starter /-->
<nav class="navpanel">
    <a class="home" href="index.html">Home</a>
    <a class ="ordrer" href="index.html">Ordrer</a>
    <a class ="Log ind" href="index.html">Log ind</a>
    <a class ="Basket" href="index.html">basket</a>
</nav>
<!-- Navigationpanel slutter/-->


<div class="container">
    <!-- headers/tekst starter-->
    <div class="header">
        <h1><strong>Velkommen ombord.</strong></h1>
        <p>Hello ${sessionScope.email} </p>
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