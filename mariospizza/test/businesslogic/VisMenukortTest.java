package businesslogic;

import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import presentation.FakeUI;

// @Author: Allan, Aske, Casper T. og Malthe


public class VisMenukortTest {
 
    @Test
    public void testVisMenukort() {
        // Arrange:
        ArrayList<Pizza> menukort = new ArrayList();
        menukort.add(new Pizza(1, "Vesuvio", 55.0));
        menukort.add(new Pizza(2, "Amerikaner", 59.0));
        menukort.add(new Pizza(3, "Meat Lover", 65.0));
        menukort.add(new Pizza(4, "Hawaii", 10.0));
        menukort.add(new Pizza(5, "Cacciatore", 57.0));
        String[] input = {""}; // test input data
        FakeUI ui = new FakeUI(input);
        Controller ctrl = new Controller(ui, menukort);   
         
        // Act:
        ctrl.visMenukort();
         
        // Assert:
        assertTrue(ui.output.get(0).contains("Vesuvio"));

    }
}
