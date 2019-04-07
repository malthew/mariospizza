
package businesslogic;

// @Author: Allan, Aske, Casper T. og Malthe

public class Bestilling {
    private Pizza pizza;
    private int ordreNummer;
    private String afhentningsTidspunkt;

    public Bestilling(Pizza pizza, int ordreNummer, String afhentningsTidspunkt) {
        this.pizza = pizza;        
        this.ordreNummer = ordreNummer;
        this.afhentningsTidspunkt = afhentningsTidspunkt;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public int getOrdreNummer() {
        return ordreNummer;
    }

    @Override
    public String toString() {
        return "Bestilling: " + pizza + ", Ordrenummer: " + ordreNummer + ", Afhentes: " + afhentningsTidspunkt;
    }
    
}
