import java.util.Scanner;

/**
 * Java Uygulama Projesi
 * Zafer Balkan
 * 
 * 
 * Sorunlar:
 * 1. Emir tekrar� yap�ld���nda ekrana emirleri do�ru numaralar�yla yazd�r�yor. 
 * Ancak emirleri listeledi�imizde yeni emirlerin hepsitekrarlanan son emrin numaras�n� alm�� olarak g�r�nt�leniyor.
 * 2. Bilgi g�ncelle men�s�nde komutan�n t�r� de�i�miyor.
 * 
 * 
 * Geli�tirmeler:
 * 1. Emir arama, komutan arama metorlar� yaz�ld�, men�ye eklenecek
 * 2. Komutan A ve B k�s�tlar�n� statik yapmak yerine Komutan s�n�f� i�ine
 * bir emirVer() metodu yaz�p KomutanA ve KomutanB taraf�ndan override etsek, 
 * her biri kendi kontrol�n� yapsa olur mu? (emirVer(), emirEkle()'yi �a��racak,
 * apolet numaras� sorgusunu komutanListesi ya da emirListesi i�inde yapmay� 
 * gerektirebilir)
 * 3. Emir Listele men�s� ayr�nt�land�r�lacak: Uygulanan, uygulanmayan,
 * bug�n uygulanacak, bug�n verilen, x komutan taraf�ndan verilen, tekrar eden emirler...
 * 4. Komutan Listesi ayr�nt�land�r�lacak: A tipi komutanlar, B tipi komutanlar,
 * bug�n emir veren, hi� emir vermeyen...
 * 5. Tarih girmek g�n, ay, y�l ve �� kez enter bas�ld���ndan 6 a�amal�. K�saltabilir miyiz?
 */
public class MainClass {

	public static void main(String[] args) {

		KomutanListesi komutanListesi = new KomutanListesi();
		EmirListesi emirListesi = new EmirListesi();
		Tarih bugun = new Tarih();

		Scanner sc = new Scanner(System.in);

		bugun = bugun.tarihAyarla();

		while (true) {
			System.out.println(
					"\n          <Emir Kay�t Program�>               <" + bugun.tarihAl() + ">\n" 
					+ "\n1. Emir Ekle"
					+ "\n2. Emir Listele" 
					+ "\n3. Emir Sil" //Debug i�in ge�erli, sonra yaln�z son yaz�lan emri silme �eklinde d�zeltilecek
					+ "\n4. Komutan Ekle" 
					+ "\n5. Komutan Listele"
					+ "\n6. Komutan Sil" 
					+ "\n7. Bilgi G�ncelle" 
					+ "\n8. Test Verisi �ret" 
					+ "\n9. G�n Sonu");

			int secim1 = sc.nextInt();
			switch (secim1) {

			case 1:
				emirListesi.emirEkle(bugun, komutanListesi);
				break;

			case 2:
				emirListesi.emirListesiYazdir();
				break;

			case 3:
				emirListesi.emirSil();
				break;

			case 4:
				komutanListesi.komutanEkle();
				break;

			case 5:
				komutanListesi.listeYazdir();
				break;
			case 6:
				komutanListesi.komutanSil();
				break;
			case 7:
				komutanListesi.bilgiGuncelle();
				break;
			case 8:
				emirListesi.testVerisiUret(bugun, komutanListesi);
				break;
			case 9:
				emirListesi.gunSonu(bugun);
				bugun = bugun.gunSonra(1); // emirListesi'nin i�ine alsak m�?
				break;

			default:
				System.out.println("Ge�erli bir se�im yap�n�z.");

			}
		}
	}
}
