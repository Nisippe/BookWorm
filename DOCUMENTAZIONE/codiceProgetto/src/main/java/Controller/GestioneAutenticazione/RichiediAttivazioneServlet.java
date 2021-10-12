package Controller.GestioneAutenticazione;

import Model.Utente;
import Model.UtenteDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/RichiediAttivazione")
public class RichiediAttivazioneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("Email");
        UtenteDao ud=new UtenteDao();

        Utente u=ud.doRetrieveByEmail(email);
        if(u==null) {
            request.setAttribute("emailError", "email Non corretta o email non esistente");
            request.getRequestDispatcher("RichiediAttivazione.jsp").forward(request, response);
        }

        if(u.getAttivo()!=0){
            request.setAttribute("activeError", "Utente già attivo");
            request.getRequestDispatcher("RichiediAttivazione.jsp").forward(request, response);
        }
            try {
                ud.sendMail(email);
            } catch (Exception e) {
                e.printStackTrace();
            }


            request.getRequestDispatcher("Login.jsp").forward(request, response);

    }
}
