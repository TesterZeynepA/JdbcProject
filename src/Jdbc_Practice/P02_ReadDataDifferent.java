package Jdbc_Practice;

import java.sql.*;

public class P02_ReadDataDifferent {

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tasks",
                "root","Az.1722Es.");

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        // rs resultest'i cursoru scroll'a duyarsız sadece read yapma tanımlandı.
        // bu parametre statement'e tanımlanmzasa default olarak cursor-1 imleç iterator tanımlar...
        ResultSet rs = statement.executeQuery("select * from personel");

        System.out.println("   *** task01 ***     ");
        // task01-> ilk satırdaki ilk obj print eden code create ediniz.
        System.out.println(rs.getRow());//0 -> rs için cursorun table daki hangi satırda olduğunu return eder.
        rs.first();//cursor ilk satıra atandı.

        System.out.println("ilkEleman = " + rs.getObject(3));


        System.out.println("   *** task02 ***     ");
        // task02->ilk sutundaki 5.degeri yazdiralim: 5 satırın ilk değeri
        rs.absolute(5);// cursor satırlar arasında absolute ile taşınıyor.ResultSet.absolute(satırNO)
        System.out.println("Beşinci Değer = " + rs.getObject(1));

        System.out.println("   *** task03 ***     ");

        // task03->tum id listeyi print eden code create ediniz.
        rs.getRow();
        rs.absolute(0);
       while (rs.next()) {
           System.out.println(rs.getObject(1).toString());
       }

        System.out.println("   *** task04 ***     ");

        // task04->tum isim listeyi print eden code create ediniz.
        rs.getRow();
        rs.absolute(0);
        while (rs.next()) {
            System.out.println(rs.getObject(2).toString());
        }
        System.out.println("   *** task05 ***     ");

        // task05->tum sehir listeyi print eden code create ediniz.
        rs.getRow();
        rs.absolute(0);
        while (rs.next()) {
            System.out.println(rs.getObject(3).toString());
        }
        System.out.println("   *** task06 ***     ");
        // task06->tum maas listeyi print eden code create ediniz.
        rs.getRow();
        rs.absolute(0);
        while (rs.next()) {
            System.out.println(rs.getObject(4).toString());
        }

        System.out.println("   *** task07 ***     ");
        // task07->tum sirket listeyi print eden code create ediniz.
        rs.getRow();
        rs.absolute(0);
        while (rs.next()) {
            System.out.println(rs.getObject(5).toString());
        }


    }



}
