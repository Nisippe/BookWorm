package Controller.GestioneModeratore;

import Model.Community;
import Model.CommunityDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ModificaCommunity")
public class ModificaCommunityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome=request.getParameter("nome");
        String descrizione=request.getParameter("descrizione");
        CommunityDao cd=new CommunityDao();
        Community c=cd.doRetrieveById(Integer.parseInt(request.getParameter("id")));
        c.setTitoloCommunity(nome);
        c.setDescrizioneCommunity(descrizione);
        cd.doUpdate(c);
        request.setAttribute("community",c);
        request.getRequestDispatcher("Community.jsp").forward(request,response);
    }
}
