import java.sql.*;

public class NavigationQueryResult {

    public static void main(String[] args) {

        /*
        host : 3.91.182.164
        port: 1521
        SID : xe
        user : hr
        pass: hr

        jdbc:oracle:thin:@3.91.182.164
         */

        String url = "jdbc:oracle:thin:@3.91.182.164";
        String username = "hr";
        String password = "hr";

        try {
            Connection con = DriverManager.getConnection(url,username,password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");

            rs.next();

            System.out.println("Region ID on first row is "+ rs.getString(1));
            System.out.println("Region ID on first row is "+rs.getString("REGION_NAME"));


        }catch (SQLException e){
            System.out.println("Connection has failed "+ e.getMessage());
        }
    }
}
