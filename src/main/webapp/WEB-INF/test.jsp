<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Dynamic Drop Down List Demo - CodeJava.net</title>
</head>
<body>
<main role="main" class="toppings"action="FrontController" methode="post">
    <select name="country" id="country">
        <c:forEach items="${mapCountries}" var="country">
            <option value="${country.key}">${country.value}</option>
        </c:forEach>
    </select>
</main>
</body>
</html>