<%@ page import="java.util.List" %>
<%@ page import="domain.Toppings.Toppings" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

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
        <a class="active" href="${pageContext.request.contextPath}/products/">Produkter</a>
        <a href="${pageContext.request.contextPath}/">Hjem</a>
        <a><c:if test="${sessionScope.user.email !=null}">
            ${sessionScope.user.email} - ${sessionScope.user.role}
        </c:if> </a>
    </div>
</head>
<body>
<div align="center">
    <!-- table  Buttom laves/-->
    <h1>Admin side</h1>
        <h3>Cupcake bund:</h3>
        <table id="buttom" border="1" title="">
            <thead>
            <!-- table rows id,name og pris laves/-->
            <tr>
                <th>id:</th>
                <th>navn:</th>
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
            <input name="buttomName" type="text" value="Bund navn" required>
            <input name="buttomPris" type="number" value="0" required>
            <button type="submit" name="add-button" class="add-button">Tilføj bund</button>
        </div>
        </form>
    <form method="post">
        <div class="buttons-buttom" align="center">
            <label>ID: </label>
            <input name="removeButId" type="number" value="0" required >
            <button type="submit" name="removeBut" class="remove-button">Slet bund</button>
        </div>
    </form>
        <!-- Hele table Buttoms slutter/-->
        <h3>Cupcake topping:</h3>
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
            <input name="topping" type="text" required value="Topping navn">
            <input name="toppingPris" type="number" required value="0">
            <button name="addtoppingbutton" type="submit" class="add-button">Tilføj topping</button>
        </div>
            </form>
    <form method="post">
        <div class="buttons-toppings">
            <label>ID: </label>
            <input name="removeToppingid" type="number" value="0"  required>
            <button  name="removetoppingidbutton"type="submit" class="remove-button">Slet topping</button>
        </div>
    </form>
        <h3>Kunder
        </h3>
    <table border="1">
        <thead>
        <tr>
            <th>id</th>
            <th>email</th>
            <th>rolle</th>
            <th>kredit</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>${user.role}</td>
                <td>${user.kredit} kr.</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form method="post">
        <div  class="kunder">
            <label>email:</label>
            <input name="kunderemail"value="email" type="email"required>
            <label>rolle:</label>
            <select name="kunderole" required>
                <option>customer</option>
                <option>admin</option>
            </select>
            <label>adgangskode:</label>
            <input name="kunderpassword" value="password" type="password"required>
            <label>kredit:</label>
            <input name="kunderkredt" type="number" value="0" required>
            <button name="createnewuser" type="submit" class="add-button">Tilføj ny bruger</button>
        </div>
    </form>
    <form method="post">
        <div  class="kunder">
            <label>KUNDE ID:</label>
            <input name="kunderID" type="number" value="0" required>
            <label>KREDIT:</label>
            <input name="KreditToAdd" type="number" value="0" required>
            <button name="addKredit" type="submit" class="remove-button">Tilføj kredit</button>

        </div>
    </form>
    <form method="post">
        <div  class="kunder">
            <input name="kunderIDToDelete" type="text" value="email" required>
            <button name="deleteUser" type="submit" class="remove-button">Slet bruger via email</button>
            <h3>Ordrer:</h3>
        </div>
    </form>
    <table border="1">
        <thead>
        <tr>
            <th>Ordrer Nr.</th>
            <th>Bruger id:</th>
            <th>Total pris:</th>
            <th>Dato:</th>
            <th>Detaljer</th>
      </tr>
        </thead>
        <tbody>
        <c:forEach items="${userOrders}" var="orders">
            <tr>
                <td>${orders.orderId}</td>
                <td>${orders.userId}</td>
                <td>${orders.orderPrice}</td>
                <td>${orders.orderDate}</td>
                <td align="center">
                    <form method="post">
                        <input type="hidden" name="idStuff" value="${orders.orderId}">
                        <input  type="submit" value="Detaljer" name="CheckDetails"/>
                        <input  type="submit" value="Slet ordrer og indhold" name="sletDetails"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

