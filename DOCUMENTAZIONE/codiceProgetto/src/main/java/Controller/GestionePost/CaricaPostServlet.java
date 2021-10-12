package Controller.GestionePost;

import Model.Community;
import Model.CommunityDao;
import Model.Post;
import Model.PostDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/CaricaPost")
public class CaricaPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String descrizione=request.getParameter("descrizione");
        String immagine=request.getParameter("immagine");
        String genere=request.getParameter("generepost");
        HttpSession session=request.getSession();
        Post p=new Post();
        CommunityDao cd=new CommunityDao();
        p.setDescrizionePost(descrizione);
        p.setImmagine(immagine);
        p.setGenerePost(genere);
        Date date =  java.util.Calendar.getInstance().getTime();
        SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        p.setDataPost(formatter.format(date));
        Community c=cd.doRetrieveById(Integer.parseInt(request.getParameter("c")));
        PostDao pd=new PostDao();
        pd.doSave(p,(String) session.getAttribute("username"),c);
        request.setAttribute("community",c);
        request.getRequestDispatcher("Community.jsp").forward(request,response);
    }
}
