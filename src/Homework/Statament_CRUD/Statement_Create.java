package Homework.Statament_CRUD;

import java.sql.*;

public class Statement_Create {
    public static void main(String[] args) {

        try {
            String url = "jdbc:mysql://localhost:3306/homeworks";
            String user = "root";
            String password = "Az.1722Es.";
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();

            int result = stmt.executeUpdate("insert into ogrenciler values (105,'ogrenci','Azra İncili', 3.7,'Bayrampaşa İlkokulu')");
            System.out.println(result + " kayit eklendi!");

            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
