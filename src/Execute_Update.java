import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute_Update {
    public static void main(String[] args) {


        try {
            String url = "jdbc:mysql://localhost:3306/fsae03";
            String user = "root";
            String password = "Az.1722Es.";
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
           /*
 String isim = "'Honda'";
 String sqlStatement = "delete from sirket where sirket_isim =" + isim;
 int result = stmt.executeUpdate(sqlStatement);
 System.out.println(result + " kayit silindi!");
 */
/*
 int result = stmt.executeUpdate("update sirket set sirket_isim = 'Anadol' where sirket_isim = 'Ford'");
 System.out.println(result + " kayit güncellendi!");
 */
            int result = stmt.executeUpdate("insert into sirket values(105, 'Opel')");
            System.out.println(result + " kayit eklendi!");

            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
