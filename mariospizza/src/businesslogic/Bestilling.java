
package businesslogic;

// @Author: Allan, Aske, Casper T. og Malthe

import java.util.Arrays;


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

    public void setOrdreNummer(int ordreNummer) {
        this.ordreNummer = ordreNummer;
    }

    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < pizzaNumre.length; i++){
            if(pizzaNumre[i] > 0){
                sb.append(" -Pizza Nr. " + (i+1) + ": "+ pizzaNumre[i] + " stk. \n");
            }
        }
        return "BESTILLING: | " + "Ordrenummer: " + ordreNummer + "| Afhentes: " + afhentningsTidspunkt + " | Kundens navn: " + cname + " | Tlf.: " + tlfno + "\n" + sb.toString();
    }
    
    
    
}
