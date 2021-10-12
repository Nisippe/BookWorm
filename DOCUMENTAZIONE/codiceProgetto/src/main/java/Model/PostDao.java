package Model;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class PostDao {
    public void doSave(Post p,String username,Community c){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps=conn.prepareStatement("INSERT INTO Post(dataPost,immaginePost,descrizionePost,generePost) VALUES(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,p.getDataPost());
            ps.setString(2,p.getImmagine());
            ps.setString(3,p.getDescrizionePost());
            ps.setString(4,p.getGenerePost());
            if(ps.executeUpdate()!=1)
                throw new RuntimeException("INSERT Post error");
            conn.close();
            ps.close();
            int actualid=this.actualid();

                supdoSave(username, actualid);
                supdoSave2(c.getIdCommunity(), actualid);

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public int actualid() {
        try (Connection conn = ConPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) as c FROM Post",
                    Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            int id = 1;
            if (rs.next()) {
                id = rs.getInt("c");
            }
            conn.close();
            ps.close();
            rs.close();
            return id;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 1;
    }

        public void supdoSave(String username,int idpost){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps=conn.prepareStatement("INSERT INTO UtentePost(username,idPost) VALUES(?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1,username);
            ps.setInt(2,idpost);
            if(ps.executeUpdate()!=1)
                throw new RuntimeException("INSERT utentepost error");
            conn.close();
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void supdoSave2(int idCommunity,int idPost){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps=conn.prepareStatement("INSERT INTO PostCommunity(idCommunity,idPost) VALUES(?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,idCommunity);
            ps.setLong(2,idPost);
            if(ps.executeUpdate()!=1)
                throw new RuntimeException("INSERT postcommunity error");
            conn.close();
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(Post p){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("UPDATE Post set dataPost=?,immaginePost=?," +
                    "descrizionePost=?,generePost=? WHERE idPost=?");


            ps.setString(1,p.getDataPost());
            ps.setString(2,p.getImmagine());
            ps.setString(3,p.getDescrizionePost());
            ps.setString(4,p.getGenerePost());
            ps.setInt(5,p.getIdPost());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("UPDATE Post ERROR");
            }
            con.close();
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void doDelete(Post p){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps= conn.prepareStatement("DELETE FROM Post WHERE idPost=?");
            ps.setInt(1,p.getIdPost());
            if(ps.executeUpdate()!=1)
                throw new RuntimeException("DELETE Post error");
            conn.close();
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Post> doRetrieveByCommunity(Community c){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Post as p " +
                    "INNER JOIN PostCommunity as pc ON p.idPost=pc.idPost WHERE pc.idCommunity=?");
            ps.setInt(1,c.getIdCommunity());
            ResultSet rs=ps.executeQuery();
            Post l=null;
            ArrayList<Post> lista=new ArrayList<>();
            while(rs.next()){
                l=new Post(
                        rs.getInt("idPost"),
                        rs.getString("dataPost"),
                        rs.getString("immaginePost"),
                        rs.getString("descrizionePost"),
                        rs.getString("generePost")
                );
                lista.add(l);
            }
            con.close();
            ps.close();
            rs.close();
            return lista;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


    public Post doRetrieveById(int id){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Post where idPost=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            Post l=null;
            if(rs.next()){
                l=new Post(
                        rs.getInt("idPost"),
                        rs.getString("dataPost"),
                        rs.getString("immaginePost"),
                        rs.getString("descrizionePost"),
                        rs.getString("generePost")
                );
            }
            con.close();
            ps.close();
            rs.close();
            return l;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }



    public Post doRetrieveBySegnalazione(Segnalazione s){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Post as p INNER JOIN PostSegnalazione as ps ON p.idPost=ps.idPost where ps.idSegnalazione=?");
            ps.setInt(1,s.getIdSegnalazione());
            ResultSet rs=ps.executeQuery();
            Post l=null;
            if(rs.next()){
                l=new Post(
                        rs.getInt("idPost"),
                        rs.getString("dataPost"),
                        rs.getString("immaginePost"),
                        rs.getString("descrizionePost"),
                        rs.getString("generePost")
                );
            }
            con.close();
            ps.close();
            rs.close();
            return l;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }



    public void doLike(Post p,String username){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps=conn.prepareStatement("INSERT INTO UtentePostLike(username,idPost,ulike) VALUES(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,username);
            ps.setInt(2,p.getIdPost());
            ps.setInt(3,1);
            if(ps.executeUpdate()!=1)
                throw new RuntimeException("INSERT UtentePostLike error");
            conn.close();
            ps.close();
            }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void doRemoveLike(Post p,String username){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps= conn.prepareStatement("DELETE FROM UtentePostLike WHERE idPost=? AND username=?");
            ps.setInt(1,p.getIdPost());
            ps.setString(2,username);
            if(ps.executeUpdate()!=1)
                throw new RuntimeException("DELETE Post error");
            conn.close();
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


    public ArrayList<Post> sortByDate(ArrayList<Post> list) throws Exception{
        Comparator<Post> byBirthday = new Comparator<Post> () {
            public int compare(Post c1, Post c2) {
                SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
                try {
                    return Long.valueOf((formatter.parse(c2.getDataPost()).getTime())).compareTo((formatter.parse(c1.getDataPost()).getTime()));
                } catch (ParseException e) {
                    return 0;
                }
            }
        };
        Collections.sort(list, byBirthday);
        return list;
    }

}
