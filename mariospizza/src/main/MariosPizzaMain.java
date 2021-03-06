package main;

import businesslogic.Controller;
import businesslogic.FileWriterHistorik;
import businesslogic.Pizza;
import java.util.ArrayList;
import presentation.SystemUI;
import presentation.UI;
import storage.DatabaseConnection;

// @Author: Allan, Aske, Casper T. og Malthe

public class MariosPizzaMain {
    public static void main(String[] args) {
        
        Controller ctrl = new Controller(new SystemUI(), new DatabaseConnection(), new FileWriterHistorik());
        
        System.out.println("");
        System.out.println("##################################");
        System.out.println("##########MARIOS PIZZABAR#########");
        System.out.println("##################################");
        System.out.println("");
        
        ctrl.start();
        
        
    }
}
