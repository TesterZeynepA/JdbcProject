package Homework.PrepareStatement_CRUD;

import java.sql.*;

public class PrepareStatement_Update {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/homeworks";
            String user = "root";
            String password = "Az.1722Es.";
            Connection con = DriverManager.getConnection(url, user, password);
            String sql ="update veliler set ogrenci_id=107 where veli_isim= ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "Sevgili Okur");
            int result = pstmt.executeUpdate("update veliler set ogrenci_id = 107 where veli_isim = 'Sevgili Okur'");
            System.out.println(result + " kayit güncellendi!");
            con.close();
        }catch(SQLException e){ System.out.println(e);}

    }
}
