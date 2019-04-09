package presentation;

import businesslogic.Bestilling;
import java.util.ArrayList;
import businesslogic.Pizza;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// @Author: Allan, Aske, Casper T. og Malthe

public class FakeUI implements UI {

    private String[] input;
    private int index = 0;
    public ArrayList<String> output = new ArrayList<>();

    public FakeUI(String[] input) {
        this.input = input;
    }

    @Override
    public int[] vælgPizza() {
        output.add("Skriv hvilket pizzanummer kunden har bestilt");
       //return Integer.parseInt(input[index++]);
       return null;
    }

    @Override
    public void visPizzaValg(String str) {
        output.add(str);    
    }

    @Override
    public void visOrdrenummer(int ordrenummer) {
        
        output.add(""+ordrenummer);
    }

    @Override
    public void visMenukort(ArrayList<Pizza> menukort) {
        for(Pizza pizza:menukort) {
            
            output.add(pizza.toString());
        }
    }

    @Override
    public void visHovedmenu() {
        output.add("Vælg en af følgende muligheder:");
        output.add("1. Vis Menukort");
        output.add("2. Opret bestilling");
        output.add("3. Vis bestillinger");
        output.add("4. Fjern bestilling");
        output.add("5. Se historik");
        output.add("9. Afslut programmet");                
                
    }

    @Override
    public String hovedmenuValg() {
        
        return (input[index++]);
    }

    @Override
    public void visBestillinger(ArrayList<Bestilling> aktiveOrdrer, boolean bypassRS) {
        int i = 1;
        for(Bestilling bestilling:aktiveOrdrer) {
            output.add("" + i++ + ". " + bestilling.toString());          
            
        }
        
    }

    @Override
    public int fjernBestilling(int arraySize) {
        output.add("Fjern en bestilling:");
        return Integer.parseInt(input[index++]);
    }

    @Override
    public void seHistorik(ArrayList<Bestilling> historik) {
        int i = 1;
        for(Bestilling bestilling:historik) {
            output.add("" + i++ + ". " + bestilling.toString());
    }
    }

    @Override
    public void notAnOption() {
        output.add("Forkert input.");
    }

    @Override
    public void skrivHistorik(ArrayList<Bestilling> historik) {
        
        try {
            File historikLog = new File("Historik.txt");
            FileWriter filewriter = new FileWriter(historikLog);
            BufferedWriter buf = new BufferedWriter(filewriter);
            for (int i = 0; i < historik.size(); i++) {
            buf.write(historik.get(i).toString());
            buf.newLine();
            }
            buf.flush();
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }

    @Override
    public String vælgTidspunkt() {
        return "Tidspunkt";
    }

    @Override
    public String vælgNavn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vælgTlfno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
