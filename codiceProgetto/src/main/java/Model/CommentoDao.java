package Model;

import java.sql.*;
import java.util.ArrayList;

public class CommentoDao {

    public void doSave(Commento c,Post p,String username){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps=conn.prepareStatement("INSERT INTO Commento(idCommento,testoCommento) VALUES(?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,c.getIdCommento());
            ps.setString(2,c.getTestoCommento());
            if(ps.executeUpdate()!=1)
                throw new RuntimeException("INSERT Commento error");
            conn.close();
            ps.close();

            supdoSave(username,actualid(),p.getIdPost());

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public int actualid() {
        try (Connection conn = ConPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) as c FROM Commento",
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


    public void supdoSave(String username,int idCommento,int idpost){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps=conn.prepareStatement("INSERT INTO UtenteCommento(username,idCommento,idPost) VALUES(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1,username);
            ps.setInt(2,idCommento);
            ps.setInt(3,idpost);
            if(ps.executeUpdate()!=1)
                throw new RuntimeException("INSERT utentecommento error");
            conn.close();
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(Commento c){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("UPDATE Utente set testoCommento=?" +
                    "WHERE idCommento=?,");


            ps.setString(1,c.getTestoCommento());
            ps.setInt(2,c.getIdCommento());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("UPDATE Commento ERROR");
            }
            con.close();
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void doDelete(Commento c){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps= conn.prepareStatement("DELETE FROM Commento WHERE idCommento=?");
            ps.setLong(1,c.getIdCommento());
            if(ps.executeUpdate()!=1)
                throw new RuntimeException("DELETE Commento error");
            conn.close();
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


    public ArrayList<Commento> doRetrieveByPost(Post p){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Commento as c " +
                    "INNER JOIN UtenteCommento as cc ON c.idCommento=cc.idCommento WHERE cc.idPost=?");
            ps.setLong(1,p.getIdPost());
            ResultSet rs=ps.executeQuery();
            Commento l=null;
            ArrayList<Commento> lista=new ArrayList<>();
            while(rs.next()){
                l=new Commento(
                        rs.getInt("idCommento"),
                        rs.getString("testoCommento")
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


    public Commento doRetrieveById(int id){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Commento WHERE idCommento=?");
            ps.setLong(1,id);
            ResultSet rs=ps.executeQuery();
            Commento l=null;

            if(rs.next()){
                l=new Commento(
                        rs.getInt("idCommento"),
                        rs.getString("testoCommento")
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
}
