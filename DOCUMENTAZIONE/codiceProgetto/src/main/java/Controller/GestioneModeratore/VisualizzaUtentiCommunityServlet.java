package Controller.GestioneModeratore;

import Model.CommunityDao;
import Model.Utente;
import Model.UtenteDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/VisualizzaUtentiCommunity")
public class VisualizzaUtentiCommunityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtenteDao ud=new UtenteDao();
        CommunityDao cd=new CommunityDao();
        ArrayList<Utente> list=ud.doRetrieveByCommunity(cd.doRetrieveById(Integer.parseInt(request.getParameter("id"))));
        request.setAttribute("ListaUtenti",list);
        request.getRequestDispatcher("ListaUtenti.jsp").forward(request,response);
    }
}
