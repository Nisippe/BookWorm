<%@ page import="Model.CommunityDao" %>
<%@ page import="Model.Community" %>
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
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/path/to/flickity.css" media="screen">
    <title>Welcome To BookWorm</title>
</head>

<jsp:include page="header.jsp">
    <jsp:param name="pageTitle" value="Contact"/>
</jsp:include>

<%
    CommunityDao cd=new CommunityDao();
    Community c=cd.doRetrieveById(Integer.parseInt(request.getParameter("id")));
%>

<form name="modCom" method="post" action="ModificaCommunity">
    <h1 class="text-center">Nome Community</h1>
    <input type="text" style="width: 100%;" name="nome" id="nome" value="<%=c.getTitoloCommunity()%>">
    <input type="hidden" name="id" id="id" value="<%=c.getIdCommunity()%>">
    <h1 class="text-center">Descrizione Community</h1>
    <textarea type="text" style="width: 100%;" name="descrizione" id="descrizione" ><%=c.getDescrizioneCommunity()%></textarea>

    <input type="submit" class="bottone3" value="modifica" />
    <a href="EliminaCommunity" class="bottone3">ELIMINA COMMUNITY</a>
</form>

</body>
</html>
