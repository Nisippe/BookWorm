package Controller.GestioneProfilo;

import Model.Utente;
import Model.UtenteDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ModificaProfilo")
public class ModificaProfiloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtenteDao ud=new UtenteDao();
        String bio=request.getParameter("bio");
        HttpSession session=request.getSession();
        Utente u=ud.doRetrieveByUsername((String) session.getAttribute("username"));
        session.setAttribute("bio",bio);
        u.setBio(bio);
        ud.doUpdate(u);
        request.getRequestDispatcher("Profilo.jsp").forward(request,response);
    }
}
