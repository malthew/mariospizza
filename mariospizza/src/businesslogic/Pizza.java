package businesslogic;

// @Author: Allan, Aske, Casper T. og Malthe

public class Pizza {
    private int pizzaNummer;
    private String pizzaNavn;
    private double pris;

    public Pizza(int pizzaNummer, String pizzaNavn, double pris) {
        this.pizzaNummer = pizzaNummer;
        this.pizzaNavn = pizzaNavn;
        this.pris = pris;
    }

    public int getPizzaNummer() {
        return pizzaNummer;
    }

    public String getPizzaNavn() {
        return pizzaNavn;
    }

    public double getPris() {
        return pris;
    }

    @Override
    public String toString() {
        return "Nr. " + pizzaNummer + ", Pizza: " + pizzaNavn + ", Pris: " + pris;
    }
    
    
    
}
