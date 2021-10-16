package Controller.GestioneAutenticazione;

import Model.Utente;
import Model.UtenteDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet( "/AttivazioneAccount")
public class AttivazioneAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("key1");
        UtenteDao ud=new UtenteDao();
        ud.doActive(email);

        response.sendRedirect("Login.jsp");
    }
}
