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

<form name="bioForm" method="post" action="ModificaProfilo">
    <h1 class="text-center">Biografia</h1>
    <textarea style="width: 100%;" name="bio" id="bio" cols="50" rows="10"><%=session.getAttribute("bio")%></textarea>
    <div class="row">
        <div class="col">
            <input type="submit" class="justify-content-center bottone3" id="modifica" value="Conferma">
        </div>
        <div class="col">
            <a href="DeleteAccount?username=<%=session.getAttribute("username")%>" class="bottone3">ELIMINA ACCOUNT</a>
        </div>
    </div>


</form>

</body>
</html>
