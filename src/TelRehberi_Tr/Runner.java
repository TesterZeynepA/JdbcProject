package TelRehberi_Tr;

import java.util.Scanner;

public class Runner {// Class level

    static Scanner input= new Scanner(System.in);
    static Kayıt kayıtObj = new Kayıt();// kayıt obje create edildi

    static Utilities dbMethods= new Utilities();// utilities class dan method call etmek için obje create edildi


    public static void main(String[] args) {//main level

        menuIslem();

    }//main sonu

    public static void menuIslem(){

        System.out.println("----------------------");
        System.out.println("1- List Records\n2- Delete Records\n3- Update Records\n4- Add new Record\nX- Exit\n" +
                "-------------------------\nSeçiminiz : ");
        String secim = input.next().toUpperCase();
        switch (secim) {
            case "1":
                listRecords();
                menuIslem();
                break;
            case "2":
                deleteRecord();
                menuIslem();
                break;
            case "3":
                updateRecord();
                menuIslem();
                break;
            case "4":
                addNewRecord();
                menuIslem();
                break;
            case "X":
                System.out.println("sistem çıkışınız yapılmıştır  ... ");
                break;
            default:
                System.out.println("hatalı giriş ");
                menuIslem();

        }

    }



    private static void addNewRecord() {
        System.out.println("-------------------------\nrecord ekleme  : ");

        System.out.print("isim : ");
        new Scanner(System.in);
        String isim = input.next();
        System.out.print("tel : ");
        String tel = input.nextLine();
        kayıtObj.setIsim(isim);
        kayıtObj.setTel(tel);
        kayıtObj.setId(dbMethods.getLastId() + 1);
        dbMethods.addData(kayıtObj);//db2ye recod giren meth kayıtobj ile gönderildi

    }

    private static void updateRecord() {

        System.out.println("-------------------------\nupdate edilecek KAYIT ID : ");

        int updateId = input.nextInt();

        if (dbMethods.listData().size()==0){
            System.out.println("table boş olduğu için update yapamazsınız!");
        }else{
            for (int i = 0; i < dbMethods.listData().size(); i++) {

            if (updateId == dbMethods.listData().get(i).getId()) {
                System.out.printf("%5d%20s%15s%n", dbMethods.listData().get(i).getId(), dbMethods.listData().get(i).getIsim(), dbMethods.listData().get(i).getTel());
                System.out.print("kayıt yenilemeyi onaylıyor musunuz (E:evet)");

                String onay = input.next();

                if (onay.equalsIgnoreCase("E")) {
                    System.out.println("güncellemek istemediğiniz alana X giriniz");
                    System.out.print("yeni isim : ");
                    String yeniIsim = input.next();
                    System.out.print("yeni tel : ");
                    String yeniTel = input.nextLine();
                    if (yeniIsim.equalsIgnoreCase("x")) {// ismi değiştirmek istemiyor
                        yeniIsim = dbMethods.listData().get(i).getIsim();//eski yeni isme atadım
                        kayıtObj.setIsim(yeniIsim);
                    } else {
                        kayıtObj.setIsim(yeniIsim);
                    }

                    if (yeniTel.equalsIgnoreCase("x")) {//telefon numarasını değiştirmek istemiyor
                        yeniTel = dbMethods.listData().get(i).getTel();// eski tel yeni tele atandı
                        kayıtObj.setTel(yeniTel);
                    } else {
                        kayıtObj.setTel(yeniTel);

                    }
                    kayıtObj.setId(updateId);
                    dbMethods.updateData(kayıtObj);
                    System.out.println("güncelleme başarılı şekilde gerçekleşti :)");
                } else System.out.println("update  işlemi iptal edildi");
            } else System.out.println("update ID bulunamadı");
        }
    }
    }

    private static void deleteRecord() {
        System.out.println("-------------------------\nsilinecek KAYIT ID : ");

        int silinecekId = input.nextInt();

        if (dbMethods.listData().size()==0){
            System.out.println("list boş olduğu için delete işlemi yapamazsınız!");
        }else {
            for (int i = 0; i < dbMethods.listData().size(); i++) {// table dan select ile gelen arrayList elemanları tekrar eden loop
            if (silinecekId == dbMethods.listData().get(i).getId()) {
                System.out.printf("%5d%20s%15s%n", dbMethods.listData().get(i).getId(),
                        dbMethods.listData().get(i).getIsim(), dbMethods.listData().get(i).getTel());
                System.out.print("kayıt silmeyi onaylıyor musunuz (E:evet)");

                String onay = input.next();
                if (onay.equalsIgnoreCase("E")) {

                    dbMethods.deleteData(silinecekId);
                    System.out.println("silme işlemi başarılı şekilde yapıldı :) ");
                } else {
                    System.out.println("silme işlemi iptal edildi");
                    deleteRecord();
                }
            } else {
                System.out.println("silinecek ID bulunamadı");
            }

        }
        }

    }

    private static void listRecords() {
        System.out.printf("%4S%20S%17S\n", "id", "isim soyisim", "telefon no");
        System.out.printf("%4S%20S%17S\n", "--", "------------", "------------");
        for (int i = 0; i < dbMethods.listData().size(); i++) {
            // System.out.printf("%4d%20s%17s\n", telList.get(i).getId(), telList.get(i).getIsim(), telList.get(i).getTel());
            System.out.printf("%4d%20s%17s\n", dbMethods.listData().get(i).getId(),
                    dbMethods.listData().get(i).getIsim(), dbMethods.listData().get(i).getTel());
        }
        if (dbMethods.listData().size() == 0) {
            System.out.println("listelenecek kayıt bulunamadı");
        }

    }

}//class sonu
