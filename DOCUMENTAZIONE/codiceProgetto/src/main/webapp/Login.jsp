<%--
  Created by IntelliJ IDEA.
  User: gnisi
  Date: 29/09/2021
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="CSS/body.css">
    <link rel="stylesheet" href="CSS/buttons.css">
    <title>Welcome To BookWorm</title>
</head>
<body>


<c:if test="${not empty loginError}">
    <script>
        alert("Username e/o Password Errata/i");
    </script>
</c:if>

<c:if test="${not empty banError}">
    <script>
        alert("SEI STATO BANNATO!");
    </script>
</c:if>


<c:if test="${not empty activeError}">
    <script>
        alert("Il tuo account non è attivo, conferma la mail o richiedi un'altra mail");
    </script>
</c:if>

<c:if test="${not empty activeAccount}">
    <script>
        alert("Ti è appena arrivata una MAIL per confermare il tuo account! Vai ad ATTIVARLO");
    </script>
</c:if>

<div class="text-center">
    <img src="images/mini-logo.png" class="rounded mx-auto d-block" alt="...">
    <h1 class="text-center">BookWorm</h1>
</div>


<form name="loginForm" method="post" action="Login">
<div class="container">
    <div class="row">
        <div class="col">
            <div class="col">
                <h3 class="d-flex justify-content-center" style="font-family: 'Comic Sans MS'">Username</h3>
            </div>
            <div class="d-flex justify-content-center">
                <input type="text" name="username" id="username" placeholder="username" required/>
            </div>
        </div>

        <div class="col">
            <div class="col">
                <h3 class="d-flex justify-content-center" style="font-family: 'Comic Sans MS'">Password</h3>
            </div>
            <div class="d-flex justify-content-center">
                <input type="password" name="password" id="password" required />
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col">
            <a href="index.jsp" class="bottone3">ANNULLA</a>
        </div>

            <a href="RichiediAttivazione.jsp" class="bottone3">RICHIEDI ATTIVAZIONE</a>

    </div>

    <div class="row">
        <div class="col">
            <a href="RichiediPassword.jsp" class="bottone3">RECUPERO PASSWORD</a>
        </div>
            <input type="submit" class="justify-content-center bottone3" id="log" value="Login">

    </div>
</div>
</form>


</body>
</html>
