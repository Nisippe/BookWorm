package Controller.GestioneAmministratore;

import Model.LibroDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RimuoviLibro")
public class RimuoviLibroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LibroDao ld=new LibroDao();
        ld.doDelete(ld.doRetrieveByISBN(Long.parseLong(request.getParameter("isbn"))));
        request.setAttribute("librodel","libro eliminato");
        response.sendRedirect("AdminPage.jsp");
    }
}
