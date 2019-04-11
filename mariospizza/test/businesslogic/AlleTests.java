package businesslogic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import storage.mockStorage;

/**
 *
 * @author wosch
 */
public class AlleTests {
    @Test
    public void testStart() {
        
    }
    
    @Test
    public void testVisMenukort() {
        mockStorage storage = new mockStorage();
        
        assertTrue(storage.getMenukort().size()==14);
    }
    
    @Test
     public void opretBestillingEnPizza() {
         
     }
    
    @Test
    public void testVisBestillinger() {
        
    }
    
    @Test
    public void testFjernBestilling() {
        
    }
    
    @Test
     public void testHistorik() {
         
    }
    
    
}
