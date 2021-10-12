package Model;

import java.sql.*;

public class Utente {
    private String username;
    private String email;
    private String password;
    private String genere;
    private String dataDiNascita;
    private String bio;
    private String immagine;
    private int attivo;
    private String ruolo;


    public Utente() {
    }

    public Utente(String username, String email, String password, String genere, String dataDiNascita, String bio, String immagine, int attivo, String ruolo) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.genere = genere;
        this.dataDiNascita = dataDiNascita;
        this.bio = bio;
        this.immagine = immagine;
        this.attivo = attivo;
        this.ruolo = ruolo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }


    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public int getAttivo() {
        return attivo;
    }

    public void setAttivo(int attivo) {
        this.attivo = attivo;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(String dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", genere='" + genere + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", bio='" + bio + '\'' +
                ", immagine='" + immagine + '\'' +
                ", attivo=" + attivo +
                ", ruolo='" + ruolo + '\'' +
                '}';
    }


    public boolean isAdmin(){
        if(this.ruolo.equals("Admin"))
            return true;
        return false;
    }

    public boolean isMod(Community c){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT ruoloCommunity FROM UtenteCommunity as uc INNER JOIN Utente as u ON u.username=uc.username WHERE uc.idCommunity=? AND u.username=?");
            ps.setInt(1,c.getIdCommunity());
            ps.setString(2,this.getUsername());
            ResultSet rs=ps.executeQuery();
            String u=null;
            if(rs.next()){
                u=rs.getString("ruoloCommunity");
            }
            con.close();
            ps.close();
            rs.close();
            if(u!=null) {
                if (u.equals("Proprietario"))
                    return true;
            }
            return false;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean follow(Community c){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Utente as u INNER JOIN UtenteCommunity as uc ON u.username=uc.username INNER JOIN Community as c ON c.idCommunity=uc.idCommunity" +
                    " WHERE uc.idCommunity=? AND u.username=?");
            ps.setInt(1,c.getIdCommunity());
            ps.setString(2,this.getUsername());
            ResultSet rs=ps.executeQuery();
            Utente u=null;
            if(rs.next()){
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
            if(u!=null)
                return true;
            return false;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


    public void doFollow(Community c){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps=conn.prepareStatement("INSERT INTO UtenteCommunity(username,idCommunity,ruoloCommunity) VALUES(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,this.getUsername());
            ps.setInt(2,c.getIdCommunity());
            ps.setString(3,"Partecipante");
            if(ps.executeUpdate()!=1)
                throw new RuntimeException("INSERT error");
            conn.close();
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


    public void doNotFollow(Community c){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps=conn.prepareStatement("DELETE FROM UtenteCommunity where idCommunity=? and username=?",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,c.getIdCommunity());
            ps.setString(2,this.getUsername());
            if(ps.executeUpdate()!=1)
                throw new RuntimeException("DELETE error");
            conn.close();
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


    public int dolike(Post p){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT ulike FROM UtentePostLike as upc INNER JOIN Utente as u ON u.username=upc.username INNER JOIN Post as p ON p.idPost=upc.idPost" +
                    " WHERE p.idPost=? AND u.username=?");
            ps.setInt(1,p.getIdPost());
            ps.setString(2,this.getUsername());
            ResultSet rs=ps.executeQuery();
            int ulike=0;
            if(rs.next()){
                ulike=rs.getInt("ulike");
            }
            con.close();
            ps.close();
            rs.close();
            return ulike;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

}
