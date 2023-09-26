package Homework.PrepareStatement_CRUD;

import java.sql.*;

public class PrepareStatement_Create {
    public static void main(String[] args) {

        try{
            String url = "jdbc:mysql://localhost:3306/homeworks";
            String user = "root";
            String password = "Az.1722Es.";
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO veliler (ogrenci_id, veli_isim, okul_isim) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, 105);
            pstmt.setString(2, "Neşe Palamudu");
            pstmt.setString(3, "Ormanköy İlkokulu");

            int sayi = pstmt.executeUpdate();
            System.out.println(sayi + " kayit eklendi");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
