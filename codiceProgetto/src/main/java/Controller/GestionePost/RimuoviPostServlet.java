package Controller.GestionePost;

import Model.Community;
import Model.CommunityDao;
import Model.PostDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/RimuoviPost")
public class RimuoviPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostDao pd=new PostDao();
        pd.doDelete(pd.doRetrieveById(Integer.parseInt(request.getParameter("id"))));
        CommunityDao cd=new CommunityDao();
        Community c=cd.doRetrieveById(Integer.parseInt(request.getParameter("idc")));
        request.setAttribute("community",c);
        request.getRequestDispatcher("Community.jsp").forward(request,response);
    }
}
