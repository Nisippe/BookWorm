package Controller.GestioneAmministratore;



import Model.Utente;
import Model.UtenteDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/VisualizzaListaUtenti")
public class VisualizzaListaUtentiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtenteDao ud=new UtenteDao();
        ArrayList<Utente> list=ud.doRetrieveAll();
        request.setAttribute("ListaUtenti",list);
        request.getRequestDispatcher("ListaUtenti.jsp").forward(request,response);
    }
}
