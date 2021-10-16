package Controller.GestioneAmministratore;

import Model.Segnalazione;
import Model.SegnalazioneDao;
import Model.Utente;
import Model.UtenteDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/VisualizzaListaSegnalazioni")
public class VisualizzaListaSegnalazioniServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SegnalazioneDao sd=new SegnalazioneDao();
        ArrayList<Segnalazione> list=sd.doRetrieveAll();
        request.setAttribute("Lista",list);
        request.getRequestDispatcher("ListaSegnalazioni.jsp").forward(request,response);
    }
}
