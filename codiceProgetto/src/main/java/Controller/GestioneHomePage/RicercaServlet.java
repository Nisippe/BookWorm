package Controller.GestioneHomePage;

import Model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Ricerca")
public class RicercaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param=request.getParameter("param");
        String text=request.getParameter("text");
        if(param.equals("username")){
            UtenteDao ud=new UtenteDao();
            ArrayList<Utente> list=ud.doRetrieveByNome(text);
            request.setAttribute("ListaUtenti",list);
           request.getRequestDispatcher("ListaUtenti.jsp").forward(request,response);
           response.sendRedirect("ListaUtenti.jsp");
        }else if(param.equals("community")){
            CommunityDao cd=new CommunityDao();
            ArrayList<Community> list= cd.doRetrieveByNomeOrDescrizione(text);
            request.setAttribute("lista",list);
            request.getRequestDispatcher("ListaCommunity.jsp").forward(request,response);
        }else{
            LibroDao ld=new LibroDao();
            ArrayList<Libro> list= ld.doRetrieveByNomeOrDescrizione(text);
            request.setAttribute("ListaLibri",list);
            request.getRequestDispatcher("ListaLibri.jsp").forward(request,response);
        }






    }
}
