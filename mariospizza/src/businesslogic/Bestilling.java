
package businesslogic;

// @Author: Allan, Aske, Casper T. og Malthe

public class Bestilling {
    private int[] pizzaNumre;
    private int ordreNummer;
    private String afhentningsTidspunkt;
    private String cname;
    private String tlfno;

    public Bestilling(int[] pizzaNumre, int ordreNummer, String afhentningsTidspunkt, String cname, String tlfno) {
        this.pizzaNumre = pizzaNumre;        
        this.ordreNummer = ordreNummer;
        this.afhentningsTidspunkt = afhentningsTidspunkt;
        this.cname = cname;
        this.tlfno = tlfno;
    }

    public int[] getPizzaNumre() {
        return pizzaNumre;
    }

    public int getOrdreNummer() {
        return ordreNummer;
    }

    public String getAfhentningsTidspunkt() {
        return afhentningsTidspunkt;
    }

    public String getCname() {
        return cname;
    }

    public String getTlfno() {
        return tlfno;
    }
    
    @Override
    public String toString() {
        return "Bestilling: " + ", Ordrenummer: " + ordreNummer + ", Afhentes: " + afhentningsTidspunkt;
    }
    
}
