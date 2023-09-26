package Homework.Statament_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Statement_Update {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/homeworks";
            String user = "root";
            String password = "Az.1722Es.";
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();

            int result = stmt.executeUpdate("update ogrenciler set name = 'Esra Tez' where ortalama_not = 1.9");
            System.out.println(result + " kayit güncellendi!");

            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }







    }
}
