package Controller.GestioneLibro;

import Model.Community;
import Model.CommunityDao;
import Model.Utente;
import Model.UtenteDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/UnfollowCommunity")
public class UnfollowCommunityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtenteDao ud=new UtenteDao();
        CommunityDao cd=new CommunityDao();
        HttpSession session=request.getSession();
        Community c=cd.doRetrieveById(Integer.parseInt(request.getParameter("idc")));
        Utente u=ud.doRetrieveByUsername((String) session.getAttribute("username"));
        u.doNotFollow(c);
        request.setAttribute("community",c);
        request.getRequestDispatcher("Community.jsp").forward(request,response);
    }
}
