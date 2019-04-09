package businesslogic;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import presentation.FakeUI;

// @Author: Allan, Aske, Casper T. og Malthe

public class VisBestillingerTest {
    
    @Test
    public void testVisBestillinger() {
        // Arrange:
        ArrayList<Pizza> menukort = new ArrayList();
        menukort.add(new Pizza(1, "Vesuvio", 55.0));
        menukort.add(new Pizza(2, "Amerikaner", 59.0));
        menukort.add(new Pizza(3, "Meat Lover", 65.0));
        menukort.add(new Pizza(4, "Hawaii", 10.0));
        menukort.add(new Pizza(5, "Cacciatore", 57.0));
        String[] input = {"2", "3", "2", "1", "3", "9"}; // test input data
        FakeUI ui = new FakeUI(input);
        Controller ctrl = new Controller(ui, menukort);   
         
        // Act:
        ctrl.start();
         
        // Assert:
        //assertEquals("Meat Lover", ctrl.getAktiveOrdrer().get(0).getPizza().getPizzaNavn());
        //assertEquals("Vesuvio", ctrl.getAktiveOrdrer().get(1).getPizza().getPizzaNavn());

    }
    
    @Test
    public void testFjernBestilling() {
        // Arrange:
        ArrayList<Pizza> menukort = new ArrayList();
        menukort.add(new Pizza(1, "Vesuvio", 55.0));
        menukort.add(new Pizza(2, "Amerikaner", 59.0));
        menukort.add(new Pizza(3, "Meat Lover", 65.0));
        menukort.add(new Pizza(4, "Hawaii", 10.0));
        menukort.add(new Pizza(5, "Cacciatore", 57.0));
        String[] input = {"2", "3", "2", "1", "3", "9", "4", "1", "9"}; // test input data
        FakeUI ui = new FakeUI(input);
        Controller ctrl = new Controller(ui, menukort);   
         
        // Act:
        ctrl.start();
        
         
        // Assert:
        //assertEquals("Meat Lover", ctrl.getAktiveOrdrer().get(0).getPizza().getPizzaNavn());
        //assertEquals("Vesuvio", ctrl.getAktiveOrdrer().get(1).getPizza().getPizzaNavn());
        
        ctrl.start();
        
        assertTrue(ctrl.getAktiveOrdrer().size()==1);
    }
    
     @Test
     public void testHistorik() {
        // Arrange:
        ArrayList<Pizza> menukort = new ArrayList();
        menukort.add(new Pizza(1, "Vesuvio", 55.0));
        menukort.add(new Pizza(2, "Amerikaner", 59.0));
        menukort.add(new Pizza(3, "Meat Lover", 65.0));
        menukort.add(new Pizza(4, "Hawaii", 10.0));
        menukort.add(new Pizza(5, "Cacciatore", 57.0));
        String[] input = {"2", "3", "2", "1", "3", "9", "4", "1", "9"}; // test input data
        FakeUI ui = new FakeUI(input);
        Controller ctrl = new Controller(ui, menukort);   
         
        // Act:
        ctrl.start();
        
         
        // Assert:
        //assertTrue(ui.output.get(13).contains("Meat"));
        //assertEquals("Meat Lover", ctrl.getAktiveOrdrer().get(0).getPizza().getPizzaNavn());
        // Vesuvio er fjernet pga. input data (67) hvilket får testen til at fejle.
        //assertEquals("Vesuvio", ctrl.getAktiveOrdrer().get(1).getPizza().getPizzaNavn());
        
        ctrl.start();
        
        assertTrue(ctrl.getHistorik().size()==1);
        
        
    }
}
