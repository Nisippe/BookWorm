package Model;

import java.sql.*;
import java.util.ArrayList;

public class SegnalazioneDao {
    public void doSave(Segnalazione p,int idPost,String username){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps=conn.prepareStatement("INSERT INTO Segnalazione(descrizioneSegnalazione,genereSegnalazione) VALUES(?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,p.getDescrizioneSegnalazione());
            ps.setString(2,p.getDescrizioneSegnalazione());

            if(ps.executeUpdate()!=1)
                throw new RuntimeException("INSERT Segnalazione error");
            supdoSave(username,idPost,this.actualid());
            conn.close();
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public int actualid() {
        try (Connection conn = ConPool.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) as c FROM Segnalazione",
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

    public void supdoSave(String username,int idpost,int idSegnalazione){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps=conn.prepareStatement("INSERT INTO PostSegnalazione(username,idPost,idSegnalazione) VALUES(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,username);
            ps.setInt(2,idpost);
            ps.setInt(3,idSegnalazione);
            if(ps.executeUpdate()!=1)
                throw new RuntimeException("INSERT PostSegnalazione error");
            conn.close();
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


    public void doDelete(Segnalazione s){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps= conn.prepareStatement("DELETE FROM Segnalazione WHERE idSegnalazione=?");
            ps.setInt(1,s.getIdSegnalazione());
            if(ps.executeUpdate()!=1)
                throw new RuntimeException("DELETE Segnalazione error");
            conn.close();
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Segnalazione> doRetrieveAll(){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Segnalazione");
            ResultSet rs=ps.executeQuery();
            Segnalazione s=null;
            ArrayList<Segnalazione> lista=new ArrayList<>();
            while(rs.next()){
                s=new Segnalazione(
                        rs.getInt("idSegnalazione"),
                        rs.getString("descrizioneSegnalazione"),
                        rs.getString("genereSegnalazione")
                );
                lista.add(s);
            }
            con.close();
            ps.close();
            rs.close();
            return lista;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Segnalazione> doRetrieveByUsername(String username) {
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Segnalazione as s INNER JOIN PostSegnalazione as ps ON s.idSegnalazione=ps.idSegnalazione  WHERE ps.username=?");
            ps.setString(1,username);
            ResultSet rs=ps.executeQuery();
            Segnalazione l=null;
            ArrayList<Segnalazione> lista=new ArrayList<>();
            while(rs.next()){
                l=new Segnalazione(
                        rs.getInt("idSegnalazione"),
                        rs.getString("descrizioneSegnalazione"),
                        rs.getString("genereSegnalazione")
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

    public ArrayList<Segnalazione> doRetrieveByCommunity(Community c){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Segnalazione as s INNER JOIN SegnalazioneCommunity as sc ON s.idSegnalazione=sc.idSegnalazione WHERE sc.idCommunity=?");
            ps.setInt(1,c.getIdCommunity());
            ResultSet rs=ps.executeQuery();
            Segnalazione l=null;
            ArrayList<Segnalazione> lista=new ArrayList<>();
            while(rs.next()){
                l=new Segnalazione(
                        rs.getInt("idSegnalazione"),
                        rs.getString("descrizioneSegnalazione"),
                        rs.getString("genereSegnalazione")
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



    public Segnalazione doRetrieveById(int id){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Segnalazione WHERE idSegnalazione=?");
            ps.setLong(1,id);
            ResultSet rs=ps.executeQuery();
            Segnalazione l=null;

            if(rs.next()){
                l=new Segnalazione(
                        rs.getInt("idSegnalazione"),
                        rs.getString("descrizioneSegnalazione"),
                        rs.getString("genereSegnalazione")
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

