package Model;

import java.sql.*;
import java.util.ArrayList;

public class CommunityDao {

    public void doSave(Community c,String user,Long isbn){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps=conn.prepareStatement("INSERT INTO Community(titoloCommunity,descrizioneCommunity,immagineCommunity) VALUES(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,c.getTitoloCommunity());
            ps.setString(2,c.getDescrizioneCommunity());
            ps.setString(3,c.getImmagineCommunity());
            if(ps.executeUpdate()!=1)
                throw new RuntimeException("INSERT Community error");
            conn.close();
            ps.close();
            supdoSave(user,c.getTitoloCommunity());
            supdoSave2(isbn,c.getTitoloCommunity());
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void supdoSave(String user,String titolo){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps=conn.prepareStatement("INSERT INTO UtenteCommunity(username,idCommunity,ruoloCommunity) VALUES(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1,user);
            ps.setInt(2,this.doRetrieveByTitolo(titolo).getIdCommunity());
            ps.setString(3,"Proprietario");
            if(ps.executeUpdate()!=1)
                throw new RuntimeException("INSERT Community error");
            conn.close();
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void supdoSave2(Long isbn,String titolo){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps=conn.prepareStatement("INSERT INTO LibroCommunity(idCommunity,ISBN) VALUES(?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,this.doRetrieveByTitolo(titolo).getIdCommunity());
            ps.setLong(2,isbn);
            if(ps.executeUpdate()!=1)
                throw new RuntimeException("INSERT Community error");
            conn.close();
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }



    public void doUpdate(Community c){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("UPDATE Community set titoloCommunity=?,descrizioneCommunity=?," +
                    "immagineCommunity=? WHERE idCommunity=?");


            ps.setString(1,c.getTitoloCommunity());
            ps.setString(2,c.getDescrizioneCommunity());
            ps.setString(3,c.getImmagineCommunity());
            ps.setInt(4,c.getIdCommunity());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("UPDATE Community ERROR");
            }
            con.close();
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void doDelete(Community c){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps= conn.prepareStatement("DELETE FROM Community WHERE idCommunity=?");
            ps.setLong(1,c.getIdCommunity());
            if(ps.executeUpdate()!=1)
                throw new RuntimeException("DELETE Community error");
            conn.close();
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Community doRetrieveById(int id){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Community WHERE idCommunity=?");
            ps.setLong(1,id);
            ResultSet rs=ps.executeQuery();
            Community l=null;
            if(rs.next()){
                l=new Community(
                        rs.getInt("idCommunity"),
                        rs.getString("titoloCommunity"),
                        rs.getString("immagineCommunity"),
                        rs.getString("descrizioneCommunity")
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


    public Community doRetrieveByTitolo(String titolo){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Community WHERE titoloCommunity=?");
            ps.setString(1,titolo);
            ResultSet rs=ps.executeQuery();
            Community l=null;
            if(rs.next()){
                l=new Community(
                        rs.getInt("idCommunity"),
                        rs.getString("titoloCommunity"),
                        rs.getString("immagineCommunity"),
                        rs.getString("descrizioneCommunity")
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


    public ArrayList<Community> doRetrieveByLibro(Libro l){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Community as c " +
                    "INNER JOIN LibroCommunity as lc ON c.idCommunity=lc.idCommunity INNER JOIN Libro as l  ON lc.ISBN=l.ISBN WHERE l.ISBN=?");
            ps.setLong(1,l.getISBN());
            ResultSet rs=ps.executeQuery();
            Community c=null;
            ArrayList<Community> lista=new ArrayList<>();
            while(rs.next()){
                c=new Community(
                        rs.getInt("idCommunity"),
                        rs.getString("titoloCommunity"),
                        rs.getString("immagineCommunity"),
                        rs.getString("descrizioneCommunity")
                );
                lista.add(c);
            }
            con.close();
            ps.close();
            rs.close();
            return lista;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Community> doRetrieveByUtente(Utente u){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Community as c " +
                    "INNER JOIN UtenteCommunity as uc ON c.idCommunity=uc.idCommunity WHERE uc.username=?");
            ps.setString(1,u.getUsername());
            ResultSet rs=ps.executeQuery();
            Community l=null;
            ArrayList<Community> lista=new ArrayList<>();
            while(rs.next()){
                l=new Community(
                        rs.getInt("idCommunity"),
                        rs.getString("titoloCommunity"),
                        rs.getString("immagineCommunity"),
                        rs.getString("descrizioneCommunity")
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


    public ArrayList<Community> doRetrieveByNomeOrDescrizione(String text){
        ArrayList<Community> lista=new ArrayList<>();
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("select * from Community where titoloCommunity LIKE ? OR descrizioneCommunity LIKE ?");
            ps.setString(1,"%"+text+"%");
            ps.setString(2,"%"+text+"%");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Community u=new Community(rs.getInt("idCommunity"),
                        rs.getString("titoloCommunity"),
                        rs.getString("immagineCommunity"),
                        rs.getString("descrizioneCommunity")
                );
                lista.add(u);
            }
            con.close();
            ps.close();
            rs.close();
            return lista;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Community doRetrieveByPost(Post s){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Community as c INNER JOIN PostCommunity as pc ON c.idCommunity=pc.idCommunity INNER JOIN Post as p ON p.idPost=pc.idPost where p.idPost=?");
            ps.setInt(1,s.getIdPost());
            ResultSet rs=ps.executeQuery();
            Community l=null;
            if(rs.next()){
                l=new Community(
                        rs.getInt("idCommunity"),
                        rs.getString("titoloCommunity"),
                        rs.getString("immagineCommunity"),
                        rs.getString("descrizioneCommunity")
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
