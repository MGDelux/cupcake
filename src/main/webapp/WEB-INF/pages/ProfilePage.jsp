<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <style>
        <jsp:include page="../../css/ProfilePage.css"/>
    </style>
    <div class="topnav">
        <a class="active" href="${pageContext.request.contextPath}/products/">Cupcakes</a>
        <a href="${pageContext.request.contextPath}">Hjem</a>
        <a href="#signout">Log ud</a>
        <a><c:if test="${sessionScope.user.email !=null}">
            ${sessionScope.user.email}
        </c:if> </a>
    </div>
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
                                <input  type="submit" value="Detailer" name="delteOrderLine"/>
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

