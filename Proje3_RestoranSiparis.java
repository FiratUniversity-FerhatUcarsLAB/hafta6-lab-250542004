/*
 * Ad Soyad: Emirhan LEVENTER
 * Ogrenci No: 250542004
 * Proje: Proje 3 - Akilli Restoran Siparis Sistemi
 * Tarih: 27.11.2025
 */
import java.sql.SQLOutput;
import java.util.Scanner;

public class Proje3_RestoranSiparis {

    public static double getMainDishPrice(int secim){
        switch (secim){
            case 1:
                return 85;
            case 2:
                return 120;
            case 3:
                return 110;
            case 4:
                return 65;
            default:
                return 0;
        }
    }

    public static double getAppetizerPrice(int secim){
        switch (secim){
            case 1:
                return 25;
            case 2:
                return 45;
            case 3:
                return 55;
            default:
                return 0;
        }
    }

    public static double getDrinkPrice(int secim){
        switch (secim){
            case 1:
                return 15;
            case 2:
                return 12;
            case 3:
                return 35;
            case 4:
                return 25;
            default:
                return 0;
        }
    }

    public static double getDessertPrice(int secim){
        switch (secim){
            case 1:
                return 65;
            case 2:
                return 55;
            case 3:
                return 35;
            default:
                return 0;
        }
    }

    public static boolean isComboOrder(double anaSecim, double icecekSecim, double tatliSecim){
        if(anaSecim>0 && icecekSecim>0 && tatliSecim>0){
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isHappyHour(int saat){
        if(saat>=14 && saat<17){
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isStudent(int ogrenci){
        switch(ogrenci){
            case 1:
                return true;
            case 2:
            default:
                return false;
        }
    }

    public static double calculatedDiscount(double tutar,double icecek,int saat, boolean ogrenci, boolean combo){
        double toplamIndirim=0.0;
        double indirimOran = 0.0;
        if (isHappyHour(saat)==true){
            toplamIndirim = toplamIndirim+(icecek-icecek*0.2);
        }
        if (ogrenci==true){
            indirimOran = indirimOran+0.1;
        }
        if (combo==true){
            indirimOran = indirimOran+0.15;
        }
        if (tutar>200){
            indirimOran = indirimOran+0.1;
        }
        toplamIndirim = toplamIndirim+(tutar*indirimOran);
        return toplamIndirim;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("======== RESTORAN MENU ========");
        System.out.println("Ana Yemekler: (1: Izgara Tavuk-85TL),(2: Adana Kebap-120TL),(3: Levrek-110TL),(4: Mantı-65TL)");
        System.out.print("Ana Yemek Seciniz:");
        int anaYemek = scan.nextInt();
        System.out.println("Baslagiclar: (1: Corba-25TL),(2: Humus-45TL),(3: Sigara Boregi-55TL)");
        System.out.print("Baslangic Seciniz:");
        int baslangic = scan.nextInt();
        System.out.println("Icecekler: (1: Kola-15TL),(2: Ayran-12TL),(3: Meyve Suyu-35TL),(4: Limonata-25TL)");
        System.out.print("Icecek Seciniz:");
        int icecek = scan.nextInt();
        System.out.println("Tatlilar: (1: Kunefe-65TL),(2: Baklava-55L),(3: Sutlac-35TL)");
        System.out.print("Tatli Seciniz:");
        int tatli = scan.nextInt();
        System.out.print("Ogrenci misiniz (1:Evet,2:Hayir) :");
        int ogrenci = scan.nextInt();
        System.out.print("Siparis Saati Kac (8-23) :");
        int saat = scan.nextInt();

        double hamTutar = getMainDishPrice(anaYemek)+getAppetizerPrice(baslangic)+getDrinkPrice(icecek)+getDessertPrice(tatli);
        double indirimTutari = calculatedDiscount(hamTutar,getDrinkPrice(icecek),saat,isStudent(ogrenci),isComboOrder(getMainDishPrice(anaYemek),getDrinkPrice(icecek),getDessertPrice(tatli)));
        double toplamTutar = hamTutar-indirimTutari;

        System.out.println("\n====== FATURA OZETI ======");
        System.out.printf("Indırımsız Toplam Tutar:   %.2f TL\n", hamTutar);
        System.out.println("----------------------------------");
        System.out.printf("Happy Hour Indırımı (Icecek): -%.2f TL\n", isHappyHour(saat)==true ? getDrinkPrice(icecek)-(getDrinkPrice(icecek)*0.2) : 0);
        System.out.printf("Diğer İndirimler Tutarı:      -%.2f TL\n", indirimTutari - (isHappyHour(saat)==true ? getDrinkPrice(icecek)-(getDrinkPrice(icecek)*0.2) : 0));
        System.out.printf("Toplam İndirim Tutarı:        -%.2f TL\n", indirimTutari);
        System.out.println("----------------------------------");
        System.out.printf("Ödenecek Son Tutar:        %.2f TL\n", toplamTutar);
        System.out.printf("Bahşiş Önerisi (%%10):       %.2f TL\n", toplamTutar*0.1);
        System.out.println("==================================");
        scan.close();
    }
}
