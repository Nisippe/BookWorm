package Controller.GestionePost;

import Model.Community;
import Model.CommunityDao;
import Model.Post;
import Model.PostDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/RemoveLike")
public class RemoveLikeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        PostDao pd=new PostDao();
        CommunityDao cd=new CommunityDao();
        Post p=pd.doRetrieveById(Integer.parseInt(request.getParameter("id")));
        Community c=cd.doRetrieveById(Integer.parseInt(request.getParameter("idc")));
        pd.doRemoveLike(pd.doRetrieveById(Integer.parseInt(request.getParameter("id"))), (String) session.getAttribute("username"));
        request.getRequestDispatcher("Post.jsp?id="+p.getIdPost()+"&idc="+c.getIdCommunity()).forward(request,response);
    }
}
