/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import businesslogic.Bestilling;
import businesslogic.Pizza;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 *
 * @author allan
 */
public class DatabaseConnection implements StorageInterface {

    
    private Connection makeConnection() throws Exception {
        String user = "newuser";
        String password = "Aa12345678";
        String IP = "localhost";
        String PORT = "3306";
        String DATABASE = "mario";
        String serverTimezone = "serverTimezone=UTC";
        String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE + "?" +  serverTimezone;
        
            return DriverManager.getConnection(url, user, password);
        }
    
     public ArrayList<Pizza> getMenukort()  {
        
        try{
        Connection connection = makeConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM pizza");
        
        ArrayList<Pizza> returnArray = new ArrayList();
        
        while (result.next()){
            int nummer = result.getInt("pnummer");
            String navn = result.getString("pnavn");
            int pris = result.getInt("pris");
            returnArray.add(new Pizza(nummer, navn, pris));
        }
        return returnArray;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
}
          public void addToOrdre(Bestilling bestilling) {
        
        try{
        Connection connection = makeConnection();
        Statement statement = connection.createStatement();
              System.out.println(LocalDate.now());
        statement.executeUpdate("INSERT INTO ordre(afhent, oprettet, cname, tlfno) VALUES ('" + LocalDate.now() + " " + bestilling.getAfhentningsTidspunkt() +":00" + "', '" + LocalDate.now() + "'," + "'" + bestilling.getCname() + "'," + bestilling.getTlfno() + ");");
        ResultSet result = statement.executeQuery("SELECT MAX(ORDRENO) FROM ordre;");
        result.next();
        int nummer = result.getInt(1);
        
         int[] bestillingsArray = bestilling.getPizzaNumre();
        for(int i = 0; i < bestillingsArray.length; i++){
            if(bestillingsArray[i] != 0){
                statement.executeUpdate("INSERT INTO antal VALUES(" + bestillingsArray[i] + ", " + nummer + ", " + (i+1) + ");");
            }
        }
        
        }
        catch(Exception e){
            System.out.println(e.getMessage());
           
        }
          }
          public ArrayList<Bestilling> getBestillinger() {
          
        try{  
        
        Connection connection = makeConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM ordre");
        ArrayList<Bestilling> returnArray = new ArrayList();
        
        while (result.next()){
            int ordreNummer = result.getInt("ORDRENO");
            String cnavn = result.getString("CNAME");
            String tlfno = result.getString("TLFNO");
            String dato = result.getTimestamp("AFHENT").toString();
            
            Statement statement2 = connection.createStatement();
            ResultSet pizzaResults = statement2.executeQuery("SELECT * FROM antal WHERE ORDRENO =" + ordreNummer + ";");
            
            int[] pizzaNumre = new int[14];
            while(pizzaResults.next()){
                int pNummer = pizzaResults.getInt("PNUMMER");
                int antalP = pizzaResults.getInt("ANTALP");
                pizzaNumre[pNummer-1] = antalP;
            }
            returnArray.add(new Bestilling(pizzaNumre, ordreNummer, dato, cnavn, tlfno));
        }
        
        return returnArray;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        } 
          }
        

            public void fjernBestilling(int ordreNummer) {
            Connection connection = makeConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM antal WHERE ORDRENO = " + ordreNummer + ";");
            statement.executeUpdate("DELETE FROM ordre WHERE ORDRENO = " + ordreNummer + ";");

        }
        
        public int countOrders() {
            Connection connection = makeConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select count(ORDRENO) from ordre;");
            rs.next();
            return rs.getInt(1);
        }
        
        public int maxOrdreNummer() {
            Connection connection = makeConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT MAX(ORDRENO) FROM ordre;");
            result.next();
            return result.getInt(1);
           
        }

}

