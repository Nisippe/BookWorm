<%@ page import="Model.UtenteDao" %>
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
    if(request.getAttribute("passwordError")!=null){%>
<script>
    alert("Hai inserito la stessa password!");
</script>
<%}%>

<%
    if(request.getAttribute("passwordAttError")!=null){%>
<script>
    alert("Hai inserito una password sbagliata!");
</script>
<%}%>
<%
    UtenteDao ud=new UtenteDao();
    String passwordatt=ud.doRetrieveByUsername((String) session.getAttribute("username")).getPassword();
%>
<input type="hidden" id="role" value="<%=passwordatt%>"/>
<form name="modificapass" method="post" action="ModificaPassword">
    <div class="row">
        <div class="col">
            <h1 class="d-flex justify-content-center">Password Attuale</h1>
        </div>
        <div class="col">
            <h1 class="d-flex justify-content-center">Nuova Password</h1>
        </div>
    </div>

    <div class="row">
        <div class="col">
            <div class="d-flex justify-content-center">
            <input type="password" name="passwordatt" id="passwordatt" />
            </div>
        </div>
        <div class="col">
            <div class="d-flex justify-content-center">
            <input type="password"  oninput="validaPassword('modificapass','modifica')" name="password" id="password" />
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col">
            <a href="Profilo.jsp" class="bottone3">Indietro</a>
        </div>
        <div class="col">
            <input type="submit" class="bottone3" id="modifica" value="Conferma">
        </div>
    </div>



</form>

<script>


function validaPassword(nomeForm,nomeSubmit){
var input=document.forms[nomeForm]['password'];
if(input.value.length>=8 && input.value.toLowerCase()!=input.value && input.value.toUpperCase()!=input.value && /[0-9]/.test(input.value)){
input.style.border="double green"
password=true;
cambiaStato(nomeSubmit);
}else{
input.style.border="double red";
password=false;
cambiaStato(nomeSubmit);
}
}


function cambiaStato(nomeSubmit){
if(nomeSubmit=="modifica" && password) {
document.getElementById(nomeSubmit).disabled = false;
}
else {
document.getElementById(nomeSubmit).disabled = true;
}
}
</script>


</body>
</html>
