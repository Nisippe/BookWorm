package Controller.GestioneProfilo;

import Model.UtenteDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/DeleteAccount")
public class DeleteAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtenteDao ud=new UtenteDao();
        ud.doDelete(ud.doRetrieveByUsername(request.getParameter("username")));
        request.getRequestDispatcher("Login.jsp").forward(request,response);
    }
}
