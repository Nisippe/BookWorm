<%@ page import="Model.Segnalazione" %>
<%@ page import="Model.SegnalazioneDao" %>
<%@ page import="Model.Community" %>
<%@ page import="Model.Post" %>
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


<%
    Segnalazione s= (Segnalazione) request.getAttribute("segnalazione");
    Community c= (Community) request.getAttribute("community");
    Post p= (Post) request.getAttribute("post");
%>

<jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="Contact"/>
</jsp:include>

<h1 class="text-center">SEGNALAZIONE</h1>
<div class="row">
    <div class="col">
        <h3 class="text-center">Genere</h3>
    </div>
    <div class="col">
        <h3 class="text-center">Nota</h3>
    </div>
</div>


<div class="row">
    <div class="col">
        <h3 class="text-center"><%=s.getGenereSegnalazione()%></h3>
    </div>
    <div class="col">
        <h3 class="text-center"><%=s.getDescrizioneSegnalazione()%></h3>
    </div>
</div>

<div class="row">
    <div class="col">
        <a href="Post.jsp?id=<%=p.getIdPost()%>&idc=<%=c.getIdCommunity()%>" class="bottone3">Link Post</a>
    </div>
    <div class="col">

    </div>
</div>

<div class="row">
    <div class="col">
        <a href="ListaSegnalazioni.jsp" class="bottone3">INDIETRO</a>
    </div>
    <div class="col">
        <a href="RifiutaSegnalazione?id=<%=s.getIdSegnalazione()%>" class="bottone3">Rifiuta Segnalazione</a>
    </div>

    <div class="col">
        <a href="AccettaSegnalazione?id=<%=s.getIdSegnalazione()%>" class="bottone3">Accetta Segnalazione</a>
    </div>
</div>


</body>
</html>
