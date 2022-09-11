package DAY1;

import utility.ConfigurationReader;

import java.sql.*;

public class ConnectionByPropertiesFile {

    public static void main(String[] args) throws SQLException {

        String url = ConfigurationReader.getProperty("hr.database.url");
        String username = ConfigurationReader.getProperty("hr.database.username");
        String password = ConfigurationReader.getProperty("hr.database.password");

        Connection con = DriverManager.getConnection(url, username, password);
        Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stm.executeQuery("SELECT * FROM EMPLOYEES");

        rs.next();
        System.out.println("rs.getString(2) = " + rs.getString(2));
    }
}
