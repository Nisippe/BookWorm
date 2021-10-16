package Model;

import java.sql.*;
import java.util.ArrayList;

public class LibroDao {
    public void doSave(Libro l){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps=conn.prepareStatement("INSERT INTO Libro(ISBN,titoloLibro,trama,genereLibro,autore,copertina) VALUES(?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1,l.getISBN());
            ps.setString(2,l.getTitoloLibro());
            ps.setString(3,l.getTrama());
            ps.setString(4,l.getGenereLibro());
            ps.setString(5,l.getAutore());
            ps.setString(6,l.getCopertina());
            if(ps.executeUpdate()!=1)
                throw new RuntimeException("INSERT Libro error");
            conn.close();
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(Libro l){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("UPDATE Libro set titoloLibro=?,trama=?," +
                    "genereLibro=?,autore=?,copertina=? WHERE ISBN=?");


            ps.setString(1,l.getTitoloLibro());
            ps.setString(2,l.getTrama());
            ps.setString(3,l.getGenereLibro());
            ps.setString(4,l.getAutore());
            ps.setString(5,l.getCopertina());
            ps.setLong(6,l.getISBN());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("UPDATE Libro ERROR");
            }
            con.close();
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void doDelete(Libro l){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps= conn.prepareStatement("DELETE FROM Libro WHERE ISBN=?");
            ps.setLong(1,l.getISBN());
            if(ps.executeUpdate()!=1)
                throw new RuntimeException("DELETE Libro error");
            conn.close();
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Libro doRetrieveByISBN(Long ISBN){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Libro WHERE ISBN=?");
            ps.setLong(1,ISBN);
            ResultSet rs=ps.executeQuery();
            Libro l=null;
            if(rs.next()){
                l=new Libro(
                        rs.getLong("ISBN"),
                        rs.getString("titoloLibro"),
                        rs.getString("trama"),
                        rs.getString("genereLibro"),
                        rs.getString("autore"),
                        rs.getString("copertina")
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


    public ArrayList<Libro> doRetrieveAll(){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Libro");
            ResultSet rs=ps.executeQuery();
            Libro l=null;
            ArrayList<Libro> lista=new ArrayList<>();
            while(rs.next()){
                l=new Libro(
                        rs.getLong("ISBN"),
                        rs.getString("titoloLibro"),
                        rs.getString("trama"),
                        rs.getString("genereLibro"),
                        rs.getString("autore"),
                        rs.getString("copertina")
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

    public ArrayList<Libro> doRetrieveByUtente(Utente u){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Libro as l INNER JOIN UtenteLibro as ul on l.ISBN=ul.ISBN " +
                    "INNER JOIN Utente as u on ul.username=u.username WHERE u.username=?");
            ps.setString(1,u.getUsername());
            ResultSet rs=ps.executeQuery();
            Libro l=null;
            ArrayList<Libro> lista=new ArrayList<>();
            while(rs.next()){
                l=new Libro(
                        rs.getLong("ISBN"),
                        rs.getString("titoloLibro"),
                        rs.getString("trama"),
                        rs.getString("genereLibro"),
                        rs.getString("autore"),
                        rs.getString("copertina")
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


    public ArrayList<Libro> doRetrieveByNomeOrDescrizione(String text){
        ArrayList<Libro> lista=new ArrayList<>();
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("select * from Libro where titoloLibro LIKE ? OR trama LIKE ?;");
            ps.setString(1,"%"+text+"%");
            ps.setString(2,"%"+text+"%");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Libro u=new Libro(rs.getLong("ISBN"),
                        rs.getString("titoloLibro"),
                        rs.getString("trama"),
                        rs.getString("genereLibro"),
                        rs.getString("autore"),
                        rs.getString("copertina")
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

}
