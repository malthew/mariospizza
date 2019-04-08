/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author allan
 */
public class DatabaseConnection {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws Exception{
        
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
        while (result.next()){
            int resultat = result.getInt(1);
            System.out.println(resultat);
        }
    
}
}

