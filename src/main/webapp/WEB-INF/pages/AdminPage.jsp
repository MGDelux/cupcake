<%@ page import="java.util.List" %>
<%@ page import="domain.Toppings" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 27-10-2020
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
    <style> <jsp:include page="../../css/adminPage.css"/></style>
</head>
<body>
<div align="center">
    <h2>Buttoms</h2>
    <table border="1" title="">
        <thead>
        <tr>
            <th>id:</th>
            <th>name:</th>
            <th>pris:</th>

        </tr>
        </thead>
        <tbody>
<c:forEach items="${buttoms}" var="buts">
    <tr>
        <td>${buts.id}</td>
        <td>${buts.navn}</td>
        <td>${buts.pris} kr.</td>
    </tr>
</c:forEach>
        </tbody>
    </table>
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
</div>
</body>
</html>
