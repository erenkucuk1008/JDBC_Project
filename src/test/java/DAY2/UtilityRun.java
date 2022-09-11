package DAY2;

import utility.ConfigurationReader;
import utility.DB_Utility;

public class UtilityRun {

    public static void main(String[] args) {

        DB_Utility.createConnection();


        String url = ConfigurationReader.getProperty("bookit.database.url");
        String username = ConfigurationReader.getProperty("bookit.database.username");
        String password = ConfigurationReader.getProperty("bookit.database.password");

        DB_Utility.createConnection(url, username, password);
    }
}
