package Controller.GestioneAmministratore;

import Model.Post;
import Model.PostDao;
import Model.Segnalazione;
import Model.SegnalazioneDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/NuovaSegnalazionePost")
public class NuovaSegnalazionePostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String descrizione=request.getParameter("descrizione");
        String genere=request.getParameter("genere");
        HttpSession session=request.getSession();
        PostDao pd=new PostDao();
        Post p=pd.doRetrieveById(Integer.parseInt(request.getParameter("id")));
        SegnalazioneDao sd=new SegnalazioneDao();
        Segnalazione s=new Segnalazione();
        s.setDescrizioneSegnalazione(descrizione);
        s.setGenereSegnalazione(genere);


        sd.doSave(s,p.getIdPost(), (String) session.getAttribute("username"));
        request.setAttribute("postsegnalato","post segnalato");
        request.getRequestDispatcher("Post.jsp?id="+p.getGenerePost()+"&idc="+request.getParameter("idc")).forward(request,response);
    }
}
