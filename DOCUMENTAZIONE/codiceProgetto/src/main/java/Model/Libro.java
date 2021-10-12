package Model;

public class Libro {
    private long ISBN;
    private String titoloLibro;
    private String trama;
    private String genereLibro;
    private String autore;
    private String copertina;

    public Libro() {
    }

    public Libro(long ISBN, String titoloLibro, String trama, String genereLibro, String autore, String copertina) {
        this.ISBN = ISBN;
        this.titoloLibro = titoloLibro;
        this.trama = trama;
        this.genereLibro = genereLibro;
        this.autore = autore;
        this.copertina = copertina;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitoloLibro() {
        return titoloLibro;
    }

    public void setTitoloLibro(String titoloLibro) {
        this.titoloLibro = titoloLibro;
    }

    public String getTrama() {
        return trama;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }

    public String getGenereLibro() {
        return genereLibro;
    }

    public void setGenereLibro(String genereLibro) {
        this.genereLibro = genereLibro;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getCopertina() {
        return copertina;
    }

    public void setCopertina(String copertina) {
        this.copertina = copertina;
    }


    @Override
    public String toString() {
        return "Libro{" +
                "ISBN=" + ISBN +
                ", titoloLibro='" + titoloLibro + '\'' +
                ", trama='" + trama + '\'' +
                ", genereLibro='" + genereLibro + '\'' +
                ", autore='" + autore + '\'' +
                ", copertina='" + copertina + '\'' +
                '}';
    }
}
