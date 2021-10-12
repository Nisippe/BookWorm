package Model;

public class Segnalazione {
    private int idSegnalazione;
    private String descrizioneSegnalazione;
    private String genereSegnalazione;

    public Segnalazione() {
    }

    public Segnalazione(int idSegnalazione, String descrizioneSegnalazione, String genereSegnalazione) {
        this.idSegnalazione = idSegnalazione;
        this.descrizioneSegnalazione = descrizioneSegnalazione;
        this.genereSegnalazione = genereSegnalazione;
    }

    public int getIdSegnalazione() {
        return idSegnalazione;
    }

    public void setIdSegnalazione(int idSegnalazione) {
        this.idSegnalazione = idSegnalazione;
    }

    public String getDescrizioneSegnalazione() {
        return descrizioneSegnalazione;
    }

    public void setDescrizioneSegnalazione(String descrizioneSegnalazione) {
        this.descrizioneSegnalazione = descrizioneSegnalazione;
    }

    public String getGenereSegnalazione() {
        return genereSegnalazione;
    }

    public void setGenereSegnalazione(String genereSegnalazione) {
        this.genereSegnalazione = genereSegnalazione;
    }
}
