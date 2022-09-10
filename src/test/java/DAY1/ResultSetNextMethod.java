package DAY1;

import java.sql.*;

public class ResultSetNextMethod {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@3.91.182.164:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection con = DriverManager.getConnection(url, username, password);
        Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stm.executeQuery("SELECT * FROM REGIONS");

        while (rs.next()){
            System.out.println("rs.getString(1) : "+ rs.getString(1));
        }

        //how do we loop backward from last row till first row
        while(rs.previous()){
            System.out.println("Backward rs.getString(1) : "+ rs.getString(1));
        }

    }
}
