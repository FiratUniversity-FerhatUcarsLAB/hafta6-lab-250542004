/*
 * Ad Soyad: Emirhan LEVENTER
 * Ogrenci No: 250542004
 * Proje: Proje 1 - Ogrenci Not Degerlendirme Sistemi
 * Tarih: 20.11.2025
 * Aciklama:
 * Bu projede kullanicidan alinan vize, final ve odev notu
 * degerleri kullanilarak kullanicinin; gecme durumu, harf notu,
 * ortalamasi, onur listesine girip girmedigi ve butunleme hakki
 * gosteren bir java kodu yazildi.
 */

import java.util.Scanner;

public class Proje1_NotSistemi {

    public static boolean isPassingGrade(double grade) {
        return grade >= 50.0;
    }

    public static double calculateAverage(double vizeNot, double finalNot, double odevNot){
        double grade=vizeNot*30/100 + finalNot*40/100 + odevNot*30/100;
        return grade;
    }

    public static boolean isHonorList(double grade, double vizeNot, double finalNot,double odevNot){
        if(grade >=85 && vizeNot >=70 && finalNot >=70 && odevNot >=70){
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean hasRetakeRight(double grade){
        if (grade >= 45 && grade < 50){
            return true;
        }
        else {
            return false;
        }
    }

    public static char getLetterGrade(double grade){
        char letterGrade;
        if (grade >= 90.0 && grade <=100.0) {
            letterGrade = 'A';
        }
        else if (grade >= 80.0 && grade <90.0) {
            letterGrade = 'B';
        }
        else if (grade >= 70.0 && grade <80.0) {
            letterGrade = 'C';
        }
        else if (grade >= 60.0 && grade <70.0) {
            letterGrade = 'D';
        }
        else if (grade >= 0.0 && grade <60.0) {
            letterGrade = 'F';
        }
        else {
            letterGrade = 'X';
        }
        return letterGrade;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("====== OGRENCI NOT SISTEMI ======\n");
        System.out.print("Vize          : ");
        double vizeNot=scan.nextDouble();
        System.out.print("Final         : ");
        double finalNot=scan.nextDouble();
        System.out.print("Odev          : ");
        double odevNot=scan.nextDouble();
        System.out.println("\n=================================\n");

        double grade = calculateAverage(vizeNot, finalNot, odevNot);
        char letterGrade = getLetterGrade(grade);

        System.out.printf("Ortalama     : %.1f\n", grade);
        System.out.printf("Harf Notu    : %c\n", letterGrade);
        System.out.printf("Durum        : %s\n", isPassingGrade(grade) ? "GECTI" : "KALDI" );
        System.out.printf("Onur Listesi : %s\n", isHonorList(grade, vizeNot, finalNot, odevNot) ? "EVET" : "HAYIR");
        System.out.printf("Butunleme    : %s\n", hasRetakeRight(grade) ? "VAR" : "YOK");
        System.out.println("\n=================================\n");

        scan.close();
    }
}
