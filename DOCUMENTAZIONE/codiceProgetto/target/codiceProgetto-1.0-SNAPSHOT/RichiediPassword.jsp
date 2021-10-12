
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



<c:if test="${not empty emailError}">
    <script>
        alert("Email non esistente");
    </script>
</c:if>



<div class="text-center">
    <img src="images/mini-logo.png" class="rounded mx-auto d-block" alt="...">
    <h1 class="text-center">BookWorm</h1>
</div>


<form name="recPassForm" method="post" action="RecuperaPassword">
    <div class="container">
        <div class="row">
            <div class="col">
                <div class="col">
                    <h3 class="d-flex justify-content-center" style="font-family: 'Comic Sans MS'">Email</h3>
                </div>
                <div class="d-flex justify-content-center">
                    <input type="text" name="Email" id="Email" placeholder="Email" required/>
                </div>
                <div class="col">
                    <div class="d-flex justify-content-center">
                        <a href="Login.jsp" class="justify-content-center bottone3">ANNULLA</a>
                    </div>
                    <p></p>
                    <div class="d-flex justify-content-center">
                    <input type="submit" class="justify-content-center bottone3"  value="RICHIEDI PASSWORD">
                    </div>
                </div>
            </div>
        </div>
    </div>


</form>
</body>
</html>
