<%@ page import="java.util.List" %>
<%@ page import="domain.Toppings" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 27-10-2020
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Admin page</title>
    <style>
        <jsp:include page="../../css/adminPage.css"/>
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
<div align="center">
    <!-- table  Buttom laves/-->
    <h1>Admin page</h1>
        <h3>Buttoms</h3>
        <table id="buttom" border="1" title="">
            <thead>
            <!-- table rows id,name og pris laves/-->
            <tr>
                <th>id:</th>
                <th>name:</th>
                <th>pris:</th>
            </tr>
            <!-- table rows slutter/-->
            </thead>
            <tbody>
            <!-- table  border slutter/-->

            <!-- table  Buttom bliver populated/-->
            <c:forEach items="${buttoms}" var="buts">
                <tr>
                    <td>${buts.id}</td>
                    <td>${buts.navn}</td>
                    <td>${buts.pris} kr.</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <form method="post">
        <div class="buttons-buttom">
            <input name="" type="">
            <input name="" type="">
            <button type="submit" name="add-button" class="add-button">Add buttom</button>
            <button type="submit" name="remove-buttom" class="remove-button">Remove buttom</button>
        </div>
        </form>
        <!-- Hele table Buttoms slutter/-->
        <h3>Toppings+
        </h3>
        <table border="1">
            <thead>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>pris</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${toppings}" var="tops">
                <tr>
                    <td>${tops.id}</td>
                    <td>${tops.navn}</td>
                    <td>${tops.pris} kr.</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
            <form method="post">
        <div  class="buttons-toppings">
            <input name="topping" type="text">
            <input name="toppingPris" type="number">
            <button type="submit" class="add-button">Add toppings</button>
            <button type="submit" class="remove-button">Remove toppings</button>
        </div>
            </form>
        <h3>Kunder+
        </h3>
        <table border="1">
            <thead>
            <tr>
                <th>id</th>
                <th>email</th>
                <th>role</th>
            </tr>

            <tbody>
            <c:forEach items="${users}" var="kunder">
            <tr>
                <td>${kunder.id}</td>
                <td>${kunder.email}</td>
                <td>${kunder.role}</td>
            </tr>
            </c:forEach>
            </thead>
            </tbody>
        </table>
    <form method="post">
        <div  class="kunder">
            <input name="kunder" type="">
            <input name="kunder" type="">
            <button type="submit" class="add-button">Add toppings</button>
            <button type="submit" class="remove-button">Remove toppings</button>
        </div>
    </form>
</div>
</body>
</html>
