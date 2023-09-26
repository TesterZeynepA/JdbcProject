package Jdbc_Practice;

import java.sql.*;

public class P01_ReadData {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tasks",
                "root","Az.1722Es.");

        Statement statement=connection.createStatement();

        //task01-> talebeler table daki recordları listeleyen code create ediniz.
        String sql = "SELECT * FROM talebeler";
        ResultSet kayitlar = statement.executeQuery(sql);

        while (kayitlar.next()){
            System.out.printf("%-6d%-20.20s%-8s%-6d\n", kayitlar.getInt(1),
                    kayitlar.getString(2), kayitlar.getString(3),
                    kayitlar.getInt(4));
        }

        System.out.println("******");

        //task02 -> talebeler tablosundaki notları 90 dan yüksek olan recordları listeleyen code create ediniz.

        String sql2 = "SELECT * FROM talebeler where yazili_notu>90";
        ResultSet not90ustu = statement.executeQuery(sql2);

        while (not90ustu.next()){
            System.out.printf("%-6d%-20.20s%-8s%-6d\n", not90ustu.getInt(1),
                    not90ustu.getString(2), not90ustu.getString(3),
                    not90ustu.getInt(4));
        }

        System.out.println("******");

        //task03-> talebeler tabledaki id değeri 124 olan recordları listeleyen code create ediniz.

        ResultSet id124= statement.executeQuery("select * from talebeler where id=124");
        while (id124.next()){
            System.out.printf("%-6d%-20.20s%-8s%-6d\n", id124.getInt(1),
                    id124.getString(2), id124.getString(3),
                    id124.getInt(4));
        }

        System.out.println("   ***   task04   ***   ");
// Task04-> talebeler table'daki notu 70 ile 90 arasında  olan record'ları listeleyen code create ediniz
        ResultSet not70ile90= statement.executeQuery("select * from talebeler where yazili_notu between 70 and 90");
        while (not70ile90.next()){
            System.out.printf("%-6d%-20.20s%-8s%-6d\n", not70ile90.getInt(1),
                   not70ile90.getString(2), not70ile90.getString(3),
                    not70ile90.getInt(4));
        }

        System.out.println("   ***   task05   ***   ");
// Task05-> talebeler table'daki ismin 3. harfi l   olan record'ları listeleyen code create ediniz.

        ResultSet ismin3harfiL= statement.executeQuery("select * from talebeler where isim like '__l%'");
        while (ismin3harfiL.next()){
            System.out.printf("%-6d%-20.20s%-8s%-6d\n", ismin3harfiL.getInt(1),
                    ismin3harfiL.getString(2), ismin3harfiL.getString(3),
                    ismin3harfiL.getInt(4));
        }

        connection.close();
        statement.close();















    }
}
