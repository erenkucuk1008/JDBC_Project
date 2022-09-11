package DAY2;

import utility.ConfigurationReader;
import utility.DB_Utility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilityRun {

    public static void main(String[] args) throws SQLException {

        DB_Utility.createConnection();
        ResultSet result = DB_Utility.runQuery("SELECT * FROM EMPLOYEES");
        DB_Utility.getAllColumnNames();
        DB_Utility.getAllRows();
        DB_Utility.destroy();

    }
}
