package Model;

public class Community {
    private int idCommunity;
    private String titoloCommunity;
    private String descrizioneCommunity;
    private String immagineCommunity;

    public Community() {
    }

    public Community(int idCommunity, String titoloCommunity, String descrizioneCommunity, String immagineCommunity) {
        this.idCommunity = idCommunity;
        this.titoloCommunity = titoloCommunity;
        this.descrizioneCommunity = descrizioneCommunity;
        this.immagineCommunity = immagineCommunity;
    }


    public int getIdCommunity() {
        return idCommunity;
    }

    public void setIdCommunity(int idCommunity) {
        this.idCommunity = idCommunity;
    }

    public String getTitoloCommunity() {
        return titoloCommunity;
    }

    public void setTitoloCommunity(String titoloCommunity) {
        this.titoloCommunity = titoloCommunity;
    }

    public String getDescrizioneCommunity() {
        return descrizioneCommunity;
    }

    public void setDescrizioneCommunity(String descrizioneCommunity) {
        this.descrizioneCommunity = descrizioneCommunity;
    }

    public String getImmagineCommunity() {
        return immagineCommunity;
    }

    public void setImmagineCommunity(String immagineCommunity) {
        this.immagineCommunity = immagineCommunity;
    }

    @Override
    public String toString() {
        return "Community{" +
                "idCommunity=" + idCommunity +
                ", titoloCommunity='" + titoloCommunity + '\'' +
                ", descrizioneCommunity='" + descrizioneCommunity + '\'' +
                ", immagineCommunity='" + immagineCommunity + '\'' +
                '}';
    }
}
