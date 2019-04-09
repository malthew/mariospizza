package businesslogic;

import java.util.ArrayList;
import java.util.Arrays;
import presentation.UI;
import storage.DatabaseConnection;
import storage.StorageInterface;

// @Author: Allan, Aske, Casper T. og Malthe

public class Controller {
    
    private UI ui;
    private StorageInterface storage;


    public Controller(UI ui, StorageInterface storage) {
        this.ui = ui;
        this.storage = storage;
    }
      
    
    public void start() throws Exception {
        boolean quit = false;
        do{
            ui.visHovedmenu();
            String brugerinput = ui.hovedmenuValg();
            switch(brugerinput) {
                case "1":
                    visMenukort();
                    break;
                case "2":
                    opretBestilling();
                    break;
                case "3":
                    visBestillinger();
                    break;
                case "4":
                    if (storage.countOrders()>0) {
                        fjernBestilling();
                    } else {
                        System.out.println("[Ingen aktive bestillinger]");
                        break;
                    }                    
                    break;
                case "5":
                    seHistorik();
                    break;
                case "9":
                    //ui.skrivHistorik(historik);
                    quit = true;
                    break;
                default:
                    ui.notAnOption();
                
            }
            
        } while(!quit);

    }

    public void opretBestilling() throws Exception {
        // indlæs pizzanummer
        int[] pizzaNummer = ui.vælgPizza();
        System.out.println(Arrays.toString(pizzaNummer));
        // opret bestilling
        String afhentning = ui.vælgTidspunkt();
        String navn = ui.vælgNavn();
        String tlfno = ui.vælgTlfno();
        Bestilling bestilling = new Bestilling(pizzaNummer, 0, afhentning, navn, tlfno);
        // Tilføj bestilling til ordreliste
        try{
        storage.addToOrdre(bestilling);
        }catch(Exception e){
            System.out.println("SQL DUTTER IKKE");
            System.out.println(e.getMessage());
        }
        // viser ordrenummer på skærm
        ui.visOrdrenummer(storage.maxOrdreNummer());
        // vis pizzavalg på skærm
        bestilling.setOrdreNummer(storage.maxOrdreNummer());
        ui.visPizzaValg(bestilling.toString());
        // tæller ordre nummer op én gang
        
    }
    
    public void visMenukort() throws Exception{
        ui.visMenukort(storage.getMenukort());
    }   

    private void visBestillinger() throws Exception {
        
        ui.visBestillinger(storage.getBestillinger(), false);
    }

    private void fjernBestilling() throws Exception {
        ui.visBestillinger(storage.getBestillinger(), true);
        int x = ui.fjernBestilling(storage.countOrders());
        //TODO: FIX HISTORIK - historik.add(aktiveOrdrer.get(x-1));
        if(x != -1) {
           storage.fjernBestilling(storage.getBestillinger().get(x-1).getOrdreNummer());
        }
        
    }

    private void seHistorik() {
        //ui.seHistorik(historik);
        
    }
    
   
}
