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
    PostDao pd=new PostDao();
    Post p = (Post) pd.doRetrieveById(Integer.parseInt(request.getParameter("id")));
    UtenteDao ud=new UtenteDao();
    CommunityDao comd=new CommunityDao();
    Community c= (Community)comd.doRetrieveById(Integer.parseInt(request.getParameter("idc")));
    Utente u=ud.doRetrieveByUsername((String) session.getAttribute("username"));
%>

<div style="margin-top:70px" class="container background">
    <div class="row">
        <div class="col">
            <a href="Community.jsp" ><img src="<%=c.getImmagineCommunity()%>" /></a>
        </div>
        <div class="col">
            <h4><a href="VisualizzaCommunity?id=<%=c.getIdCommunity()%>"><%=c.getTitoloCommunity()%></a>/<a href="VisualizzaProfilo?name=<%=ud.doRetrieveByIdPost(p).getUsername()%>"><%=ud.doRetrieveByIdPost(p).getUsername()%></a></h4>
        </div>
        <div class="col">
            <h4><%=p.getGenerePost()%></h4>
        </div>
        <div class="col">
            <a href="CreaSegnalazione.jsp?id=<%=p.getIdPost()%>&idc=<%=c.getIdCommunity()%>"><i class="fa-solid fa-flag"></i></a>
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
        <div class="col"><a href="VisualizzaLike?id=<%=p.getIdPost()%>">Likes</a></div>
        <div class="col"><a href="Post.jsp?id=<%=p.getIdPost()%>&idc=<%=c.getIdCommunity()%>"><i class="fas fa-comment"></i></a></div>
        <div class="col"><%if( u.isMod(c) || p.isProp().equals(session.getAttribute("username"))){%>
            <a href="ModificaPost.jsp?idc=<%=c.getIdCommunity()%>&id=<%=p.getIdPost()%>" class="bottone3">Modifica</a><%}%>
        </div>
    </div>
</div>
<div class="container">
<form action="InserisciCommento" method="post">
    <input type="hidden" id="idc" name="idc" value="<%=c.getIdCommunity()%>" />
    <input type="hidden" id="id" name="id" value="<%=p.getIdPost()%>" />
<div class="text-center">
    <textarea placeholder="Inserisci nuovo commento" id="commento" name="commento"></textarea>
</div>
<div class="text-center">
    <input type="submit" id="comment" name="comment" class="bottone3" value="Aggiungi commento">
</div>
</form>
</div>

</body>
</html>
