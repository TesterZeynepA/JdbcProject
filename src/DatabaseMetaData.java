import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DatabaseMetaData {
    public static void main(String[] args) {
       try {


        String url = "jdbc:mysql://localhost:3306/fsae03";
        String user = "root";
        String password = "Az.1722Es.";
           // Class.forName("com.mysql.cj.jdbc.Driver");
// create a connection to the database
        Connection con = DriverManager.getConnection(url, user, password);
        java.sql.DatabaseMetaData dbmd =con.getMetaData();
        String table[] = {"TABLE"};
        ResultSet rs =dbmd.getTables(null,null, null, table);
        while (rs.next()){
            System.out.println(rs.getString(1)+" "+rs.getString(3)+" "+rs.getString(4));
        }
           con.close();

    }catch (Exception e) {
           System.out.println(e);
       }

}
}
