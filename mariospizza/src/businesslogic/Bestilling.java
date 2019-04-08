
package businesslogic;

// @Author: Allan, Aske, Casper T. og Malthe

public class Bestilling {
    private Pizza pizza;
    private int ordreNummer;
    private String afhentningsTidspunkt;
    private String cname;
    private String tlfno;

    public Bestilling(Pizza pizza, int ordreNummer, String afhentningsTidspunkt, String cname, String tlfno) {
        this.pizza = pizza;        
        this.ordreNummer = ordreNummer;
        this.afhentningsTidspunkt = afhentningsTidspunkt;
        this.cname = cname;
        this.tlfno = tlfno;
    }

    public Pizza getPizza() {
        return pizza;
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
        return "Bestilling: " + pizza + ", Ordrenummer: " + ordreNummer + ", Afhentes: " + afhentningsTidspunkt;
    }
    
}
