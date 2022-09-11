package DAY2;

import utility.ConfigurationReader;
import utility.DB_Utility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilityRun {

    public static void main(String[] args) throws SQLException {

        DB_Utility.createConnection();


        String url = ConfigurationReader.getProperty("hr.database.url");
        String username = ConfigurationReader.getProperty("hr.database.username");
        String password = ConfigurationReader.getProperty("hr.database.password");

        DB_Utility.createConnection(url, username, password);

        ResultSet result = DB_Utility.runQuery("SELECT * FROM REGIONS");
        result.next();
        System.out.println("REGION_NAME= " + result.getString("REGION_NAME"));

    }
}
