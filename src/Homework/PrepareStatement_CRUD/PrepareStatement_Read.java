package Homework.PrepareStatement_CRUD;

import java.sql.*;

public class PrepareStatement_Read {
    public static void main(String[] args) {

       try {
           String url = "jdbc:mysql://localhost:3306/homeworks";
           String user = "root";
           String password = "Az.1722Es.";
           Connection con = DriverManager.getConnection(url, user, password);
           String sql ="SELECT * FROM veliler where veli_isim=? and ogrenci_id=?";
           PreparedStatement pstmt = con.prepareStatement(sql);
           pstmt.setString(1, "Sevgili Okur");
           pstmt.setInt(2, 107);
           ResultSet rs = pstmt.executeQuery();
           while (rs.next()){
               System.out.println(rs.getInt(1) + " " + rs.getString("veli_isim") + " " + rs.getString(3));
           }
           con.close();
       }catch(SQLException e){ System.out.println(e);}

    }
}
