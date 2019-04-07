package businesslogic;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import presentation.FakeUI;

// @Author: Allan, Aske, Casper T. og Malthe


public class OpretBestillingTest {
       
     @Test
     public void opretBestillingEnPizza() {
         
         // Arrange:
         ArrayList<Pizza> menukort = new ArrayList();
         menukort.add(new Pizza(1, "Vesuvio", 55.0));
         menukort.add(new Pizza(2, "Amerikaner", 59.0));
         menukort.add(new Pizza(3, "Meat Lover", 65.0));
         menukort.add(new Pizza(4, "Hawaii", 10.0));
         String[] input = {"2"}; // test input data
         FakeUI ui = new FakeUI(input);
         Controller ctrl = new Controller(ui, menukort);   
         
         // Act:
         ctrl.opretBestilling();
         
         // Assert:
         assertTrue(ui.output.get(2).contains("Amerikaner"));
         assertTrue(ctrl.getAktiveOrdrer().size()==1);
         assertEquals("Amerikaner", ctrl.getAktiveOrdrer().get(0).getPizza().getPizzaNavn());
     }
     
     @Test
     public void opretBestillingToPizzaer() {
         
         // Arrange:
         ArrayList<Pizza> menukort = new ArrayList();
         menukort.add(new Pizza(1, "Vesuvio", 55.0));
         menukort.add(new Pizza(2, "Amerikaner", 59.0));
         menukort.add(new Pizza(3, "Meat Lover", 65.0));
         menukort.add(new Pizza(4, "Hawaii", 10.0));
         String[] input = {"2", "3"}; // test input data
         FakeUI ui = new FakeUI(input);
         Controller ctrl = new Controller(ui, menukort);   
         
         // Act:
         ctrl.opretBestilling();
         ctrl.opretBestilling();
         
         // Assert:
         assertEquals("1", ui.output.get(1));
         assertTrue(ctrl.getAktiveOrdrer().size()==2);
         assertEquals("Amerikaner", ctrl.getAktiveOrdrer().get(0).getPizza().getPizzaNavn());
         assertEquals("Meat Lover", ctrl.getAktiveOrdrer().get(1).getPizza().getPizzaNavn());
     }
     
}
