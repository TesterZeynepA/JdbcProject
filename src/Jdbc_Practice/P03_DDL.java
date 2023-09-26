package Jdbc_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class P03_DDL {
    /*
       A) CREATE TABLE, DROP TABLE, ALTER TABLE gibi DDL ifadeleri icin sonuc kümesi (ResultSet)
      dondurmeyen metotlar kullanilmalidir. Bunun icin JDBC’de 2 alternatif bulunmaktadir.
     1) execute() metodu
     2) excuteUpdate() metodu.
    B)   - execute() metodu her tur SQL ifadesiyle kullanibilen genel bir komuttur.
      - execute(), Boolean bir deger dondurur.
      - DDL islemlerin false dondururken, DML islemlerinde true deger dondurur.(ResultSet olusturur)
      - Ozellikle hangi tip SQL ifadesinin kullanilmasinin gerektiginin belli olmadigi
       durumlarda tercih edilmektedir.

     C) - executeUpdate() metodu ise INSERT, Update gibi DML islemlerinde yaygin kullanilir.
    -  bu islemlerde islemden etkilenen satir sayisini return eder.
   - Ayrıca, DDL islemlerinde de kullanilabilir ve bu islemlerde 0 return eder.

    execute() her turlu SQL kjomutuyla kullanilir .......  DDL ---> False    DML----> True
     executeUpdate()  DDL ----> 0           DML ----->etkilenen satir sayisini verir
    */
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tasks", "root", "Az.1722Es."); //database baglantisi icin
        Statement statement = connection.createStatement();//sql sorgu(query) calistirmak (execute etmek) icin

        System.out.println("   ***   task01   ***   ");
        // Task01-> markalar adında bir tablo oluşturunuz. marka_id int, marka_isim VARCHAR(15), calisan_sayisi int
//boolean s1 = statement.execute("create table marka (marka_id int, marka_isim varchar(15), calisan_sayisi int)");
        //1.yontem : execute () methodu ile
      // String query= "\"create table marka (marka_id int, marka_isim varchar(15), calisan_sayisi int)";
      // boolean s1 = statement.execute(query);
      // System.out.println("s1 = " + s1);// false çünkü DDL çalıştırdık.

        //2.yontem : executeUpdate() methodu ile
       // int s2 = statement.executeUpdate(query);
       // System.out.println("s2 = " + s2);//0 ->DDL


        System.out.println("   ***   task02   ***   ");
        // Task02->  markalar tablosunu siliniz
        //System.out.println("statement.execute(\"drop table marka\") = "
          //      + statement.execute("drop table marka"));

        System.out.println("   ***   task03   ***   ");
        // Task03-> markalar tablosuna yeni bir sutun {sube_sayisi int} ekleyiniz.
       // System.out.println("statement.execute(\"alter table marka add sube_sayisi int\") = " +
         //       statement.execute("alter table marka add sube_sayisi int"));


        System.out.println("   ***   task04   ***   ");
        // Task04-> markalar tablosuna yeni bir sutun {sube_sayisi int} ekleyiniz, ancak bu sutunun yeri marka_id den sonra olsun
       // System.out.println("statement.execute(\"alter table marka add sube_sayisi int\") = " +
        //        statement.execute("alter table marka add sube_sayisi1 int after marka_id"));

        System.out.println("   ***   task5   ***   ");
        // Task05-> markalar tablosunun adini  brands olarak degistiriniz
      // System.out.println("table ismi değiştirildi " +
      //         statement.execute("alter table marka rename to brands"));


        System.out.println("   ***   task06   ***   ");
        // Task06-> markalar tablosunda marka_isim sutununu isim olarak degistiriniz
       // System.out.println("column ismi değiştirildi " +
       //         statement.execute("alter table brands rename column marka_isim to isim"));


        System.out.println("   ***   task07   ***   ");
        // Task07-> markalar tablosunda marka_isim sutununun data type ini char(20) olarak degistiriniz
        System.out.println("column data type değiştirildi " +
                statement.execute("alter table brands modify isim varchar(20)"));

    }



}
