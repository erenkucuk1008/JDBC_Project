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

        return rowCount;
    }

    /**
     * find out the column count
     * @return column count of this ResultSet
     */
    public static int getColumnCount(){

        int columnCount = 0;
        try {
            rsmd = rs.getMetaData();
            columnCount = rsmd.getColumnCount();
        }catch(SQLException e){
            System.out.println("Error occurred while getting column count "+ e.getMessage());
        }
        //return columnCount yazabilmek icin int columnCount=0 yaziyoyoruz
        //yoksa try in icinde kalacagi icin return de kullanamiyoruz..
        return columnCount;
    }

    //Get all the column names into a list object
    public static List<String> getAllColumnNamesAsList(){

        List<String> columnNameList = new ArrayList<>();
        int colCount = getColumnCount();
        try {
            for (int col = 1; col <= colCount; col++) {
                columnNameList.add(rsmd.getColumnName(col));
            }
        }catch (SQLException e){
            System.out.println("Error occurred while getting all Column names "+e.getMessage());
        }

        return columnNameList;
    }

    public static List<String> getRowDataAsList(int rowNum){

        List<String> rowDataAsList = new ArrayList<>();
        int colCount = getColumnCount();
        try {
            rs.absolute(rowNum);
            for (int col = 1; col <= colCount; col++) {
                rowDataAsList.add(rs.getString(col));
            }
        }catch (SQLException e){
            System.out.println("Error occurred while getRowDataAsList "+e.getMessage());
        }

        return rowDataAsList;
    }

    /**
     * getting the cell value according to rowNum and columnIndex
     * @param rowNum
     * @param columnIndex
     * @return the value in String at that location
     */
    public static String getCellValue(int rowNum, int columnIndex){

        String cellValue = "";
        try{
            rs.absolute(rowNum);
            cellValue = rs.getString(columnIndex);
        }catch (SQLException e){
            System.out.println("Error occurred while getCellValue "+e.getMessage());
        }

        return cellValue;
    }

    /**
     * getting the cell value according to rowNum and columnIndex
     * @param rowNum
     * @param columnName
     * @return the value in String at that location
     */
    public static String getCellValue(int rowNum, String columnName){

        String cellValue = "";
        try{
            rs.absolute(rowNum);
            cellValue = rs.getString(columnName);
        }catch (SQLException e){
            System.out.println("Error occurred while getCellValue "+e.getMessage());
        }

        return cellValue;
    }

    /**
     * getting entire column data as list according to column number
     * @param columNum
     * @return list object that contains all rows of that column
     */
    public static List<String> getColumnDataAsList(int columNum){

        List<String> columDataLst = new ArrayList<>();

        try{
            rs.beforeFirst();
            while (rs.next()){
                columDataLst.add(rs.getString(columNum));
            }
            rs.beforeFirst();//make sure to reset the cursor to before first
        }catch (SQLException e){
            System.out.println("Error occurred while getColumnDataAsList");
        }



        return columDataLst;
    }

}
