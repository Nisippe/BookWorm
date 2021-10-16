<%@ page import="Model.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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

<c:if test="${not empty postsegnalato}">
    <script>
        alert("Post Segnalato con successo");
    </script>
</c:if>

<%
    Community c= (Community) request.getAttribute("community");
    UtenteDao ud=new UtenteDao();
    Utente u= (Utente) session.getAttribute("utente");
%>

<div class="text-center">
    <%if(c.getImmagineCommunity().equals("")){%>
    <img class="text-center" src="./images/emptyicon.png" class="rounded mx-auto d-block" alt="...">
    <%}else{%>
    <img class="text-center" src="<%=c.getImmagineCommunity()%>" class="rounded mx-auto d-block" alt="...">
    <%}%>
    <h1 class="text-center"><%=c.getTitoloCommunity()%></h1>
    <h3 class="text-center"><%=c.getDescrizioneCommunity()%></h3>
    <%
        if(!(u.follow(c))){
    %>
    <div class="text-center">
        <a href="FollowCommunity?idc=<%=c.getIdCommunity()%>" class="bottone2">SEGUI</a>
    </div>
    <%}else if(u.isMod(c)){%>
    <%}else{%>
    <div class="text-center">
        <a href="UnfollowCommunity?idc=<%=c.getIdCommunity()%>" class="bottone2">Smetti di seguire</a>
    </div>
    <%}%>

    <div class="row">

        <%
            if (u.isMod(c)){
        %>
        <div class="col">
        <div class="text-center"><a href="ModificaCommunity.jsp?id=<%=c.getIdCommunity()%>" class="bottone2">MODIFICA</a></div>
        </div>
        <%
            }
        %>
        <div class="col">

        </div>

        <div class="col">
            <div class="text-center"><a href="VisualizzaUtentiCommunity?id=<%=c.getIdCommunity()%>" class="bottone2">Visualizza Utenti</a></div>
        </div>
    </div>

    <div class="row">


        <div class="col">

        </div>

        <div class="col">
            <div class="text-center"><a href="NuovoPost.jsp?id=<%=c.getIdCommunity()%>" class="bottone2">Crea Post</a></div>
        </div>

        <div class="col">

        </div>
    </div>



</div>

<%
    PostDao pd=new PostDao();
    ArrayList<Post> lista=pd.doRetrieveByCommunity(c);
    lista=pd.sortByDate(lista);
    for(Post p: lista){
%>

        <div style="margin-top:70px" class="container background">
        <div class="row">
            <div class="col">
                <a href="VisualizzaCommunity?id=<%=c.getIdCommunity()%>"><img src="<%=c.getImmagineCommunity()%>" /></a>
            </div>
            <div class="col">
                <h4><a href="VisualizzaCommunity?id=<%=c.getIdCommunity()%>"><%=c.getTitoloCommunity()%></a>/<a href="VisualizzaProfilo?name=<%=ud.doRetrieveByIdPost(p).getUsername()%>"><%=ud.doRetrieveByIdPost(p).getUsername()%></a></h4>
            </div>
            <div class="col">
                <h4><%=p.getGenerePost()%></h4>
            </div>
        </div>

        <div>
            <h4><%=p.getDescrizionePost()%></h4>
        </div>
        <%
            if(!(p.getImmagine()==null)){
        %>
        <div>
            <img src="<%=p.getImmagine()%>"/>
        </div>
        <%}%>
        <div class="row">
            <%
                if(ud.doRetrieveByUsername((String) session.getAttribute("username")).dolike(p)==0){
            %>
            <div class="col"><a href="Like?id=<%=p.getIdPost()%>&idc=<%=c.getIdCommunity()%>">MI PIACE</a></div>
            <%
            }else{
            %>
            <div class="col"><a href="RemoveLike?id=<%=p.getIdPost()%>&idc=<%=c.getIdCommunity()%>">NON MI PIACE</a></div>
            <%
                }
            %>
            <div class="col"><a href="Post.jsp?id=<%=p.getIdPost()%>&idc=<%=c.getIdCommunity()%>"><i class="fa fa-comment" aria-hidden="true"></i></a></div>
            <div class="col"><%if( u.isMod(c) || p.isProp().equals(session.getAttribute("username"))){%>
                <a href="ModificaPost.jsp?idc=<%=c.getIdCommunity()%>&id=<%=p.getIdPost()%>" class="bottone3">Modifica</a><%}%>
            </div>
        </div>
    </div>
<%}%>


</body>
</html>
