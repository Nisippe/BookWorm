<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Libro" %>
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

<c:if test="${not empty NewCom}">
    <script>
        alert("Nuova Community Creata!");
    </script>
</c:if>


<%
    Libro l= (Libro) request.getAttribute("libro");
%>
<div class="text-center">
    <img style="max-height: 500px; max-width: 300px;" src="<%=l.getCopertina()%>" />
    <h1 style="font-family: 'Comic Sans MS'"><%=l.getTitoloLibro()%></h1>
    <h2 style="font-family: 'Comic Sans MS'"><%=l.getAutore()%></h2>
    <h4 style="font-family: 'Comic Sans MS'"><%=l.getTrama()%></h4>
    <a href="VisualizzaListaLibri" class="bottone3">INDIETRO</a>
    <a href="CreaCommunity.jsp?isbn=<%=l.getISBN()%>" class="bottone3">CREA COMMUNITY</a>
    <a href="AllCommunityByLibro?isbn=<%=l.getISBN()%>" class="bottone3">VISUALIZZA COMMUNITY</a>
    <%
        if(session.getAttribute("username").equals("admin")){
    %>
    <a href="ModificaLibro.jsp?isbn=<%=l.getISBN()%>" class="bottone3">MODIFICA LIBRO</a>
    <%}%>
</div>





</body>
</html>
