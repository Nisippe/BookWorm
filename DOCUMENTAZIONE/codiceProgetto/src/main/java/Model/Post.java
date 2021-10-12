package Model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class Post {
    private int idPost;
    private String dataPost;
    private String immagine;
    private String descrizionePost;
    private String generePost;

    public Post() {
    }

    public Post(int idPost, String dataPost, String immagine, String descrizionePost, String generePost) {
        this.idPost = idPost;
        this.dataPost = dataPost;
        this.immagine = immagine;
        this.descrizionePost = descrizionePost;
        this.generePost = generePost;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getDataPost() {
        return dataPost;
    }

    public void setDataPost(String dataPost) {
        this.dataPost = dataPost;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public String getDescrizionePost() {
        return descrizionePost;
    }

    public void setDescrizionePost(String descrizionePost) {
        this.descrizionePost = descrizionePost;
    }

    public String getGenerePost() {
        return generePost;
    }

    public void setGenerePost(String generePost) {
        this.generePost = generePost;
    }

    @Override
    public String toString() {
        return "Post{" +
                "idPost=" + idPost +
                ", dataPost=" + dataPost +
                ", immagine='" + immagine + '\'' +
                ", descrizionePost='" + descrizionePost + '\'' +
                ", generePost='" + generePost + '\'' +
                '}';
    }


    public String isProp(){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Utente as u " +
                    "INNER JOIN UtentePost as up ON u.username=up.username INNER JOIN Post as p ON p.idPost=up.idPost WHERE p.idPost=?");
            ps.setInt(1,this.getIdPost());
            ResultSet rs=ps.executeQuery();
            Utente u=null;
            ArrayList<Post> lista=new ArrayList<>();
            while(rs.next()){
               u=new Utente(rs.getString("username"),
                       rs.getString("email"),
                        rs.getString("userpassword"),
                        rs.getString("genere"),
                        rs.getString("dataDiNascita"),
                        rs.getString("bio"),
                        rs.getString("immagine"),
                        rs.getInt("attivo"),
                        rs.getString("ruolo"));
            }
            con.close();
            ps.close();
            rs.close();
            return u.getUsername();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

}
