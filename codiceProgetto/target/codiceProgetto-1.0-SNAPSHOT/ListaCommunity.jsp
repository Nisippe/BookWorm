<%@ page import="Model.Community" %>
<%@ page import="java.util.ArrayList" %>
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
    ArrayList<Community> lista= (ArrayList<Community>) request.getAttribute("lista");
    if(lista==null){
%>
<div>
    <h1 class="text-center">Nessun Risultato</h1>
</div>
<%}else{%>
<%
    for(Community l: lista){
%>

<div style="margin-top:50px;" class="row">
    <div class="col">
        <%if(l.getImmagineCommunity().equals("")){%>
        <div class="text-center">
            <a href="VisualizzaCommunity?id=<%=l.getIdCommunity()%>"><img src="./images/emptyicon.png" /></a>
        </div>
        <%}else{%>
        <div class="text-center">
            <a href="VisualizzaCommunity?id=<%=l.getIdCommunity()%>"><img style="max-height: 1000px; max-width: 600px;" src="<%=l.getImmagineCommunity()%>" /></a>
        </div>
        <%}%>

            <a href="VisualizzaCommunity?id=<%=l.getIdCommunity()%>"><h2 class="text-center"><%=l.getTitoloCommunity()%></h2></a>
    </div>

</div>
<%}}%>



</body>
</html>