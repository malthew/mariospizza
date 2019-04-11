package presentation;

import businesslogic.Bestilling;
import java.util.Scanner;
import businesslogic.Pizza;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.IntStream;

// @Author: Allan, Aske, Casper T. og Malthe

public class SystemUI implements UI{
    
    Scanner scan = new Scanner(System.in);

    @Override
    public int[] vælgPizza(int menuKortLength) {
        System.out.println("Skriv Pizzanummer for at tilføje den til ordren, for at færdiggøre skriv '-1':");
        int[] bestillingsArray = new int[menuKortLength];
        boolean inputformat = false;
        int input = 0;
        while(!inputformat) {
            try{
                input = Integer.parseInt(scan.nextLine());
                if (input>=1 && input<=menuKortLength
                        ) {
                    bestillingsArray[input-1]++;
                    System.out.println("Tilføj Flere pizzaer eller afslut med '-1':");
                }else if(input == -1 && Arrays.stream(bestillingsArray).sum() != 0) {
                    inputformat = true;
                }
                else{
                    throw new IllegalArgumentException();

                }
            }catch(Exception e) {
                System.out.println("Ugyldigt input, prøv igen:");
            }
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
        System.out.println("For at retunere til Hovedmenu indtast '-1':");
            boolean inputFormat = false;
            while(!inputFormat){
                String input = scan.nextLine();
                if(input.equals("-1")) {
                    inputFormat = true;
                }
                else{
                    System.out.println("Ugyldigt input, prøv igen:");
                }
                
            } 
        System.out.println("-----------------------------------------------");
        flushConsole();
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
    public void visBestillinger(ArrayList<Bestilling> aktiveOrdrer, boolean bypassRS) {
        int i = 1;
        if (aktiveOrdrer.size()>0) {
            for(Bestilling bestilling:aktiveOrdrer) {
                System.out.println("" + i++ + ". " + bestilling.toString());
                
            }
            if (!bypassRS) {          
            
            System.out.println("-----------------------------------------------");
            System.out.println("For at retunere til Hovedmenu indtast '-1':");
            boolean inputFormat = false;
            while(!inputFormat){
                String input = scan.nextLine();
                if(input.equals("-1")) {
                    inputFormat = true;
                }
                else
                    System.out.println("Ugyldigt input, prøv igen:");
            }
            System.out.println("-----------------------------------------------");
            flushConsole();
            }
      }
        else {
            System.out.println("[Ingen aktive bestillinger]");
            flushConsole();
        }
    }

    @Override
    public int fjernBestilling(int arraySize) {
        System.out.println("Fjern en bestilling:\nSkriv tallet til ventre for ordren for at fjerne den.\nskriv '-1' for returnere til hovedmenuen:");
        int returnStatement = 0;
        boolean inputFormat = false;
        while(!inputFormat) {
            try{
                returnStatement = Integer.parseInt(scan.nextLine());
                if(returnStatement >= 0 && returnStatement <= arraySize) {
                    inputFormat = true;
                }
                else if(returnStatement == -1) {
                    inputFormat = true;
                }
                else{
                    throw new IndexOutOfBoundsException();
                }
            }catch(Exception e) {
                System.out.println("Ugyldigt input, prøv igen:");
            }
        }
        flushConsole();
        return returnStatement;
    }

    @Override
    public void seHistorik(ArrayList<Bestilling> historik) {
        for(Bestilling bestilling : historik) {
            
            System.out.println(bestilling.toString());
        }
        System.out.println("-----------------------------------------------");
        System.out.println("For at retunere til Hovedmenu indtast '-1':");
            boolean inputFormat = false;
            while(!inputFormat){
                String input = scan.nextLine();
                if(input.equals("-1")) {
                    inputFormat = true;
                }
                else{
                    System.out.println("Ugyldigt input, prøv igen:");
                }
                
            } 
        System.out.println("-----------------------------------------------");
        flushConsole();
    }

    @Override
    public void notAnOption() {
        System.out.println("Forkert input :-(");
        System.out.println("-----------------------------------------------");
    }



    @Override
    public String vælgTidspunkt() {
        System.out.println("Skriv kundens afhentningstidspunkt: FORMAT(HH:MM)");
        String input = "";
        boolean inputFormat = false;
        while(!inputFormat) {
            try{
                input = scan.nextLine();
                DateFormat sdf = new SimpleDateFormat("hh:mm");
                Date date = sdf.parse(input);
                LocalTime.parse(input);
                inputFormat = true;
            }catch(Exception e) {
                System.out.println("Ugyldigt input, prøv igen:");
            }
        }
        return input;
    }

    @Override
    public String vælgNavn() {
        System.out.println("Skriv kundens navn:");
        String input = scan.nextLine();
        while(input.length() == 0) {
            System.out.println("Tomt input skriv kundens navn:");
            input = scan.nextLine();
        }
        return input;
    }

    @Override
    public String vælgTlfno() {
        System.out.println("Skriv kundens telefonnummer(minimum 1 cifre, max 8):");
       
        boolean inputformat = false;
        String input = "";
        
        while(!inputformat) {
            try{
                input = scan.nextLine();
                Integer.parseInt(input);
                if (input.length()>=1 && input.length()<=8) {
                    inputformat = true;
                }else{
                    throw new IllegalArgumentException();

                }
            }catch(Exception e) {
                System.out.println("Ugyldigt input, prøv igen:");
            }
        }
        flushConsole();
        return input;
    }
    
    private void flushConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

}
