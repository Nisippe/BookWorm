<body>

<nav class="navbar navbar-expand-lg bg-primary navbar-dark" style="background-color: #e3f2fd;">
    <!-- Container wrapper -->
    <div class="container-fluid">
        <!-- Navbar brand -->
        <%
            if(session.getAttribute("username").equals("admin")){
        %>
        <a class="navbar-brand" style="width: 4%;" href="AdminPage.jsp"><img src="./images/homeicon.png" style="width: 100%;"></a>
        <%}else{%>
        <a class="navbar-brand" style="width: 4%;" href="HomePage.jsp"><img src="./images/homeicon.png" style="width: 100%;"></a>
        <%}%>


        <div class="col-md-9 col-md-push-1">
        <div class="container">
            <div class="row">
                <div class="col-xs-8 col-xs-offset-2">
                    <form action="Ricerca" method="post" id="searchForm" class="input-group">
                        <div class="input-group-btn search-panel">
                            <select name="param" id="param" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                <option value="username">Username</option>
                                <option value="community">Community</option>
                                <option value="libro">Libro</option>
                            </select>
                        </div>
                        <input type="text" class="form-control" name="text" placeholder="Cerca...">
                        <span class="input-group-btn">
                        <button class="btn btn-default" type="submit">
                           <span class="glyphicon glyphicon-search"></span>
                        </button>
                    </span>
                    </form><!-- end form -->
                </div><!-- end col-xs-8 -->
            </div><!-- end row -->
        </div><!-- end container -->
    </div><!-- end col-md-9 -->

</div>


    <a class="navbar-brand" style="width: 4%;" href="Profilo.jsp"><img src="./images/usericon.png" style="width: 100%; height: 99%;"/></a>
</nav>