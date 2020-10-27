package domain;

public class Toppings {
    int id;
    String navn;
    double pris;

    public Toppings(int id, String navn, double pris) {
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
        return "Toppings{" +
                "id=" + id +
                ", navn='" + navn + '\'' +
                ", pris=" + pris +
                '}';
    }
}