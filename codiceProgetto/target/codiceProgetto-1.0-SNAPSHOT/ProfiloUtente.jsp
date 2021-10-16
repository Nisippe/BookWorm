<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.*" %>
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

<div class="text-center">
    <%
        Utente u= (Utente) request.getAttribute("utente");
        LibroDao ld=new LibroDao();
        CommunityDao cd=new CommunityDao();
        if(u.getImmagine()==null || u.getImmagine().equals("")){%>
    <img src="./images/usericon.png" class="rounded mx-auto d-block" alt="...">
    <%}else{%>
    <img src="<%=u.getImmagine()%>" class="rounded mx-auto d-block" alt="...">
    <%}%>
    <h1 class="text-center"><%=u.getUsername()%></h1>
    <h3 class="text-center"><%=u.getBio()%></h3>
    <h3 class="text-center"><%=u.getGenere()%></h3>
</div>
<script src="/path/to/flickity.pkgd.min.js"></script>

<%
    if(session.getAttribute("username").equals("admin") && (!(u.getRuolo().equals("BAN")))){
%>
<div class="text-center">
    <a href="BanUser" class="bottone3">BAN</a>
</div>
<%
    }else if(u.getRuolo().equals("BAN")){
%>
    <div class="text-center">
        <h2>BANNATO</h2>
    </div>
<%
    }
%>



<div class="slideshow-container">
    <%
        ArrayList<Libro> listal=ld.doRetrieveByUtente(u);
        if(listal==null){ }else{%>
    <%
        for(Libro l: listal){
    %>
    <div class="mySlides1 text-center">
        <a href="#"><img src="<%=l.getCopertina()%>"></a>
    </div>
    <%}}%>

    <a class="prev" onclick="plusSlides(-1, 0)">&#10094;</a>
    <a class="next" onclick="plusSlides(1, 0)">&#10095;</a>
</div>




<script>
    var slideIndex = [1,1];
    var slideId = ["mySlides1", "mySlides2"]
    showSlides(1, 0);
    showSlides(1, 1);

    function plusSlides(n, no) {
        showSlides(slideIndex[no] += n, no);
    }

    function showSlides(n, no) {
        var i;
        var x = document.getElementsByClassName(slideId[no]);
        if (n > x.length) {slideIndex[no] = 1}
        if (n < 1) {slideIndex[no] = x.length}
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        x[slideIndex[no]-1].style.display = "block";
    }
</script>

</body>
</html>
