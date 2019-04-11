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
    private FileWriterHistorik fileWriter;


    public Controller(UI ui, StorageInterface storage, FileWriterHistorik fileWriter) {
        this.ui = ui;
        this.storage = storage;
        this.fileWriter = fileWriter;
    }
      
    
    public void start() {
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

    public void opretBestilling() {
        int[] pizzaNummer = ui.vælgPizza(storage.countMenuKort());
        String afhentning = ui.vælgTidspunkt();
        String navn = ui.vælgNavn();
        String tlfno = ui.vælgTlfno();
        
        Bestilling bestilling = new Bestilling(pizzaNummer, 0, afhentning, navn, tlfno);
        
        storage.addToOrdre(bestilling);
        
        bestilling.setOrdreNummer(storage.maxOrdreNummer());
        ui.visPizzaValg(bestilling.toString());
        
    }
    
    public void visMenukort(){
        ui.visMenukort(storage.getMenukort());
    }   

    private void visBestillinger() {
        
        ui.visBestillinger(storage.getBestillinger(), false);
    }

    private void fjernBestilling() {
        ui.visBestillinger(storage.getBestillinger(), true);
        int x = ui.fjernBestilling(storage.countOrders());
        fileWriter.addOrdreTilHistorik(storage.getBestillinger().get(x-1));
        if(x != -1) {
           storage.fjernBestilling(storage.getBestillinger().get(x-1).getOrdreNummer());
        }
        
    }
    
    private void seHistorik() {
        ui.seHistorik(fileWriter.seHistorik()); 
        
        
    }
    
   
}
