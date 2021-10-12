package Controller.GestioneAutenticazione;

import Model.CommunityDao;
import Model.LibroDao;
import Model.Utente;
import Model.UtenteDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
        }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtenteDao ud=new UtenteDao();
        CommunityDao cd=new CommunityDao();
        LibroDao ld=new LibroDao();
        Utente u=null;
        HttpSession session=request.getSession();
        response.setContentType("text/html");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        u=ud.doRetrieveByUsername(username);
        if(u.getRuolo().equals("Admin") && password.equals(u.getPassword())) {
            session.setAttribute("bio",u.getBio());
            session.setAttribute("username",u.getUsername());
            request.getRequestDispatcher("AdminPage.jsp").forward(request, response);
        }

        if(u==null || !(u.getPassword().equals(password))){
            request.setAttribute("loginError","password Non corretta o utente errato");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
        if(u.getRuolo().equals("BAN")){
            request.setAttribute("banError","bannato");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
        if(u.getAttivo()==0){
            request.setAttribute("activeError","Il tuo account non è attivo, conferma la mail o richiedi un'altra mail");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }else if(password.equals(u.getPassword())){
                session.setAttribute("utente",u);
                session.setAttribute("username",u.getUsername());
                request.setAttribute("usernamer",u.getUsername());
                request.getRequestDispatcher("HomePage.jsp").forward(request,response);
            }
        }
}
