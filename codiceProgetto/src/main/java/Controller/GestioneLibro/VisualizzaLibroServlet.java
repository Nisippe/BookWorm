package Controller.GestioneLibro;

import Model.Libro;
import Model.LibroDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/VisualizzaLibro")
public class VisualizzaLibroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LibroDao ld=new LibroDao();
        String isbn=request.getParameter("isbn");
        Libro l=ld.doRetrieveByISBN(Long.parseLong(isbn));
        request.setAttribute("libro",l);
        request.getRequestDispatcher("Libro.jsp").forward(request,response);
    }
}
