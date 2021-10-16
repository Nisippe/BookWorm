package Controller.GestioneAmministratore;

import Model.CommunityDao;
import Model.PostDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/VisualizzaSegnalazione")
public class VisualizzaSegnalazioneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommunityDao cd=new CommunityDao();
        PostDao pd=new PostDao();
        request.setAttribute("community",cd.doRetrieveById(Integer.parseInt(request.getParameter("idc"))));
        request.setAttribute("post",pd.doRetrieveById(Integer.parseInt(request.getParameter("id"))));
        request.getRequestDispatcher("Segnalazione.jsp").forward(request,response);
    }
}
