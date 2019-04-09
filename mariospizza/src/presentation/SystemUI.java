package presentation;

import businesslogic.Bestilling;
import java.util.Scanner;
import businesslogic.Pizza;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// @Author: Allan, Aske, Casper T. og Malthe

public class SystemUI implements UI{
    
    Scanner scan = new Scanner(System.in);

    @Override
    public int[] vælgPizza() {
        System.out.println("Skriv hvilket pizzanummer kunden har bestilt:");
        int[] bestillingsArray = new int[14];
        
        int input = Integer.parseInt(scan.nextLine());
        
        while(input != -1){
            if (input>=1 && input<=14) {
                bestillingsArray[input-1]++;
                System.out.println("Skriv hvilket pizzanummer kunden har bestilt:");
            } else{
                System.out.println("Ikke en mulighed, prøv igen:");
                
            }
            input = Integer.parseInt(scan.nextLine());
        }
        return bestillingsArray;
    }

    @Override
    public void visPizzaValg(String string) {
        System.out.println(string);
        System.out.println("-----------------------------------------------");
    }

    @Override
    public void visOrdrenummer(int ordrenummer) {
        System.out.println("Ordrenummer: " + ordrenummer);
    }

    @Override
    public void visMenukort(ArrayList<Pizza> menukort) {
        for(Pizza pizza:menukort) {
            
            System.out.println(pizza.toString());
        }
        System.out.println("-----------------------------------------------");
    }

    @Override
    public void visHovedmenu() {
        System.out.println("Vælg en af følgende muligheder:");
        System.out.println("1. Vis Menukort");
        System.out.println("2. Opret bestilling");
        System.out.println("3. Vis bestillinger");
        System.out.println("4. Fjern bestilling");
        System.out.println("5. Se historik");
        System.out.println("9. Afslut programmet");
    }

    @Override
    public String hovedmenuValg() {
        return scan.nextLine();
    }

    @Override
    public void visBestillinger(ArrayList<Bestilling> aktiveOrdrer) {
        int i = 1;
        if (aktiveOrdrer.size()>0) {
            for(Bestilling bestilling:aktiveOrdrer) {
                System.out.println("" + i++ + ". " + bestilling.toString());
                
            }
        }
        else
            System.out.println("[Ingen aktive bestillinger]");
        
        System.out.println("-----------------------------------------------");
    }

    @Override
    public int fjernBestilling(int arraySize) {
        System.out.println("Fjern en bestilling:");
        int returnStatement = 0;
        boolean inputFormat = false;
        while(!inputFormat) {
            try{
                returnStatement = Integer.parseInt(scan.nextLine());
                if(returnStatement >= 0 && returnStatement <= arraySize) {
                    inputFormat = true;
                }else{
                    throw new IndexOutOfBoundsException();
                }
            }catch(Exception e) {
                System.out.println("Ugyldigt input, prøv igen:");
            }
        }
        return returnStatement;
    }

    @Override
    public void seHistorik(ArrayList<Bestilling> historik) {
        int i = 1;
        for(Bestilling bestilling:historik) {
            System.out.println("" + i++ + ". " + bestilling.toString());
         
    }
        System.out.println("-----------------------------------------------");
    }

    @Override
    public void notAnOption() {
        System.out.println("Forkert input :-(");
        System.out.println("-----------------------------------------------");
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
        System.out.println("Skriv kundens afhentningstidspunkt: FORMAT(HH:MM)");
        return scan.nextLine();
    }

    @Override
    public String vælgNavn() {
         System.out.println("Skriv kundens navn:");
        return scan.nextLine();
    }

    @Override
    public String vælgTlfno() {
        System.out.println("Skriv kundens telefonnummer:");
        return scan.nextLine();
    }

}
