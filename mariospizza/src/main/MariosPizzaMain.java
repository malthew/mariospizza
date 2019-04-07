package main;

import businesslogic.Controller;
import businesslogic.Pizza;
import java.util.ArrayList;
import presentation.SystemUI;
import presentation.UI;

// @Author: Allan, Aske, Casper T. og Malthe

public class MariosPizzaMain {
    public static void main(String[] args) {
        ArrayList<Pizza> menukort = new ArrayList();
        menukort.add(new Pizza(1, "Vesuvio", 57.0));
        menukort.add(new Pizza(2, "Amerikaner", 53.0));
        menukort.add(new Pizza(3, "Cacciatore", 57.0));
        menukort.add(new Pizza(4, "Carbona", 63.0));
        menukort.add(new Pizza(5, "Dennis", 65.0));
        menukort.add(new Pizza(6, "Bertil", 57.0));
        menukort.add(new Pizza(7, "Silvia", 61.0));
        menukort.add(new Pizza(8, "Victoria", 61.0));
        menukort.add(new Pizza(9, "Toronfo", 61.0));
        menukort.add(new Pizza(10, "Capricciosa", 61.0));
        menukort.add(new Pizza(11, "Hawai", 61.0));
        menukort.add(new Pizza(12, "Le Blissola", 61.0));
        menukort.add(new Pizza(13, "Venezia", 61.0));
        menukort.add(new Pizza(14, "Mafia", 61.0));
        
        Controller ctrl = new Controller(new SystemUI(), menukort);
        
        ctrl.start();
        
        
    }
}
