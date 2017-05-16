package savt;

import java.io.IOException;
import java.util.Scanner;
/**
 * Created by enes on 16.05.2017.
 */
@SuppressWarnings("resource")
public class Otomasyon {
    public static void main(String[] args) {

        Magaza magaza = new Magaza("1201");


        try{
            magaza.urunleriOku();
        }
        catch( IOException e ) {
            System.out.println("Dosya okuma işlemleri sırasında" +
                    " bir hata oluştu.");
            magaza.yeniUrunTablosuOlustur();
            e.printStackTrace();
        }
        catch( ClassNotFoundException e ) {
            System.out.println("Okunan kayıtları işlerken " +
                    "bir hata oluştu.");
            e.printStackTrace();
        }

        Scanner in = new Scanner(System.in);
        boolean exit = false;


        while(!exit)
        {
            System.out.println(" 1 - Yeni urun ekle");
            System.out.println(" 2 - Kasa islemleri");
            System.out.println(" 3 - Cikis");
            System.out.println(" Seciminizi giriniz : ");
            int selection = in.nextInt();
            in.nextLine();

            switch(selection)
            {
                case 1 :    magaza.urunEkle();
                            try
                            {
                                magaza.urunleriGuncelle();
                            }
                            catch(IOException e)
                            {
                                System.out.println("Dosya okuma işlemleri sırasında" +
                                        " bir hata oluştu.");
                            }

                            /*catch (NullPointerException e){

                                e.printStackTrace();
                            }*/
                break;

                case 2 :    magaza.getKasa().Satis(magaza.getUrunler());

                            try
                            {
                                magaza.urunleriGuncelle();
                            }
                            catch(IOException e)
                            {
                                System.out.println("Dosya okuma işlemleri sırasında" +
                                        " bir hata oluştu.");
                            }
                break;

                case 3 :    System.out.println("Programdan cikis yaptiniz");
                            exit = true;
                break;
                default : System.out.println("Hatali bir secim girdiniz...");
            }
        }

    }
}