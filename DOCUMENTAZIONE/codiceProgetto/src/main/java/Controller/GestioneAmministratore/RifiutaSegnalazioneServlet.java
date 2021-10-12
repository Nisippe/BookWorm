package Controller.GestioneAmministratore;

import Model.Segnalazione;
import Model.SegnalazioneDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/RifiutaSegnalazione")
public class RifiutaSegnalazioneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SegnalazioneDao sd=new SegnalazioneDao();
        Segnalazione s=sd.doRetrieveById(Integer.parseInt(request.getParameter("id")));
        sd.doDelete(s);
        request.getRequestDispatcher("ListaSegnalazioni.jsp").forward(request,response);
    }
}
