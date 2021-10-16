package Controller.GestionePost;

import Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/VisualizzaLike")
public class VisualizzaLikeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostDao pd=new PostDao();
        Post p= pd.doRetrieveById(Integer.parseInt(request.getParameter("id")));
        UtenteDao ud=new UtenteDao();
        request.setAttribute("ListaUtenti",ud.doRetrieveByLikePost(p));
        request.getRequestDispatcher("ListaUtenti.jsp").forward(request,response);
    }
}
