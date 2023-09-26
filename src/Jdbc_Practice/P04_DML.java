package Jdbc_Practice;
import java.sql.*;

public class P04_DML {
    public static void main(String[] args) throws SQLException {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tasks", "root", "Az.1722Es."); //database baglantisi icin
            Statement statement = connection.createStatement();//sql sorgu(query) calistirmak (execute etmek) icin

        System.out.println("   ***   task01   ***   ");
        // Task01-> Calisanlar tablosuna yeni bir kayit ((1005, 'Serap Hanım' , 33000)  ekleyelip kaydi teyit icin sorgulayınız.
        //  System.out.println("serap hanım 33000 ile işbaşı workbanch'e bak -> "+statement.executeUpdate("insert into calisanlar values (1005, 'Serap Hanım' , 33000)"));

        //table son hali intelij de gorelim
        ResultSet rs = statement.executeQuery("select * from calisanlar");

        while (rs.next()) {
            System.out.printf("%-6d%-20.20s %-6d\n", rs.getInt(1),
                    rs.getString(2), rs.getInt(3));
        }// Zeynep Aytop style  :)
        System.out.println("   ***   task02   ***   ");
        // Task02-> Calisanlar tablosuna birden fazla yeni kayıt ekleyelim.

        // 1.YONTEM
        // Ayri ayri sorgular ile veritabanina tekrar tekrar ulasmak islemlerin yavas yapilmasina yol acar.
        // 10000 tane veri kaydi yapildigi dusunuldugunde  bu kotu bir yaklasimdir.
        String[] queries = {"insert into calisanlar values (1006, 'Zeynep Hanım' , 54000)",
                "insert into calisanlar values (1007, 'Mustafa Bey' , 46000)",
                "insert into calisanlar values (1008, 'Rumeysa Hanım' , 42000)"
        };
        // int executeSatirSayisi=0;
        // for (String avuc:queries             ) {// bu loop queries'Deki her bir sorguyu db execute eder
        //    executeSatirSayisi+= statement.executeUpdate(avuc);
        // }
        // System.out.println(" zeynep,mustafa ve rumeysa eklendi "+ executeSatirSayisi);//3

        // 2.YONTEM --> addBatch ve excuteBatch() metotlari ile
        // addBatch() -> metodu ile SQL ifadeleri gruplandirilabilir ve exucuteBatch()  metodu ile veritabanina bir kere gonderilebilir.
        // ***!!!!**** excuteBatch() metodu bir int [] dizi dondurur ve  Bu dizi her bir ifade sonucunda etkilenen satir sayisini return eder.
        String[] queries1 = {"insert into calisanlar values (1009, 'Ebru Hanım' , 38000)",
                "insert into calisanlar values (1010, 'Omera Bey' , 55000)",
                "insert into calisanlar values (1011, 'Fatih Bey' , 65000)"
        };
        for (String avuc : queries1) {// bu loop queries'Deki her bir sorguyu db execute eder
            statement.addBatch(avuc);
        }
        int[] satırSayisi = statement.executeBatch();
        System.out.println("ömer ebru fatih eklendi");
    }
}
