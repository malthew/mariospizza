package businesslogic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presentation.FakeUI;
import storage.mockStorage;

/**
 *
 * @author wosch
 */
public class AlleTests {
    @Test
    public void testStart() {
        String[] input = {"9"}; 
        FakeUI ui = new FakeUI(input);
        Controller ctrl = new Controller(ui, new mockStorage(), new FileWriterHistorik());
        ctrl.start();
        assertTrue(ui.output.get(0).contains("muligheder"));
    }
    
    @Test
    public void testVisMenukort() {
        mockStorage storage = new mockStorage();
        
        assertTrue(storage.getMenukort().size()==14);
    }
    
    @Test
     public void opretBestillingEnPizza()  {
        mockStorage storage = new mockStorage();
        int[] pizza = {1};
        storage.addToOrdre(new Bestilling(pizza,0,"20:20","allan","123"));
        
        assertTrue(storage.getBestillinger().size()==1);
    }
    @Test
    public void testVisBestillinger() {
        mockStorage storage = new mockStorage();
        int[] pizza = {1};
        storage.addToOrdre(new Bestilling(pizza,0,"20:20","allan","123"));
        
        assertTrue(storage.getBestillinger().get(0).getAfhentningsTidspunkt().equals("20:20"));
    }
    
    @Test
    public void testFjernBestilling() {
        mockStorage storage = new mockStorage();
        int[] pizza = {1};
        storage.addToOrdre(new Bestilling(pizza,0,"20:20","allan","123"));
        
        assertTrue(storage.getBestillinger().size()==1);
        
        storage.fjernBestilling(1);
        
        assertTrue(storage.getBestillinger().size()==0);

    }
    
}
