package Controller.GestioneModeratore;

import Model.Community;
import Model.CommunityDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/EliminaCommunity")
public class EliminaCommunityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommunityDao cd=new CommunityDao();
        Community c=cd.doRetrieveById(Integer.parseInt(request.getParameter("id")));
        cd.doDelete(c);
        request.getRequestDispatcher("HomePage.jsp").forward(request,response);
    }
}
