package Controller.GestioneLibro;

import Model.Community;
import Model.CommunityDao;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/VisualizzaCommunity")
public class VisualizzaCommunityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommunityDao ld=new CommunityDao();
        String id=request.getParameter("id");
        Community l=ld.doRetrieveById(Integer.parseInt(id));
        HttpSession session=request.getSession();
        request.setAttribute("community",l);
        request.getRequestDispatcher("Community.jsp").forward(request,response);
    }
}
