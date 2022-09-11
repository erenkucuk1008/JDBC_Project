package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Utility {

    public static void createConnection() {

        String url = ConfigurationReader.getProperty("hr.database.url");
        String username = ConfigurationReader.getProperty("hr.database.username");
        String password = ConfigurationReader.getProperty("hr.database.password");

        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection was successfull");
        }catch (SQLException e){
            System.out.println("Connection has failed "+ e.getMessage());
        }
    }

    public static void createConnection(String url, String username, String password){
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection was successfull");
        }catch (SQLException e){
            System.out.println("Connection has failed "+ e.getMessage());
        }
    }
}
