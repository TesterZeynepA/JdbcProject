package Homework.PrepareStatement_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepareStatement_Delete {
    public static void main(String[] args) {

        try{
            String url = "jdbc:mysql://localhost:3306/homeworks";
            String user = "root";
            String password = "Az.1722Es.";
            Connection con = DriverManager.getConnection(url, user, password);

            PreparedStatement pstmt = con.prepareStatement("delete from veliler where veli_isim =? and ogrenci_id= ?");
            pstmt.setString(1,"Sevgili Okur");
            pstmt.setInt (2,103);
            int sayi = pstmt.executeUpdate();
            System.out.println(sayi + " kayit silindi");

            con.close();
        }catch(SQLException e){ System.out.println(e);}

    }
}
