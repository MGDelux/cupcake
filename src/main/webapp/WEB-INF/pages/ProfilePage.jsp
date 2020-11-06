<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 28-10-2020
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Profile page</title>
    <script src="https://kit.fontawesome.com/e79609ac4a.js" crossorigin="anonymous"></script>
    <style>
        <jsp:include page="../../css/ProfilePage.css"/>
    </style>
    <nav class="topnav">
        <a class="active" href="${pageContext.request.contextPath}/products/">Cupcakes</a>
        <a href="${pageContext.request.contextPath}">Hjem</a>
        <a><c:if test="${sessionScope.user.email !=null}">
            ${sessionScope.user.email}
        </c:if> </a>
        <form method="post" >
            <button type="hidden" style="outline: 0;" class="logger" name="logger">
                <i class="fas fa-key"></i> Login/logout
            </button>
        </form>
    </nav>
</head>
<body>
<article>
    <section>
        <h1> Profile </h1>
        <p>Din profil: </p>
        <br> <br>
        <a></a>
        <div class="profilinfo" align="center">
            <p> Email:
                <a><c:if test="${sessionScope.user.email !=null}">
                ${sessionScope.user.email}
            </c:if> </a>
            </p>
            <br>
            <p> Dit Kredit:
            <a><c:if test="${sessionScope.user.kredit !=null}">
                ${sessionScope.user.kredit} kr.
            </c:if> </a>
            </p>
            <br> <br> <br>
        </div>
        <div class="container" align="center">
            <h3>Dine ordre:</h3>
            <table border="1">
                <thead>
                <tr>
                    <td>ID:</td>
                    <td>Order Pris:</td>
                    <td>Dato:</td>
                    <td>Order Detailer:</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${Order}" var="order">
                    <tr>
                        <td>${order.orderId}</td>
                        <td>${order.orderPrice} ddk.-</td>
                        <td>${order.orderDate}</td>
                        <td align="center">
                            <form method="post">
                                <input type="hidden" name="idStuff" value="${order.orderId}">
                                <input  type="submit" value="Detailer" name="CheckDetails"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        </form>

    </section>
</article>
</body>
</html>

