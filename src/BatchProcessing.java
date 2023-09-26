import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchProcessing {
    public static void main(String args[]){
        try {
// db parameters
            String url = "jdbc:mysql://localhost:3306/fsae03";
            String user = "root";
            String password = "Az.1722Es.";
// Class.forName("com.mysql.cj.jdbc.Driver");
// create a connection to the database
            Connection con = DriverManager.getConnection(url, user, password);
            con.setAutoCommit(false);
            Statement stmt = con.createStatement();
            stmt.addBatch("insert into ogrenciler values(420,'Ali Can','Ankara',75)");
            stmt.addBatch("insert into ogrenciler values(421,'Veli Mert','Trabzon',85)");
            int[] i = stmt.executeBatch(); // executing the batch
            System.out.println(i[0]+" records inserted");
            System.out.println(i[1]+" records inserted");
            con.commit();
// con.rollback();
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}
