package DAY1;

import java.sql.*;

public class DisplayAllData {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@3.91.182.164:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection con = DriverManager.getConnection(url, username, password);
        Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stm.executeQuery("SELECT * FROM COUNTRIES");

        rs.last();// how to go to last row
        int rowNum = rs.getRow();// how to get current row number
        System.out.println("RowNum : "+ rowNum);

        ResultSetMetaData rsmd = rs.getMetaData();
        int colCount = rsmd.getColumnCount();

        //print out entire first row in one line
        rs.first();
        //System.out.print(rs.getString(1));
        //System.out.print("\t" + rs.getString(2));
        //System.out.println("\t" + rs.getString(3));
        for (int col =1; col <= colCount; col++){
            System.out.print(rs.getString(col)+" ");
        }

    }
}
