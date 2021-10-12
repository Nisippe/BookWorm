package Controller.GestioneProfilo;

import Model.Utente;
import Model.UtenteDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ModificaPassword")
public class ModificaPasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtenteDao ud=new UtenteDao();
        String password=request.getParameter("password");
        String passwordatt=request.getParameter("passwordatt");
        HttpSession session=request.getSession();
        Utente u=ud.doRetrieveByUsername((String) session.getAttribute("username"));
        if(password.equals(passwordatt)) {
            request.setAttribute("passwordError", "Hai inserito la stessa password!");
            request.getRequestDispatcher("ModificaPassword.jsp").forward(request, response);
        }else if(!(passwordatt.equals(u.getPassword()))){
            request.setAttribute("passwordAttError", "Hai inserito una password sbagliata");
            request.getRequestDispatcher("ModificaPassword.jsp").forward(request, response);
        }else{
            u.setPassword(password);
            ud.doUpdate(u);
            request.setAttribute("passwordnew","La tua password è stata cambiata");
            request.getRequestDispatcher("Profilo.jsp").forward(request,response);
        }

    }
}
