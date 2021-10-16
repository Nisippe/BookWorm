package Controller.GestioneAmministratore;

import Model.Libro;
import Model.LibroDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.*;
import java.awt.*;
import java.io.*;


@WebServlet("/ModificaLibro")
public class ModificaLibroServlet extends HttpServlet {
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
        request.setAttribute("libromod","libro modificato");

        String upload_directory="C:\\Users\\gnisi\\IdeaProjects\\codiceProgetto\\src\\main\\webapp";



        LibroDao ld=new LibroDao();
        ld.doUpdate(new Libro(isbn,titolo,trama,genere,autore,""));
        response.sendRedirect("AdminPage.jsp");
    }
}
