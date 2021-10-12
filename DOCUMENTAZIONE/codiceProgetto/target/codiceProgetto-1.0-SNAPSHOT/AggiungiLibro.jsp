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
<form action="AggiungiLibro" method="post">
<div class="container">
    <div class="row">
        <div class="col">
            <div class="col">
                <div class="col">
                <h1 style="font-family: 'Comic Sans MS'">ISBN</h1>
                </div>
                <div class="col">
                    <input type="text" name="isbn" id="isbn" />
                </div>
            </div>
        </div>
        <div class="col">
            <div class="col">
                <div class="col">
                    <h1 style="font-family: 'Comic Sans MS'">TITOLO</h1>
                </div>
                <div class="col">
                    <input type="text" name="titolo" id="titolo" />
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
                    <input type="text" name="autore" id="autore" />
                </div>
            </div>
        </div>
        <div class="col">
            <div class="col">
                <div class="col">
                    <h1 style="font-family: 'Comic Sans MS'">GENERE</h1>
                </div>
                <div class="col">
                    <input type="text" name="genere" id="genere" />
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
                    <textarea name="trama" id="trama" cols="50" rows="10"></textarea>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="col">
                <div class="col">
                    <h1 style="font-family: 'Comic Sans MS'">COPERTINA</h1>
                </div>
                <div class="col">
                    <a href=""><img src="../images/imageicon.png" width="10%"/></a>
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
                    <a href="VisualizzaListaLibri" class="bottone1">ANNULLA</a>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="col">
                <div class="col">
                    <input type="submit" value="Aggiungi Libro">
                </div>

            </div>
        </div>
    </div>

</div>
</form>
</body>
</html>
