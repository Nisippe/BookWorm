package Controller.GestioneAmministratore;

import Model.LibroDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/VisualizzaListaLibri")
public class VisualizzaListaLibriServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LibroDao ld=new LibroDao();
        HttpSession session=request.getSession();
        request.setAttribute("ListaLibri",ld.doRetrieveAll());
        request.getRequestDispatcher("ListaLibri.jsp").forward(request,response);
    }
}
