package Controller.GestioneAutenticazione;

import Model.Utente;
import Model.UtenteDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/RegistrazioneServlet")
public class RegistrazioneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("Utente")!=null){
            try {
                throw new Exception("Utente già loggato");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        UtenteDao ud=new UtenteDao();
        String username=request.getParameter("username");
        if(username==null || ud.doRetrieveByUsername(username)!=null){
                request.setAttribute("usernameError","Username Non corretto o username già esistente");
                request.getRequestDispatcher("Registrazione.jsp").forward(request, response);
        }

        String password=request.getParameter("password");
        if(!(password!=null && !password.toLowerCase().equals(password) &&
                !password.toUpperCase().equals(password) && password.matches(".*[0-9].*"))){
            try {
                throw new Exception("Password non valida.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String email=request.getParameter("email");
        if(email==null || ud.doRetrieveByEmail(email)!=null){
            request.setAttribute("emailError","email Non corretta o email già esistente");
            request.getRequestDispatcher("Registrazione.jsp").forward(request, response);
        }

        String genere=request.getParameter("sex");


        String dataDiNascita=request.getParameter("date");
        if(!(dataDiNascita!=null)){
            try {
                throw new Exception("data non valida.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Utente u=new Utente(username,email,password,genere,dataDiNascita,"","",0,"Utente");
        ud.doSave(u);
        try {
            ud.sendMail(u.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("activeAccount","Attiva L'account");
        request.getRequestDispatcher("Login.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
