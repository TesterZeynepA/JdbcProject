import java.io.FileOutputStream;
import java.sql.*;

public class Insert_Image {
    public static void main(String[] args) {
        try{
// db parameters
            String url = "jdbc:mysql://localhost:3306/fsae03";
            String user = "root";
            String password = "Az.1722Es.";
// Class.forName("com.mysql.cj.jdbc.Driver");
// create a connection to the database
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement ps=con.prepareStatement("select * from personel");
            ResultSet rs=ps.executeQuery();
            rs.next();//now on 1st row
            Blob b=rs.getBlob(4);
            byte barr[]=new byte[(int)b.length()]; // an array is created but contains no data
            barr=b.getBytes(1,(int)b.length());
            FileOutputStream fout=new FileOutputStream("C:\\Kullanıcılar\\zeyne\\OneDrive\\Masaüstü\\profil foto.PNG");
            fout.write(barr);
            fout.close();
            System.out.println("OK :)");
            con.close();
        }catch (Exception e) {e.printStackTrace();	}
    }
}
