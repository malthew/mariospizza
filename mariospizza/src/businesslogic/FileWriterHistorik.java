
package businesslogic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author allan malthe og casper(aske)
 */
public class FileWriterHistorik {
    
    ArrayList<Bestilling> historik = new ArrayList();

    public FileWriterHistorik() {
    }
    
    public void addOrdreTilHistorik(Bestilling bestilling) {
        historik.add(bestilling);        
    }
    
    public ArrayList<Bestilling> seHistorik() {
        return historik;
    }
    
    public void skrivHistorik(int[] statistikPizza, int omsætning) {
        try {
            File historikLog = new File("Historik.txt");
            java.io.FileWriter filewriter = new java.io.FileWriter(historikLog);
            BufferedWriter buf = new BufferedWriter(filewriter);
            for (int i = 0; i < historik.size(); i++) {
                buf.write(historik.get(i).toString());
                buf.newLine();
            }
            StringBuilder sb = new StringBuilder();
        for(int i = 0; i < statistikPizza.length; i++){
                sb.append(" -Pizza Nr. " + (i+1) + ": "+ statistikPizza[i] + "\n");
        }
            buf.write("samlet pizza køb: ");
            buf.newLine();
            buf.write(sb.toString());
            buf.write("Omsætning for for listen " + omsætning);
            buf.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            
        }
    }
    
}
