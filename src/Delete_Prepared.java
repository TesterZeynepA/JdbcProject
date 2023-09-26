import java.sql.*;

public class Delete_Prepared {
    public static void main(String[] args) {
// TODO Auto-generated method stub
        try{
            String url = "jdbc:mysql://localhost:3306/fsae03";
            String user = "root";
            String password = "Az.1722Es.";
            Connection con = DriverManager.getConnection(url, user, password);

            PreparedStatement stmt = con.prepareStatement("delete from sirket where sirket_isim=? and sirket_id = ?");
            stmt.setString(1,"Opel");
            stmt.setInt (2,105);
            int i = stmt.executeUpdate();
            System.out.println(i + " kayit silindi");

            con.close();
        }catch(SQLException e){ System.out.println(e);}
    }
}
