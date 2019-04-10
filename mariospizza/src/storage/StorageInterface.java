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
 * @author allan
 */
public interface StorageInterface {
    
    public ArrayList<Pizza> getMenukort();
    public void addToOrdre(Bestilling bestilling);
    public ArrayList<Bestilling> getBestillinger();
    public void fjernBestilling(int ordreNummer);
    public int countOrders();
    public int countMenuKort();
    public int maxOrdreNummer();
}
