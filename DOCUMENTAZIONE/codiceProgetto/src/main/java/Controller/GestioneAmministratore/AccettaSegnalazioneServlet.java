package Controller.GestioneAmministratore;

import Model.PostDao;
import Model.Segnalazione;
import Model.SegnalazioneDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/AccettaSegnalazione")
public class AccettaSegnalazioneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SegnalazioneDao sd=new SegnalazioneDao();
        PostDao pd=new PostDao();
        Segnalazione s=sd.doRetrieveById(Integer.parseInt(request.getParameter("id")));
        sd.doDelete(s);
        pd.doDelete(pd.doRetrieveBySegnalazione(s));
        request.getRequestDispatcher("ListaSegnalazioni.jsp").forward(request,response);
    }
}
