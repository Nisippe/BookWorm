<%@ page import="Model.Libro" %>
<%@ page import="Model.LibroDao" %>
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
    LibroDao ld=new LibroDao();
    Libro l= ld.doRetrieveByISBN(Long.parseLong(request.getParameter("isbn")));
%>
<form action="ModificaLibro" method="post">
<div class="container">
    <div class="row">
        <div class="col">
            <div class="col">
                <div class="col">
                    <h1 style="font-family: 'Comic Sans MS'">TITOLO</h1>
                </div>
                <div class="col">
                    <input type="hidden" name="isbn" id="isbn" value="<%=l.getISBN()%>"/>
                    <input type="text" name="titolo" id="titolo" value="<%=l.getTitoloLibro()%>"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col">
            <div class="col">
                <div class="col">
                    <h1 style="font-family: 'Comic Sans MS'">AUTORE</h1>
                </div>
                <div class="col">
                    <input type="text" name="autore" id="autore" value="<%=l.getAutore()%>" />
                </div>
            </div>
        </div>
        <div class="col">
            <div class="col">
                <div class="col">
                    <h1 style="font-family: 'Comic Sans MS'">GENERE</h1>
                </div>
                <div class="col">
                    <input type="text" name="genere"  value="<%=l.getGenereLibro()%>"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col">
            <div class="col">
                <div class="col">
                    <h1 style="font-family: 'Comic Sans MS'">TRAMA</h1>
                </div>
                <div class="col">
                    <textarea name="trama" id="trama" cols="50" rows="10" ><%=l.getTrama()%></textarea>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="col">
                <div class="col">
                    <h1 style="font-family: 'Comic Sans MS'">COPERTINA</h1>
                </div>
                <div class="col">
                    <input type="file" id="immagine" name="immagine" accept="image/png, image/jpeg">
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <div class="col">
                <p></p>
            </div>
            <div class="col">
                <p></p>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <div class="col">
                <div class="col">
                    <a href="VisualizzaListaLibri" class="bottone3">ANNULLA</a>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="col">
                <div class="col">
                    <input type="submit" class="bottone3" value="MODIFICA LIBRO">
                </div>
            </div>
        </div>
        <div class="col">
            <div class="col">
                <div class="col">
                    <a href="RimuoviLibro?isbn=<%=l.getISBN()%>&" class="bottone3">ELIMINA LIBRO</a>
                </div>
            </div>
        </div>
    </div>

</div>
</form>
</body>
</html>
