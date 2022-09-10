package DAY1;

import java.sql.*;

public class MovingResultSetCursor {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@3.91.182.164:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection con = DriverManager.getConnection(url, username, password);
        Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stm.executeQuery("SELECT * FROM REGIONS");

        /*
        These are the method of resultSet obj we can use to move the cursor accordingly
        This will only work if your result is type scroll insensitive
        rs.next();
        rs.previous();
        rs.first();
        rs.last();
        rs.beforeFirst();
        rs.afterLast();
        rs.absolute(3);
         */

        rs.first();
        System.out.println("First row : "+rs.getString(2));
        rs.last();
        System.out.println("Last row : "+rs.getString(2));
        rs.previous();
        System.out.println("Previous row : "+rs.getString(2));

        rs.beforeFirst();
        while (rs.next()){
            System.out.println("2nd column data: "+ rs.getString(2));
        }

        //butun row lara bakiyor, daha fazla row kalmadigi icin
        //loop dan cikiyor. bundan sonra yine soutla rs.getstring yaparsak hata verir
        //cunku row kalmadi. en son row a kadar loop ta baktik
        //System.out.println("2nd row is: "+rs.getString(2));


        //bu asamada 2.row a gelelim.
        //move to 2nd row from this point and print region_name

        rs.absolute(2);
        System.out.println("2nd row is: "+ rs.getString(2));




    }
}


