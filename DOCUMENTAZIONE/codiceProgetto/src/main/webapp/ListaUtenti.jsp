<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Utente" %>
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
    ArrayList<Utente> list= (ArrayList<Utente>) request.getAttribute("ListaUtenti");
    if(list==null){
%>
<div>
<h1 class="text-center">Nessun Risultato</h1>
</div>
<%}else{%>
<table class="blueTable">
    <tr>
        <th>Numero</th>
        <th>Username</th>
        <th>Genere</th>
    </tr>


    <%
        for(int i=0;i<list.size();i++){%>
    <tr>
        <th><a href="VisualizzaProfilo?name=<%=list.get(i).getUsername()%>"><%=i%></a></th>
        <th><a href="VisualizzaProfilo?name=<%=list.get(i).getUsername()%>"><%=list.get(i).getUsername()%></a></th>
        <th><a href="VisualizzaProfilo?name=<%=list.get(i).getUsername()%>"><%=list.get(i).getGenere()%></a></th>
    </tr>
<%}%>
</table>
<%}%>
</body>
</html>
