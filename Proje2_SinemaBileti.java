/*
 * Ad Soyad: Emirhan LEVENTER
 * Ogrenci No: 250542004
 * Proje: Proje 2 - Sinema Bileti Fiyatlandirma
 * Tarih: 27.11.2025
 */

import java.lang.classfile.attribute.SourceFileAttribute;
import java.util.Scanner;

public class Proje2_SinemaBileti {

    public static boolean isWeekend(int gun){
        switch (gun){
            case 6:
            case 7:
                return true;

            default:
                return false;
        }
    }

    public static boolean isMatinee(int saat){
        switch (saat){
            case 8:
            case 9:
            case 10:
            case 11:
                return true;

            default:
                return false;
        }
    }

    public static double calculateBasePrice(int gun, int saat){
        double indirimsizFiyat = 0.0;

        if (isWeekend(gun)== true){

            if(isMatinee(saat)== true){
                indirimsizFiyat = 55.0;
            }
            else{
                indirimsizFiyat = 85.0;
            }
        }

        else{

            if(isMatinee(saat)== true){
                indirimsizFiyat = 45.0;
            }
            else{
                indirimsizFiyat = 65.0;
            }
        }
        return indirimsizFiyat;
    }

    public static double calculateDiscount(int yas, int meslek, int gun){
        double discountRate = 1.0;
        if(meslek==1){
            if(gun<=4){
                discountRate = 0.2;
            }
            else{
                discountRate = 0.15;
            }
        }
        else if(yas>=65){
            discountRate = 0.3;
        }
        else if(yas<=12){
            discountRate = 0.25;
        }
        else if(meslek==2 && gun==3){
            discountRate = 0.35;
        }
        return discountRate;
    }

    public static double getFormatExtra(int filmTuru){
        double extra = 0.0;
        if (filmTuru == 2) {
            extra = 25;
        }
        else if (filmTuru == 3) {
            extra = 35;
        }
        else if (filmTuru == 4) {
            extra = 50;
        }
        return extra;
    }

    public static double calculateFinalPrice(double indirimOrani, double indirimsizFiyat, double ekUcret){
        double finalPrice = (indirimsizFiyat-(indirimsizFiyat*indirimOrani))+ekUcret;
        return finalPrice;
    }

    public static void generateTicketİnfo(double biletFiyati, double temelUcret, double indirimOrani, double ekUcret ){
        System.out.println("====== SINEMA BILETI ======");
        System.out.printf("Bilet Fiyati     : %.2f TL\n", temelUcret);
        System.out.printf("Indirim Tutari   : -%.2f TL\n", (temelUcret*indirimOrani));
        System.out.printf("Indirimli Fiyat  : %.2f TL\n", (temelUcret-(temelUcret*indirimOrani)));
        System.out.printf("Ek Ucret         : %.2f TL\n", ekUcret);
        System.out.printf("Son Fiyat        : %.2f TL\n", biletFiyati);
        System.out.println("==========================");

    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);


        System.out.println("====== SINEMA BILETI ======\n");
        System.out.print("Gun (1-7)        : ");
        int gun = scan.nextInt();
        System.out.print("Saat (8-23)      : ");
        int saat = scan.nextInt();
        System.out.print("Yas              : ");
        int yas = scan.nextInt();
        System.out.print("Meslek (1-3)     : ");
        int meslek = scan.nextInt();
        System.out.print("Film Turu (1-4)  : ");
        int film = scan.nextInt();
        System.out.println("==========================\n");

        double temelUcret = calculateBasePrice(gun, saat);
        double indirimOrani = calculateDiscount(yas, meslek, gun);
        double ekUcret = getFormatExtra(film);
        double biletFiyati = calculateFinalPrice(indirimOrani,temelUcret, ekUcret);
        generateTicketİnfo(biletFiyati, temelUcret, indirimOrani, ekUcret);


        scan.close();
    }
}
