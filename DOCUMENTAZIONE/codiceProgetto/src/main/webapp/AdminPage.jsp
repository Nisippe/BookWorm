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

    <style>
        .center {
            margin: auto;
            width: 60%;
            padding: 70px 0;
            border: 3px solid green;
            text-align: center;
        }
    </style>
</head>
<body>

<c:if test="${not empty libromod}">
    <script>
        alert("Libro modificato");
    </script>
</c:if>

<c:if test="${not empty librodel}">
    <script>
        alert("Libro eliminato");
    </script>
</c:if>

<div class="center">
        <a href="ListaSegnalazioni.jsp" class="bottone1">LISTA SEGNALAZIONI</a>

        <a href="VisualizzaListaLibri" class="bottone1">LISTA LIBRI</a>

        <a href="VisualizzaListaUtenti" class="bottone1">LISTA UTENTI</a>
</div>

</body>
</html>
