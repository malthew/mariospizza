/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import businesslogic.Bestilling;
import businesslogic.Pizza;
import java.util.ArrayList;

/**
 *
 * @author Allan, Aske, Casper og Malthe
 */
public class mockStorage implements StorageInterface{
    int ordreno = 1;
    ArrayList<Pizza> menukort = new ArrayList();
    public mockStorage() {
        menukort.add(new Pizza(1, "Vesuvio", 57.0));
        menukort.add(new Pizza(2, "Amerikaner", 53.0));
        menukort.add(new Pizza(3, "Cacciatore", 57.0));
        menukort.add(new Pizza(4, "Carbona", 53.0));
        menukort.add(new Pizza(5, "Dennis", 65.0));
        menukort.add(new Pizza(6, "Bertil", 57));
        menukort.add(new Pizza(7, "Silvia", 61));
        menukort.add(new Pizza(8, "Victoria", 61));
        menukort.add(new Pizza(9, "Toranfo", 61));
        menukort.add(new Pizza(10, "Capricciosa", 61));
        menukort.add(new Pizza(11, "Hawaii", 61));
        menukort.add(new Pizza(12, "Le Blissola", 61));
        menukort.add(new Pizza(13, "Venezia", 61));
        menukort.add(new Pizza(14, "Mafia", 61));
    }
    
    ArrayList<Bestilling> ordre = new ArrayList();
    
        
    @Override
    public ArrayList<Pizza> getMenukort() {
        return menukort;
    }

    @Override
    public void addToOrdre(Bestilling bestilling) {
        bestilling.setOrdreNummer(ordreno);
        ordre.add(bestilling);
        ordreno++;
    }

    @Override
    public ArrayList<Bestilling> getBestillinger() {
        return ordre;
    }

    @Override
    public void fjernBestilling(int ordreNummer) {
        for (int i=0; i< ordre.size(); i++){
            if(ordre.get(i).getOrdreNummer() == ordreNummer){
                ordre.remove(i);
            }
        }
    }

    @Override
    public int countOrders() {
        return ordre.size();
    }

    @Override
    public int countMenuKort() {
        return menukort.size();
    }

    @Override
    public int maxOrdreNummer() {
        int max=0;
        for (int i=0; i< ordre.size(); i++){
            if(ordre.get(i).getOrdreNummer() >= max){
                max=i;
            }
            
    }
    return max;
}

}