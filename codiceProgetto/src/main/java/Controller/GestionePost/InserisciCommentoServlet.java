package Controller.GestionePost;

import Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/InserisciCommento")
public class InserisciCommentoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //idc=<%=c.getIdCommunity()%>&id=<%=p.getIdPost()%>
        CommunityDao cd=new CommunityDao();
        PostDao pd=new PostDao();
        Community c= cd.doRetrieveById(Integer.parseInt(request.getParameter("idc")));
        Post p= pd.doRetrieveById(Integer.parseInt(request.getParameter("id")));
        HttpSession session=request.getSession();
        String commento=request.getParameter("commento");
        CommentoDao comd=new CommentoDao();
        Commento commento1=new Commento();
        commento1.setTestoCommento(commento);
        comd.doSave(commento1,p, (String) session.getAttribute("username"));
        request.getRequestDispatcher("Post.jsp?id="+p.getIdPost()+"&idc="+c.getIdCommunity()).forward(request,response);
    }
}
