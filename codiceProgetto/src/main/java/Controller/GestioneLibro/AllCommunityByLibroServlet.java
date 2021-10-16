package Controller.GestioneLibro;

import Model.CommunityDao;
import Model.LibroDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/AllCommunityByLibro")
public class AllCommunityByLibroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommunityDao cd=new CommunityDao();
        LibroDao ld=new LibroDao();
        request.setAttribute("lista",cd.doRetrieveByLibro(ld.doRetrieveByISBN(Long.parseLong(request.getParameter("isbn")))));
        request.getRequestDispatcher("ListaCommunity.jsp").forward(request,response);
    }
}
