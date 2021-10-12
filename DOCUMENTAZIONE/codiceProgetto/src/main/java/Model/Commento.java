package Model;

public class Commento {
    private int idCommento;
    private String testoCommento;

    public Commento() {
    }

    public Commento(int idCommento, String testoCommento) {
        this.idCommento = idCommento;
        this.testoCommento = testoCommento;
    }

    public int getIdCommento() {
        return idCommento;
    }

    public void setIdCommento(int idCommento) {
        this.idCommento = idCommento;
    }

    public String getTestoCommento() {
        return testoCommento;
    }

    public void setTestoCommento(String testoCommento) {
        this.testoCommento = testoCommento;
    }

    @Override
    public String toString() {
        return "Commento{" +
                "idCommento=" + idCommento +
                ", testoCommento='" + testoCommento + '\'' +
                '}';
    }
}
