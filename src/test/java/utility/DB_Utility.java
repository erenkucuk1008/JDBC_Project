package utility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Utility {

    private static Connection con;
    private static Statement stm;
    private static ResultSet rs;
    private static ResultSetMetaData rsmd;


    public static void createConnection() {

        String url = ConfigurationReader.getProperty("hr.database.url");
        String username = ConfigurationReader.getProperty("hr.database.username");
        String password = ConfigurationReader.getProperty("hr.database.password");

        try {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection was successful");
        } catch (SQLException e) {
            System.out.println("Connection has failed " + e.getMessage());
        }
    }

    /**
     * @param url
     * @param username
     * @param password
     */
    public static void createConnection(String url, String username, String password) {

        try {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection was successful");
        } catch (SQLException e) {
            System.out.println("Connection has failed " + e.getMessage());
        }
    }

    /**
     * Run the sql query provided and return ResultSet object
     *
     * @param sql
     * @return ResultSet object that contains data
     */
    public static ResultSet runQuery(String sql) {

        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Error Occurred While Running Query " + e.getMessage());
        }

        return rs;
    }

    public static ResultSet getAllColumnNames() {

        try {
            rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            for (int col = 1; col <= colCount; col++) {
                System.out.print(rsmd.getColumnName(col) + "\t");
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println("Error occurred while getting column names " + e.getMessage());
        }
        return rs;
    }

    public static ResultSet getAllRows() {

        try {
            rs.beforeFirst();
            rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            while (rs.next()) {
                for (int col = 1; col <= colCount; col++) {
                    System.out.print(rs.getString(col) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while getting all rows " + e.getMessage());
        }

        return rs;
    }

    /**
     * destroy method to clean up all the resources after being used
     */
    public static void destroy() {

        try {
            if (rs != null) rs.close();
            if (stm != null) stm.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            System.out.println("Error occurred while closing resources " + e.getMessage());
        }
    }

    /**
     * find out the row count
     * @return row count of this ResultSet
     */
    public static int getRowCount(){

        int rowCount = 0;
        try {
            rs.last();
            rowCount = rs.getRow();
        }catch(SQLException e){
            System.out.println("Error occurred while getting row count "+e.getMessage());
        }

        return getRowCount();
    }

}
