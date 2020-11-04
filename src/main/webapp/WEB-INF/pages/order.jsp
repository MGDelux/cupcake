<!DOCTYPE html>
<html lang="da">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <script src="https://kit.fontawesome.com/e79609ac4a.js" crossorigin="anonymous"></script>
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