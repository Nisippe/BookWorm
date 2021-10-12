package Controller.GestioneLibro;

import Model.Community;
import Model.CommunityDao;
import Model.Libro;
import Model.LibroDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/CreaCommunityByBook")
public class CreaCommunityByBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommunityDao cd=new CommunityDao();
        HttpSession session=request.getSession();
        Community c=new Community();
        LibroDao ld=new LibroDao();
        if(cd.doRetrieveByTitolo(request.getParameter("nome"))!=null){
            request.setAttribute("errorCom","Community già esistente");
            request.getRequestDispatcher("CreaCommunity.jsp?isbn="+request.getParameter("ISBN")).forward(request,response);
        }
        Long isbn=Long.parseLong(request.getParameter("ISBN"));
        c.setTitoloCommunity(request.getParameter("nome"));
        c.setDescrizioneCommunity(request.getParameter("descrizione"));
        c.setImmagineCommunity("");
        cd.doSave(c, (String) session.getAttribute("username"),isbn);
        request.setAttribute("libro",ld.doRetrieveByISBN(isbn));
        request.setAttribute("NewCom","Community creata");
        request.getRequestDispatcher("Libro.jsp").forward(request,response);
    }
}
