package Model;



import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;


public class UtenteDao {

    public void doSave(Utente u){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps=conn.prepareStatement("INSERT INTO Utente(username,email,userpassword,genere,dataDiNascita,bio,immagine,attivo,ruolo) VALUES(?,?,?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,u.getUsername());
            ps.setString(2,u.getEmail());
            ps.setString(3,u.getPassword());
            ps.setString(4,u.getGenere());
            ps.setString(5,u.getDataDiNascita());
            ps.setString(6,u.getBio());
            ps.setString(7,u.getImmagine());
            ps.setInt(8,u.getAttivo());
            ps.setString(9,u.getRuolo());
            if(ps.executeUpdate()!=1)
                throw new RuntimeException("INSERT error");
            conn.close();
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(Utente u){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("UPDATE Utente set email=?,userpassword=?," +
                    "genere=?,dataDiNascita=?,bio=?,immagine=?,attivo=?,ruolo=? WHERE username=?");

            ps.setString(1,u.getEmail());
            ps.setString(2,u.getPassword());
            ps.setString(3,u.getGenere());
            ps.setString(4,u.getDataDiNascita());
            ps.setString(5,u.getBio());
            ps.setString(6,u.getImmagine());
            ps.setInt(7,u.getAttivo());
            ps.setString(8,u.getRuolo());
            ps.setString(9,u.getUsername());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("UPDATE Utente ERROR");
            }
            con.close();
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void doDelete(Utente u){
        try(Connection conn=ConPool.getConnection()){
            PreparedStatement ps= conn.prepareStatement("DELETE FROM Utente WHERE username=?");
            ps.setString(1,u.getUsername());
            if(ps.executeUpdate()!=1)
                throw new RuntimeException("DELETE Utente error");
            conn.close();
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Utente doRetrieveByUsername(String username){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Utente WHERE username=?");
            ps.setString(1,username);
            ResultSet rs=ps.executeQuery();
            Utente u=null;
            while(rs.next()){
                u=new Utente(
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("userpassword"),
                        rs.getString("genere"),
                        rs.getString("dataDiNascita"),
                        rs.getString("bio"),
                        rs.getString("immagine"),
                        rs.getInt("attivo"),
                        rs.getString("ruolo")
                );
            }
            con.close();
            ps.close();
            rs.close();
            return u;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Utente doRetrieveByEmail(String email){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Utente WHERE email=?");
            ps.setString(1,email);
            ResultSet rs=ps.executeQuery();
            Utente u=null;
            while(rs.next()){
                u=new Utente(
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("userpassword"),
                        rs.getString("genere"),
                        rs.getString("dataDiNascita"),
                        rs.getString("bio"),
                        rs.getString("immagine"),
                        rs.getInt("attivo"),
                        rs.getString("ruolo")
                );
            }
            con.close();
            ps.close();
            rs.close();
            return u;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }



    public ArrayList<Utente> doRetrieveAll(){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Utente");
            ResultSet rs=ps.executeQuery();
            Utente u=null;
            ArrayList<Utente> lista=new ArrayList<>();
            while(rs.next()){
                u=new Utente(
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("userpassword"),
                    rs.getString("genere"),
                    rs.getString("dataDiNascita"),
                    rs.getString("bio"),
                    rs.getString("immagine"),
                    rs.getInt("attivo"),
                    rs.getString("ruolo")
                );
                lista.add(u);
            }
            con.close();
            ps.close();
            rs.close();
            return lista;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void doChangePassword(Utente u,String password){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("UPDATE Utente set userpassword=? WHERE username=?");

            ps.setString(1,u.getPassword());
            ps.setString(2,u.getUsername());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("UPDATE Utente password ERROR");
            }
            con.close();
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Utente doActive(String email){
        try(Connection con=ConPool.getConnection()){
            Utente u=this.doRetrieveByEmail(email);
            u.setAttivo(1);
            this.doUpdate(u);
            return u;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Utente> doRetrieveByCommunity(Community c){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Utente AS u INNER JOIN UtenteCommunity  as uc ON u.username=uc.username INNER JOIN Community AS c " +
                    "ON c.idCommunity=uc.idCommunity WHERE c.idCommunity=?");
            ps.setInt(1,c.getIdCommunity());
            ResultSet rs=ps.executeQuery();
            Utente u=null;
            ArrayList<Utente> lista=new ArrayList<>();
            while(rs.next()){
                u=new Utente(
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("userpassword"),
                        rs.getString("genere"),
                        rs.getString("dataDiNascita"),
                        rs.getString("bio"),
                        rs.getString("immagine"),
                        rs.getInt("attivo"),
                        rs.getString("ruolo")
                );
                lista.add(u);
            }
            con.close();
            ps.close();
            rs.close();
            return lista;

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


    public Utente doRetrieveByIdPost(Post p){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Utente AS u INNER JOIN UtentePost  as uc ON u.username=uc.username INNER JOIN Post AS p " +
                    "ON p.idPost=uc.idPost WHERE p.idPost=?");
            ps.setInt(1,p.getIdPost());
            ResultSet rs=ps.executeQuery();
            Utente u=null;
            if(rs.next()){
                u=new Utente(
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("userpassword"),
                        rs.getString("genere"),
                        rs.getString("dataDiNascita"),
                        rs.getString("bio"),
                        rs.getString("immagine"),
                        rs.getInt("attivo"),
                        rs.getString("ruolo")
                );
            }
            con.close();
            ps.close();
            rs.close();
            return u;

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Utente> doRetrieveByLikePost(Post p){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Utente AS u INNER JOIN UtentePostLike  as upc ON u.username=upc.username INNER JOIN Post AS p " +
                    "ON p.idPost=upc.idPost WHERE p.idPost=? AND upc.ulike=1");
            ps.setInt(1,p.getIdPost());
            ResultSet rs=ps.executeQuery();
            Utente u=null;
            ArrayList<Utente> list=new ArrayList<>();
            if(rs.next()){
                u=new Utente(
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("userpassword"),
                        rs.getString("genere"),
                        rs.getString("dataDiNascita"),
                        rs.getString("bio"),
                        rs.getString("immagine"),
                        rs.getInt("attivo"),
                        rs.getString("ruolo")
                );
            list.add(u);
            }
            con.close();
            ps.close();
            rs.close();
            return list;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }




    public Utente doRetrieveByIdCommento(Commento c){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Utente AS u INNER JOIN UtenteCommento  as uc ON u.username=uc.username INNER JOIN Commento AS c " +
                    "ON c.idCommento=uc.idCommento WHERE c.idCommento=?");
            ps.setInt(1,c.getIdCommento());
            ResultSet rs=ps.executeQuery();
            Utente u=null;
            if(rs.next()){
                u=new Utente(
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("userpassword"),
                        rs.getString("genere"),
                        rs.getString("dataDiNascita"),
                        rs.getString("bio"),
                        rs.getString("immagine"),
                        rs.getInt("attivo"),
                        rs.getString("ruolo")
                );
            }
            con.close();
            ps.close();
            rs.close();
            return u;

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


    public Utente doRetrievePropByCommunity(Community c){
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("SELECT * FROM Utente AS u INNER JOIN UtenteCommunity  as uc ON u.username=uc.username " +
                    "INNER JOIN Community AS c ON c.idCommunity=uc.idCommunity WHERE c.idCommunity=? AND uc.ruoloCommunity='Proprietario'");
            ps.setInt(1,c.getIdCommunity());
            ResultSet rs=ps.executeQuery();
            Utente u=null;
            if(rs.next()){
                u=new Utente(
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("userpassword"),
                        rs.getString("genere"),
                        rs.getString("dataDiNascita"),
                        rs.getString("bio"),
                        rs.getString("immagine"),
                        rs.getInt("attivo"),
                        rs.getString("ruolo")
                );
            }
            con.close();
            ps.close();
            rs.close();
            return u;

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }





public void sendMail(String email) throws Exception {
            String d_host = "smtp.gmail.com";
            String d_port  = "465";
    Properties props = new Properties();
    props.put("mail.smtp.user", email);
    props.put("mail.smtp.host", d_host);
    props.put("mail.smtp.port", d_port);
    props.put("mail.smtp.starttls.enable","true");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.debug", "true");
    props.put("mail.smtp.socketFactory.port", d_port);
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.socketFactory.fallback", "false");

        String password="pass";

        Session session= Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("nisippe99@gmail.com","grtanda1");
            }
        });

        try{
            MimeMessage message=new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setText("Link di verifica..");
            message.setText("Clicca qui: "+"http://localhost:8080/codiceProgetto_war_exploded/AttivazioneAccount?key1="+email);
            Transport.send(message);
        }catch(Exception e){
            throw new Exception(e);
        }
}

    public void sendMailPass(String email) throws Exception {
        String d_host = "smtp.gmail.com";
        String d_port  = "465";
        Properties props = new Properties();
        props.put("mail.smtp.host", d_host);
        props.put("mail.smtp.port", d_port);
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.socketFactory.port", d_port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        String password="pass";

        Session session= Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("nisippe99@gmail.com","grtanda1");
            }
        });

        Utente x=this.doRetrieveByEmail(email);


        try{
            MimeMessage message=new MimeMessage(session);
            message.setFrom(new InternetAddress(email));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setText("La tua password è "+ x.getPassword());
            Transport.send(message);
        }catch(Exception e){
            throw new Exception(e);
        }
    }



    public ArrayList<Utente> doRetrieveByNome(String text){
        ArrayList<Utente> lista=new ArrayList<>();
        try(Connection con=ConPool.getConnection()){
            PreparedStatement ps=con.prepareStatement("select * from Utente where username LIKE ?");
            ps.setString(1,"%"+text+"%");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Utente u=new Utente(rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("userpassword"),
                        rs.getString("genere"),
                        rs.getString("dataDiNascita"),
                        rs.getString("bio"),
                        rs.getString("immagine"),
                        rs.getInt("attivo"),
                        rs.getString("ruolo")
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
