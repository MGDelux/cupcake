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
        <a class="active" href="${pageContext.request.contextPath}/products/">Product page</a>
        <a href="#${pageContext.request.contextPath}">Index</a>
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
        <p>This is the profile section. </p>
        <p>You can see your credits and orders here. </p>
        <br> <br>
        <a></a>
        <div class="profilinfo" align="center">
            <p> Email:
                <a><c:if test="${sessionScope.user.email !=null}">
                ${sessionScope.user.email}
            </c:if> </a>
            </p>
            <br>
            <p> Credits:
            <a><c:if test="${sessionScope.user.credits !=null}">
                ${sessionScope.user.credits}
            </c:if> </a>
            </p>
            <br> <br> <br>
        </div>
        <div class="container" align="center">
            <h3> Your Order</h3>
            <select name="order" id="order">
            </select>
            <br> <br> <br> <br>
        </div>
        </form>

    </section>
</article>
</body>
</html>
