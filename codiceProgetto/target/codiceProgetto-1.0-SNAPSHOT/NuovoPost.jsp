<%@ page import="Model.Community" %>
<%@ page import="Model.CommunityDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<%
    CommunityDao cd=new CommunityDao();
    Community c= cd.doRetrieveById(Integer.parseInt(request.getParameter("id")));
%>
<form method="post" action="CaricaPost?c=<%=c.getIdCommunity()%>">
<div class="container background">
    <div class="row">
        <div class="col">
        </div>
        <div class="col">
            <a href="Community.jsp"><h4><%=c.getTitoloCommunity()%></h4></a>
        </div>
        <div class="col">
        </div>
    </div>
    <div class="row">
        <div class="col"></div>
        <div class="col"><textarea id="descrizione" name="descrizione" placeholder="Descrizione"></textarea></div>
        <div class="col"></div>
    </div>
    <div class="row">
        <div class="col"><input type="image" id="immagine" name="immagine" value="Aggiungi immagine"></div>
        <div class="col">
            <div style="width:200px;">
            <select name="generepost" id="generepost">
                <option value="generale">generale</option>
                <option value="Spoiler">Spoiler</option>
                <option value="fanart">fanart</option>
                <option value="18+">18+</option>
            </select>
        </div>
        </div>
    </div>

    <input type="submit" value="Aggiungi Post" />
</div>
</form>



</body>
</html>
