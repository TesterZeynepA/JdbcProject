package TelRehberi_Tr;

public class Kayıt { //pojo class -> dbase'deki column  recordlar için obje tanımalayacak class

    //1.fields -> db column
  private int id;
  private String isim;
  private String tel;

  //2. const.
    //p siz default const.
    //3 getter-setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    //4 toString


    @Override
    public String toString() {
        return  "id=" + id +
                ", isim='" + isim + '\'' +
                ", tel='" + tel ;
    }
}
