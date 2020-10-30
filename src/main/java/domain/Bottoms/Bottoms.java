package domain.Bottoms;

public class Bottoms {
    int id;
    String navn;
    double pris;

    public Bottoms(int id, String navn, double pris) {
        this.id = id;
        this.navn = navn;
        this.pris = pris;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    @Override
    public String toString() {
        return "Buttoms{" +
                "id=" + id +
                ", navn='" + navn + '\'' +
                ", pris=" + pris +
                '}';
    }
}
