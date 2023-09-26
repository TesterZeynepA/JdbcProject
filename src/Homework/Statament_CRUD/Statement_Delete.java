package Homework.Statament_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Statement_Delete {
    public static void main(String[] args) {
        try{
            String url = "jdbc:mysql://localhost:3306/homeworks";
            String user = "root";
            String password = "Az.1722Es.";
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            String isim = "'Azra İnci'";
            String sqlStatement = "delete from ogrenciler where name =" + isim;
            int result = stmt.executeUpdate(sqlStatement);
            System.out.println(result + " kayit silindi!");
            con.close();
        }catch(SQLException e){ System.out.println(e);}







    }
}
