package businesslogic;

import java.util.ArrayList;
import java.util.Arrays;
import presentation.UI;
import storage.DatabaseConnection;

// @Author: Allan, Aske, Casper T. og Malthe

public class Controller {
    
    private UI ui;
    private ArrayList<Pizza> menukort;
    private ArrayList<Bestilling> aktiveOrdrer;
    private ArrayList<Bestilling> historik;
    private int currentOrderNr;

    public Controller(UI ui, ArrayList<Pizza> menukort) {
        this.ui = ui;
        this.menukort = menukort;
        aktiveOrdrer = new ArrayList<Bestilling>();
        historik = new ArrayList<>();
        currentOrderNr = 1;
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
                    if (aktiveOrdrer.size()>0) {
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
                    ui.skrivHistorik(historik);
                    quit = true;
                    break;
                default:
                    ui.notAnOption();
                
            }
            
        } while(!quit);

    }

    public void opretBestilling() {
        // indlæs pizzanummer
        int[] pizzaNummer = ui.vælgPizza();
        System.out.println(Arrays.toString(pizzaNummer));
        // opret bestilling
        String afhentning = ui.vælgTidspunkt();
        String navn = ui.vælgNavn();
        String tlfno = ui.vælgTlfno();
        Bestilling bestilling = new Bestilling(pizzaNummer, currentOrderNr, afhentning, navn, tlfno);
        // Tilføj bestilling til ordreliste
        aktiveOrdrer.add(bestilling);
        try{
        DatabaseConnection.addToOrdre(bestilling);
        }catch(Exception e){
            System.out.println("SQL DUTTER IKKE");
            System.out.println(e.getMessage());
        }
        // viser ordrenummer på skærm
        ui.visOrdrenummer(currentOrderNr);
        // vis pizzavalg på skærm
        ui.visPizzaValg(bestilling.toString());
        // tæller ordre nummer op én gang
        currentOrderNr++;
        
    }
    
    

    public ArrayList<Bestilling> getAktiveOrdrer() {
        return aktiveOrdrer;
    }

    public ArrayList<Bestilling> getHistorik() {
        return historik;
    }

    public void visMenukort() {
        ui.visMenukort(menukort);
    }   

    private void visBestillinger() throws Exception {
        
        ui.visBestillinger(DatabaseConnection.visBestillinger());
    }

    private void fjernBestilling() {
        ui.visBestillinger(aktiveOrdrer);
        int x = ui.fjernBestilling(aktiveOrdrer.size());
        historik.add(aktiveOrdrer.get(x-1));
        aktiveOrdrer.remove(x-1);
    }

    private void seHistorik() {
        ui.seHistorik(historik);
        
    }
    
   
}
