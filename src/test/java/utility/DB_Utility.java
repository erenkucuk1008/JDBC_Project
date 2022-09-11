package utility;

import java.sql.*;

public class DB_Utility {

    private static Connection con;
    private static Statement stm;
    private static ResultSet rs;

    public static void createConnection() {

        String url = ConfigurationReader.getProperty("hr.database.url");
        String username = ConfigurationReader.getProperty("hr.database.username");
        String password = ConfigurationReader.getProperty("hr.database.password");

        try {
            con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection was successfull");
        }catch (SQLException e){
            System.out.println("Connection has failed "+ e.getMessage());
        }
    }

    public static void createConnection(String url, String username, String password){
        try {
            con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection was successfull");
        }catch (SQLException e){
            System.out.println("Connection has failed "+ e.getMessage());
        }
    }

    public static ResultSet runQuery(String sql){

        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException e){
            System.out.println("Error Occured While Running Query "+e.getMessage());
        }

        return rs;
    }
}
