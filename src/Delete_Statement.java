import java.sql.*;

public class Delete_Statement {
    public static void main(String[] args) {
// TODO Auto-generated method stub
        try{
            String url = "jdbc:mysql://localhost:3306/fsae03";
            String user = "root";
            String password = "Az.1722Es.";
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            String isim = "'Honda'";
            String sqlStatement = "delete from sirket where sirket_isim =" + isim;
// delete from sirket where sirket_isim = 'Honda';
            int result = stmt.executeUpdate(sqlStatement);
            System.out.println(result + " kayit silindi!");
/*
 int result = stmt.executeUpdate("update ogrenciler set isim = 'Martin Parr2' where id = 121");
 */

 /* int result = stmt.executeUpdate("insert into ogrenciler values(221, 'Ali Veli2', 'Ankara', 95)");
 System.out.println(result + " records affected"); */

            con.close();
        }catch(SQLException e){ System.out.println(e);}
    }
}