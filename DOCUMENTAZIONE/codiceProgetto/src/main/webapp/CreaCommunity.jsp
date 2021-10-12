<%@ page import="Model.Libro" %>
<%@ page import="Model.LibroDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="./CSS/inputs.css">
    <link rel="stylesheet" type="text/css" href="./CSS/buttons.css">
    <link rel="stylesheet" type="text/css" href="./CSS/body.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" rel="stylesheet"/>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" rel="stylesheet"/>
    <link rel="stylesheet" href="/path/to/flickity.css" media="screen">
    <title>Welcome To BookWorm</title>
</head>


<jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="Contact"/>
</jsp:include>


<c:if test="${not empty errorCom}">
    <script>
        alert("Esiste già una community con questo nome!");
    </script>
</c:if>

    <!--<img src="./images/mini-logo.png" class="rounded mx-auto d-block" alt="...">-->
<%
    LibroDao ld=new LibroDao();
    Libro l= ld.doRetrieveByISBN(Long.parseLong(request.getParameter("isbn")));
%>


    <form action="CreaCommunityByBook" method="post">
        <input type="hidden" id="ISBN" name="ISBN" value="<%=l.getISBN()%>" />
        <div class="container">
            <div class="row">
                <div class="col"></div>
                <div class="col"><img style="max-height: 500px; max-width: 300px;" src="<%=l.getCopertina()%>" /></div>
                <div class="col"></div>
            </div>
            <div class="row">
                <div class="col"></div>
                <div class="col"><h1 style="font-family: 'Comic Sans MS'"><%=l.getTitoloLibro()%></h1></div>
                <div class="col"></div>
                </div>
            <div class="row">
                <div class="col"></div>
                <div class="col"><h3 style="font-family: 'Comic Sans MS'">Nome Community</h3></div>
                <div class="col"></div>
            </div>
            <div class="row">
                <div class="col"></div>
                <div class="col"><input class="text-center" type="text" id="nome" name="nome" style="width: 100%"/></div>
                <div class="col"></div>
            </div>
            <div class="row">
                <div class="col"></div>
                <div class="col"><h3 style="font-family: 'Comic Sans MS'">Descrizione</h3></div>
                <div class="col"></div>
            </div>
            <div class="row">
                <div class="col"></div>
                <div class="col"><textarea class="text-center" name="descrizione" id="descrizione" cols="50" rows="10" style="width: 100%"></textarea></div>
                <div class="col"></div>
            </div>
            <div class="row">
                <div class="col"><a href="VisualizzaListaLibri" class="bottone3">ANNULLA</a></div>
                <div class="col"></div>
                <div class="col"><input type="submit" value="Crea Nuova Community" class="bottone3" /></div>
            </div>
        </div>
    </form>


</body>
</html>
