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
</head>
<body>
<div align="center">
    <!-- table  Buttom laves/-->
        <h2>Buttoms</h2>
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
            <input>
            <input>
            <button name="add-button" class="add-button">Add buttom</button>
            <button name="remove-buttom" class="remove-button">Remove buttom</button>
        </div>
        </form>
        <!-- Hele table Buttoms slutter/-->
        <h2>Toppings+
        </h2>
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
        <h2>Kunder+
        </h2>
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
            <input name="kunder" type="text">
            <input name="kunder" type="number">
            <button type="submit" class="add-button">Add toppings</button>
            <button type="submit" class="remove-button">Remove toppings</button>
        </div>
    </form>
</div>
</body>
</html>
