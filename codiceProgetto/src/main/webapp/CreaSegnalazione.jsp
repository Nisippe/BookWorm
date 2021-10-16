<%@ page import="Model.PostDao" %>
<%@ page import="Model.Post" %>
<%@ page import="Model.Community" %>
<%@ page import="Model.CommunityDao" %>
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
    PostDao pd=new PostDao();
    Post p=pd.doRetrieveById(Integer.parseInt(request.getParameter("id")));
    CommunityDao cd=new CommunityDao();
    Community c=cd.doRetrieveById(Integer.parseInt(request.getParameter("idc")));
%>

<form action="NuovaSegnalazionePost" method="post">
    <input type="hidden" id="id" name="id" value="<%=p.getIdPost()%>" />
    <input type="hidden" id="idc" name="idc" value="<%=c.getIdCommunity()%>" />
    <div class="container">
        <div class="row">
            <div class="col">Genere</div>
            <div class="col">Nota</div>
        </div>

        <div class="row">
            <div class="col">
                <div style="width:200px;">
                    <select name="genere" id="genere">
                        <option value="molestie">Molestie</option>
                        <option value="violenza">Violenza</option>
                        <option value="odio">Contenuti che ispirano all'odio</option>
                        <option value="inappropriato">Contenuto inappropriato</option>
                        <option value="spoiler">Spoiler non segnalato</option>
                        <option value="spam">spam</option>
                        <option value="copyright">Violazione del copyright</option>
                    </select>
                </div>
            </div>
            <div class="col"><textarea class="text-center" name="nota" id="nota" cols="50" rows="10" style="width: 100%"></textarea></div>
        </div>
    </div>
</form>


</body>
</html>
