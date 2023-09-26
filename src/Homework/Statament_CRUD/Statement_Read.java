package Homework.Statament_CRUD;

import java.sql.*;

public class Statement_Read {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/homeworks";
        String user = "root";
        String password = "Az.1722Es.";
        String sql = "SELECT name, ortalama_not FROM ogrenciler";

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getString("name") + "\t" +
                        rs.getDouble("ortalama_not"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
