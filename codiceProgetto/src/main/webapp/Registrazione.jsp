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

<c:if test="${not empty usernameError}">
    <script>
        alert("Username Non corretto o username già esistente");
    </script>
</c:if>

<c:if test="${not empty emailError}">
    <script>
        alert("Email Non corretta o email già esistente");
    </script>
</c:if>


<div class="text-center">
<img src="images/mini-logo.png" class="rounded mx-auto d-block" alt="...">
<h1 class="text-center">BookWorm</h1>
</div>

<form name="registrazioneForm" method="post" action="RegistrazioneServlet">
<div class="container">
    <div class="row">
        <div class="col">
            <div class="col">
                <h3 class="d-flex justify-content-center" style="font-family: 'Comic Sans MS'">Email</h3>
            </div>
            <div class="d-flex justify-content-center">
                <input type="email" name="email" id="email" placeholder="Email" required/>
            </div>
        </div>

        <div class="col">
            <div class="col">
                <h3 class="d-flex justify-content-center" style="font-family: 'Comic Sans MS'">Password</h3>
            </div>
            <div class="d-flex justify-content-center">
                <input type="password" name="password" id="password" oninput="validaPassword('registrazioneForm','registrami')" required />
            </div>
        </div>

    </div>


    <div class="row">
        <div class="col">
            <div class="col">
                <h3 class="d-flex justify-content-center" style="font-family: 'Comic Sans MS'">Username</h3>
            </div>
            <div class="d-flex justify-content-center">
                <input type="text" name="username" id="username" placeholder="Username" required>
            </div>
        </div>

        <div class="col">
            <div class="col">
                <h3 class="d-flex justify-content-center" style="font-family: 'Comic Sans MS'">Genere</h3>
            </div>
            <div class="d-flex justify-content-center">
                <div style="width:200px;">
                    <select name="sex" id="sex">
                        <option value="Uomo">Uomo</option>
                        <option value="Donna">Donna</option>
                        <option value="Altro">Altro</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="col">
            <div class="col">
                <h3 class="d-flex justify-content-center" style="font-family: 'Comic Sans MS'">Data di nascita</h3>
            </div>
            <div class="d-flex justify-content-center">
                <input type="date" name="date" id="date" min="1900-04-01" max="2019-04-20" value="2011-11-11" />
            </div>
        </div>
    </div>

</div>

<h1></h1>
<div class="row">
    <div class="col">
        <div class="d-flex justify-content-center">
            <a href="index.jsp" class="bottone2">ANNULLA</a>
        </div>
    </div>

    <div class="col">
        <div class="d-flex justify-content-center">
            <input type="submit" class="bottone2" id="registrami" value="Registra">
        </div>
    </div>

</div>
</form>


<script>
function validaPassword(nomeForm,nomeSubmit){
    var input=document.forms[nomeForm]['password'];
    if(input.value.length>=8 && input.value.toLowerCase()!=input.value && input.value.toUpperCase()!=input.value && /[0-9]/.test(input.value)){
            input.style.border="double green"
            password=true;
            cambiaStato(nomeSubmit);
    }else{
        input.style.border="double red";
        password=false;
        cambiaStato(nomeSubmit);
    }
}


    function cambiaStato(nomeSubmit){
        if(nomeSubmit=="registrami" && password) {
            document.getElementById(nomeSubmit).disabled = false;
        }
        else {
            document.getElementById(nomeSubmit).disabled = true;

        }
    }

</script>

</body>
</html>
