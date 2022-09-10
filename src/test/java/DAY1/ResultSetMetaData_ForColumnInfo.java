package DAY1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResultSetMetaData_ForColumnInfo {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@3.91.182.164:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection con = DriverManager.getConnection(url, username, password);
        Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stm.executeQuery("SELECT * FROM COUNTRIES");

        ResultSetMetaData rsmd = rs.getMetaData();
        //2 methods we care about using ResultSetMetaData is
        //getColumnCount to count how many column we have
        //getColumnName or getColumnLabel
        System.out.println("rsmd.getColumnCount() : "+ rsmd.getColumnCount());
        //System.out.println("rsmd.getColumnName() : "+rsmd.getColumnName(1));
        //System.out.println("rsmd.getColumnName() : "+rsmd.getColumnName(2));

        //for loop kullanalim..
        int colCount = rsmd.getColumnCount();
        for (int col = 1 ; col <= colCount ; col++){
            System.out.println("Column "+col+" Name : "+ rsmd.getColumnName(col));
        }

        //save all column name into a list
        List<String> allColumns  = new ArrayList<>();
        for (int col = 1 ; col <= colCount ; col++){
            allColumns.add(rsmd.getColumnName(col));
        }
        System.out.println("all columns = "+ allColumns);
    }
}
