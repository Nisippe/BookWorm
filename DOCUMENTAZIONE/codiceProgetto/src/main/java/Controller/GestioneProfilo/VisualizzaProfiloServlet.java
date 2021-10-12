package Controller.GestioneProfilo;

import Model.Utente;
import Model.UtenteDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/VisualizzaProfilo")
public class VisualizzaProfiloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtenteDao ud=new UtenteDao();
        Utente u=ud.doRetrieveByUsername((String) request.getParameter("name"));
        request.setAttribute("utente",u);
        request.getRequestDispatcher("ProfiloUtente.jsp").forward(request,response);
    }
}
