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
    
    public ArrayList<Pizza> getMenukort()throws Exception;
    public void addToOrdre(Bestilling bestilling)throws Exception;
    public ArrayList<Bestilling> getBestillinger()throws Exception;
    public void fjernBestilling(int ordreNummer)throws Exception;
    public int countOrders()throws Exception;
    public int maxOrdreNummer() throws Exception;
}
