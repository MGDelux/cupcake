<%@ page import="java.util.List" %>
<%@ page import="domain.Toppings.Toppings" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <a href="#${pageContext.request.contextPath}/">Hjem</a>
        <a><c:if test="${sessionScope.user.email !=null}">
            ${sessionScope.user.email} - ${sessionScope.user.role}
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
            <input name="buttomName" type="text" value="Buttom navn" required>
            <input name="buttomPris" type="number" value="0" required>
            <button type="submit" name="add-button" class="add-button">Add buttom</button>
        </div>
        </form>
    <form method="post">
        <div class="buttons-buttom" align="center">
            <label>ID: </label>
            <input name="removeButId" type="number" value="0" required >
            <button type="submit" name="removeBut" class="remove-button">Remove buttom</button>
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
            <input name="topping" type="text" required value="Topping navn">
            <input name="toppingPris" type="number" required value="0">
            <button name="addtoppingbutton" type="submit" class="add-button">Add topping</button>
        </div>
            </form>
    <form method="post">
        <div class="buttons-toppings">
            <label>ID: </label>
            <input name="removeToppingid" type="number" value="0"  required>
            <button  name="removetoppingidbutton"type="submit" class="remove-button">Remove topping</button>
        </div>
    </form>
        <h3>Kunder
        </h3>
    <table border="1">
        <thead>
        <tr>
            <th>id</th>
            <th>email</th>
            <th>role</th>
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
            <input name="kunderEmail"value="email" type="email"required>
            <label>role:</label>
            <select name="kundeRole" required>
                <option>customer</option>
                <option>admin</option>
            </select>
            <label>password:</label>
            <input name="kunderPassword" value="password" type="password"required>
            <label>kredit:</label>
            <input name="kunderKredt" type="number" value="0" required>
            <button name="createNewUser" type="submit" class="add-button">Add new user</button>
        </div>
    </form>
    <form method="post">
        <div  class="kunder">
            <label>KUNDE ID:</label>
            <input name="kunderID" type="number" value="0" required>
            <label>KREDIT:</label>
            <input name="KreditToAdd" type="number" value="0" required>
            <button name="addKredit" type="submit" class="remove-button">Set kredit</button>

        </div>
    </form>
    <form method="post">
        <div  class="kunder">
            <input name="kunderIDToDelete" type="text" value="email" required>
            <button name="deleteUser" type="submit" class="remove-button">Remove User by Email</button>

        </div>
    </form>
    <table border="1">
        <thead>
        <tr>
            <th>Order Nr.</th>
            <th>Bruger id:</th>
            <th>Total pris:</th>
            <th>Dato:</th>
            <th>Details</th>
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
                        <input  type="submit" value="Detailer" name="CheckDetails"/>
                        <input  type="submit" value="Slet order and content" name="sletDetails"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

