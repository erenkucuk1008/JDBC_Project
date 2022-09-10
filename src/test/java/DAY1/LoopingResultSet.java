package DAY1;

import java.sql.*;

public class LoopingResultSet {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@3.91.182.164:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection con = DriverManager.getConnection(url, username, password);
        Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stm.executeQuery("SELECT * FROM REGIONS");


        //next method will move your cursor to next line
        //and also return true if you have more row and return false if there is no row
        while (rs.next()){

            System.out.println("REGION_ID at this row is "+rs.getString("REGION_ID"));
            System.out.println("REGION value at this row is "+rs.getString("REGION_NAME"));
        }

        //create new resultSet object by running different query like
        // SELECT * FROM JOBS
        // WE MAY REUSE SAME VARIABLE

        rs = stm.executeQuery("SELECT * FROM JOBS");

        while (rs.next()){
            //get job_id and title in one line
            System.out.print(rs.getString(1));
            System.out.println("\t\t" + rs.getString(2));
        }
    }
}
