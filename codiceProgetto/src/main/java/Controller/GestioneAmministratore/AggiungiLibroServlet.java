package Controller.GestioneAmministratore;

import Model.Libro;
import Model.LibroDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/AggiungiLibro")
public class AggiungiLibroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long isbn=Long.parseLong(request.getParameter("isbn"));
        String titolo=request.getParameter("titolo");
        String autore=request.getParameter("autore");
        String genere=request.getParameter("genere");
        String trama=request.getParameter("trama");

        LibroDao ld=new LibroDao();
        ld.doSave(new Libro(isbn,titolo,trama,genere,autore,""));
        response.sendRedirect("/VisualizzaListaLibri");
    }
}
