package DAY2;

import utility.ConfigurationReader;
import utility.DB_Utility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilityRun {

    public static void main(String[] args) throws SQLException {

        DB_Utility.createConnection();
        ResultSet result = DB_Utility.runQuery("SELECT * FROM REGIONS");
        result.next();
        System.out.println("Region Name: "+ result.getString("REGION_NAME"));

        int totalRow = DB_Utility.getRowCount();
        System.out.println("Total row : "+totalRow);

        int totalColumn = DB_Utility.getColumnCount();
        System.out.println("totalColumn = " + totalColumn);

        System.out.println("getAllColumnNamesAsList = "
                + DB_Utility.getAllColumnNamesAsList());

        System.out.println("DB_Utility.getRowDataAsList(3) = "
                + DB_Utility.getRowDataAsList(3));

        System.out.println("DB_Utility.getCellValue(3,2) = "
                + DB_Utility.getCellValue(3, 2));

        System.out.println("DB_Utility.getCellValue(3, \"REGION_NAME\") = "
                + DB_Utility.getCellValue(3, "REGION_NAME"));

        System.out.println("DB_Utility.getColumnDataAsList(2) = "
                + DB_Utility.getColumnDataAsList(2));

        DB_Utility.displayAllData();

        System.out.println("DB_Utility.getRowMap(3) = "
                + DB_Utility.getRowMap(3));


        System.out.println("DB_Utility.getAllRowsAsListOfMap() = "
                + DB_Utility.getAllRowsAsListOfMap());


        DB_Utility.destroy();

    }
}
