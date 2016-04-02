import java.util.Scanner;

/**
 * Java Uygulama Projesi
 * Zafer Balkan
 * 
 * �sterler:
 * Tamam� kar��land�.
 *  
 * Sorunlar:
 *  
 * Geli�tirmeler:
 * 1. Exception yaz�lacak. �ncelikle inputlar, ard�ndan k�s�tlar.
 * 2. Tarih girmek g�n, ay, y�l ve �� kez enter bas�ld���ndan 6 a�amal�. K�saltabilir miyiz?
 * 3. �statistikler
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
					+ "\n1. Emir ��lemleri"
					+ "\n2. Komutan ��lemleri" 
					+ "\n3. �statistikler"
					+ "\n9. Test Verisi �ret" 
					+ "\n0. G�n Sonu");

			int secim1 = sc.nextInt();
			switch (secim1) {

			case 1:
				boolean cikis = false;
				while(cikis == false){
					System.out.println(
							"\n          <Emir Kay�t Program�>               <" + bugun.tarihAl() + ">\n" 
							+ "\n1. EM�R ��LEMLER�"
							+ "\n\t1. Emir Ekle" 
							+ "\n\t2. Emir Sil" //Debug i�in ge�erli, sonra yaln�z son yaz�lan emri silme �eklinde d�zeltilecek
							+ "\n\t3. Emir Numaras�yla Ara"
							+ "\n\t4. T�m Emirler" 
							+ "\n\t5. T�m Uygulanm�� Emirler"
							+ "\n\t6. T�m Uygulanm�� Emirler" 
							+ "\n\t7. Verilme Tarihine G�re Emirler"
							+ "\n\t8. Uygulama Tarihine G�re Emirler" 
							+ "\n\t9. Emir Veren Komutana G�re Emirler" 
							+ "\n\t0. GER�");
					
					int secim = sc.nextInt();
					switch(secim){
					case 1:
						emirListesi.emirEkle(bugun, komutanListesi);
						break;
					case 2:
						emirListesi.emirSil();
						break;
					case 3:
						emirListesi.emirNumarasinaGoreAra();
						break;
					case 4:
						emirListesi.listeYazdir("hepsi");
						break;
					case 5:
						emirListesi.listeYazdir("uygulanm��");
						break;
					case 6:
						emirListesi.listeYazdir("uygulanmam��");
						break;
					case 7:
						emirListesi.listeYazdir("verilmeTarihi");
						break;
					case 8:
						emirListesi.listeYazdir("uygulamaTarihi");
						break;
					case 9:
						emirListesi.listeYazdir("emirVeren");
						break;
					case 0:
						cikis = true;
						break;
					default:
						System.out.println("Ge�erli bir se�im yap�n�z.");
					}
			}
			break;

			case 2:
				cikis = false;
				while(cikis == false){
					System.out.println(
							"\n          <Emir Kay�t Program�>               <" + bugun.tarihAl() + ">\n" 
							+ "\n2. KOMUTAN ��LEMLER�"
							+ "\n\t1. Komutan Ekle" 
							+ "\n\t2. Komutan Sil"
							+ "\n\t3. Bilgi G�ncelle"
							+ "\n\t4. T�m Komutanlar"
							+ "\n\t5. A S�n�f� Komutanlar" 
							+ "\n\t6. B S�n�f� Komutanlar"
							+ "\n\t7. Apolet Numaras�yla Ara" 
							+ "\n\t8. Ad�na G�re Ara" 
							+ "\n\t9. Soyad�na G�re Ara"
							+ "\n\t10. R�tbeye G�re Ara"
							+ "\n\t0. GER�");
					
					int secim = sc.nextInt();
					switch(secim){
					case 1:
						komutanListesi.komutanEkle();
						break;
					case 2:
						komutanListesi.komutanSil();
						break;
					case 3:
						komutanListesi.bilgiGuncelle();
						break;
					case 4:
						komutanListesi.listeYazdir("hepsi");
						break;
					case 5:
						komutanListesi.listeYazdir("A");
						break;
					case 6:
						komutanListesi.listeYazdir("B");
						break;
					case 7:
						komutanListesi.listeYazdir("apolet");
						break;
					case 8:
						komutanListesi.listeYazdir("ad");
						break;
					case 9:
						komutanListesi.listeYazdir("soyad");
						break;
					case 10:
						komutanListesi.listeYazdir("rutbe");
						break;
					case 0:
						cikis = true;
						break;
					default:
						System.out.println("Ge�erli bir se�im yap�n�z.");
					}
			}
			break;

			case 9:
				emirListesi.testVerisiUret(bugun, komutanListesi);
				break;
			case 0:
				emirListesi.gunSonu(bugun);
				bugun = bugun.gunSonra(1);
				break;

			default:
				System.out.println("Ge�erli bir se�im yap�n�z.");

			}
		}
	}
}
