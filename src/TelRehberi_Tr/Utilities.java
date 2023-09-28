package TelRehberi_Tr;

import java.sql.*;
import java.util.ArrayList;

import static TelRehberi_Tr.Runner.kayıtObj;

public class Utilities { //db action yapan JDBC methods Class

Connection connection = null;//*** sql query db ye göndermek için DB bağlantısı yapacak obj create edildi.

Statement statement= null;//*** sql query execute edecek obj create edildi.//şimşek

PreparedStatement pStatement=null;//*** pm'li statement obj create edildi.

    public void dBasetConnect(){// MySQL bağlantısı yapan method

        String url = "jdbc:mysql://localhost:3306/";

        String user ="root";

        String password ="Az.1722Es.";

        try {
            connection= DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }


    public void  createDBase(){// db de yeni bir schema create eder
        dBasetConnect();// MySQL connection -> bağlantısı yapıldı
        String query= "create database if not exists telefonrehberi";
        try {
            statement= connection.createStatement();
            statement.executeUpdate(query);
            useTelefonRehberi();// istenen DB active

            String queryTable = "create table if not exists tel_nolar(" +
                    "id int primary key ," +
                    "isim varchar(45)," +
                    "tel varchar(25))";
            statement.executeUpdate(queryTable);

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        finally {

            dBClose();// iki elin kanda da olsa db kapat method call edildi.

        }

    }

    public void addData(Kayıt kayıtObj){// table a record insert eden method-> insert into....
        dBasetConnect();
        useTelefonRehberi();
        String query="insert into tel_nolar(isim, tel) values (?,?)";

        try {
            pStatement=connection.prepareStatement(query);
            pStatement.setString(1, kayıtObj.getIsim());
            pStatement.setString(2, kayıtObj.getTel());
            pStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally {
            dBClose();
        }

    }


    public void updateData(Kayıt kayıtObj){
        dBasetConnect();
        useTelefonRehberi();
        String query="update tel_nolar set isim=?, tel=? where id=?";

        try {
            pStatement= connection.prepareStatement(query);

            pStatement.setString(1,kayıtObj.getIsim());
            pStatement.setString(2,kayıtObj.getTel());
            pStatement.setInt(3,kayıtObj.getId());

            pStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally {
            dBClose();
        }

    }

    public void deleteData(int id){
        dBasetConnect();
        useTelefonRehberi();
        String query="delete from tel_nolar where id=?";
        try {
            pStatement=connection.prepareStatement(query);

            pStatement.setInt(1, kayıtObj.getId());

            pStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally {
            dBClose();
        }


    }

    public ArrayList<Kayıt> listData(){


        dBasetConnect();
        useTelefonRehberi();
        String query = "select * from tel_nolar";

        ArrayList<Kayıt> telRehListe = new ArrayList<>();// tableden gelen column recordların atandığı obj depolayan boş list.
        try {
            statement=connection.createStatement();
            statement.executeQuery(query);
            ResultSet rs = statement.executeQuery(query);
           Kayıt kytObj= new Kayıt();
           while (rs.next()) {

              kytObj.setId(rs.getInt("id"));
              kytObj.setIsim(rs.getString("isim"));
              kytObj.setTel(rs.getString("tel"));

              telRehListe.add(kytObj); // table den gelen column recordların atandığı obj liste eklendi.
           }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return telRehListe;
    }

    public void dBClose(){// açık olan connection db bağlantısını kapatan method

        if (connection!=null){//db bağlantı açıksa kontrolu

            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }

    }

    public void useTelefonRehberi(){

        String query= "use telefonrehberi";
        try {
            statement=connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    public int getLastId(){//table daki son id alıp 1 fazlasını yeni id olarak atayan method

        dBasetConnect();
        useTelefonRehberi();
        int lastId =0;
        String query = "SELECT id FROM tel_nolar order by id desc limit 1;";
        try {
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                lastId=rs.getInt("ide");
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }finally {
            dBClose();
        }

        return lastId;
    }





}
