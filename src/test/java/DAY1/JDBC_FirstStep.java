package DAY1;

import java.sql.*;

public class JDBC_FirstStep {

    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@3.91.182.164:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
            Connection con = DriverManager.getConnection(url,username,password);

            //this way creating statement object
            //will allow us to move forward and backward easily when navigating through the result we got
            Statement sttmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = sttmnt.executeQuery("SELECT * FROM REGIONS");

            //IN ORDER TO ACCESS RESULTSET, WE NEED TO KNOW WHICH ROW WE ARE
            //BEFORE ENTERING THE FIRST ROW, THE CURSOR OF THE RESULTSET IS AT THE LOCATION KNOWN AS --BEFORE FIRST
            //IN ORDER TO MOVE TO NEXT LINE WE NEED TO CALL next method of resultset
            //IN ORDER TO GET ANY COLUMN DATA WE NEED TO CALL method getString or getDouble
            rs.next();
            //now we are at the first row
            System.out.println("FIRST ROW REGION_NAME IS "+rs.getString("REGION_NAME"));

            rs.next();
            System.out.println("SECOND ROW REGION_NAME IS "+rs.getString("REGION_NAME"));

            rs.next();
            System.out.println("THIRD ROW REGION_NAME IS "+rs.getString("REGION_NAME"));

            rs.next();
            System.out.println("FOURTH ROW REGION_NAME IS "+rs.getString("REGION_NAME"));

            //rs.next();
            //BELOW LINE WILL NOT WORK. THERE IS NO ROW
            //System.out.println("FIFTH ROW REGION_NAME IS "+rs.getString("REGION_NAME"));


            System.out.println("Connection was successfull");


        }catch (SQLException e){
            System.out.println("Connection has failed "+ e.getMessage());
        }
    }
}
