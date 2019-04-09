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
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author allan
 */
public class DatabaseConnection {

     public static ArrayList<Pizza> getMenuKortFromDB() throws Exception{
        
        String user = "newuser";
        String password = "Aa12345678";
        String IP = "localhost";
        String PORT = "3306";
        String DATABASE = "mario";
        String serverTimezone = "serverTimezone=UTC";
        String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE + "?" +  serverTimezone;
        
        Connection connection =DriverManager.getConnection(url, user, password);
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
          public static void addToOrdre(Bestilling bestilling) throws Exception{
        
        String user = "newuser";
        String password = "Aa12345678";
        String IP = "localhost";
        String PORT = "3306";
        String DATABASE = "mario";
        String serverTimezone = "serverTimezone=UTC";
        String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE + "?" +  serverTimezone;
        
        Connection connection =DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
              System.out.println(LocalDate.now());
        statement.executeUpdate("INSERT INTO ordre(afhent, oprettet, cname, tlfno) VALUES ('" + LocalDate.now() + " " + bestilling.getAfhentningsTidspunkt() +":00" + "', '" + LocalDate.now() + "'," + "'" + bestilling.getCname() + "'," + bestilling.getTlfno() + ");");
        ResultSet result = statement.executeQuery("select count(ORDRENO) from ordre;");
        int nummer = 0;
         while (result.next()){
            nummer = result.getInt("count(ORDRENO)");
        }
         int[] bestillingsArray = bestilling.getPizzaNumre();
        for(int i = 0; i < bestillingsArray.length; i++){
            if(bestillingsArray[i] != 0){
                statement.executeUpdate("INSERT INTO antal VALUES(" + bestillingsArray[i] + ", " + nummer + ", " + i+1 + ");");
            }
        }
        }
}

