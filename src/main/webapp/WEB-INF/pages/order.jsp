<!DOCTYPE html>
<html lang="da">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <script src="https://kit.fontawesome.com/e79609ac4a.js" crossorigin="anonymous"></script>
    <title>Cupcake Tak for din ordrer</title>
    <style>

        body {
            background: linear-gradient(to bottom right, #6C00D8 80%, rgb(131, 33, 208) 20%);
        }

        .navpanel {
            background-color: #E3E3E3;
            font-size: 20px;
        }

        .fas{
            padding-left: 20px;
            color: #030303;
            text-decoration: none;
        }

        .fas:hover{
            color: blueviolet;
        }

        .ordrer{
            padding-left: 30px;
        }

        .Log{
            margin-left: 1150px;
        }

        .useremail{
            position: relative; margin-top: 20px;
            margin-left: 20px;
        }

        .fa-shopping-basket{
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
    <a class="fas fa-home" href="index.html" ></a>
    <a class ="ordrer" href="index.html">Ordrer</a>
    <a class ="Log ud" href="index.html">Log ud</a>
    <a class ="useremail" href="profile-html">Hello ${sessionScope.email}</a>
    <a class="fas fa-shopping-basket" href="index.html"></a>
</nav>
<!-- Navigationpanel slutter/-->



<div class="container">
    <!-- headers/tekst starter-->
    <div class="header">
        <h1><strong>Vi har modtaget din ordre.</strong></h1>
        <h2 class="header2"><strong>tak for din ordre, du kan se detaljerne om din ordre forneden.</strong></h2>
        <h2 class="ordrenr">Ordre nummer: </h2>
        <h2 class="ordredetalje">Ordre detaljer.</h2>
    </div>
    <!-- headers/tekst slutter-->

    <!-- Ordredetaljer starter-->
    <div>


    </div>
    <!-- Ordredetaljer slutter-->

    <!-- "bestil ordre" button /-->
    <div class="bestil">
        <a href="index.html" target="_blank"><input class="button" type="button" value="Tilbage til forsiden"></a>
    </div>
    <!-- "bestil ordre" button slutter/-->
</div>
</body>
</html>