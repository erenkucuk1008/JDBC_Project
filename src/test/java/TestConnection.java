import java.sql.*;

public class TestConnection {

    public static void main(String[] args) {

        /*
        host : 3.91.182.164
        port: 1521
        SID : xe
        user : hr
        pass: hr

        jdbc:oracle:thin:@3.91.182.164
         */

        String url = "jdbc:oracle:thin:@3.91.182.164:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
            Connection con = DriverManager.getConnection(url,username,password);

            System.out.println("Connection was successfull");

            //we close the connection
            con.close();


        }catch (SQLException e){
            System.out.println("Connection has failed "+ e.getMessage());
        }
    }
}
