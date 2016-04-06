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

	public static void main(String[] args) throws Exception{

		KomutanListesi komutanListesi = new KomutanListesi();
		EmirListesi emirListesi = new EmirListesi();
		Tarih bugun = new Tarih();
		�statistikler ist = new �statistikler();

		Scanner sc = new Scanner(System.in);

		bugun = bugun.tarihAyarla();

		while (true) {
			System.out.println(
					"\n\t\t<Emir Kay�t Program�>\t\t\t<" + bugun.tarihAl() + ">\n" 
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
							"\n\t\t<Emir Kay�t Program�>\t\t\t<" + bugun.tarihAl() + ">\n" 
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
						emirListesi.ekle(bugun, komutanListesi);
						break;
					case 2:
						emirListesi.sil();
						break;
					case 3:
						emirListesi.listele("emirNo");
						break;
					case 4:
						emirListesi.listele("hepsi");
						break;
					case 5:
						emirListesi.listele("uygulanm��");
						break;
					case 6:
						emirListesi.listele("uygulanmam��");
						break;
					case 7:
						emirListesi.listele("verilmeTarihi");
						break;
					case 8:
						emirListesi.listele("uygulamaTarihi");
						break;
					case 9:
						emirListesi.listele("emirVeren");
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
							"\n\t\t<Emir Kay�t Program�>\t\t\t<" + bugun.tarihAl() + ">\n" 
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
						komutanListesi.ekle();
						break;
					case 2:
						komutanListesi.sil();
						break;
					case 3:
						komutanListesi.bilgiGuncelle();
						break;
					case 4:
						komutanListesi.listele("hepsi");
						break;
					case 5:
						komutanListesi.listele("A");
						break;
					case 6:
						komutanListesi.listele("B");
						break;
					case 7:
						komutanListesi.listele("apolet");
						break;
					case 8:
						komutanListesi.listele("ad");
						break;
					case 9:
						komutanListesi.listele("soyad");
						break;
					case 10:
						komutanListesi.listele("rutbe");
						break;
					case 0:
						cikis = true;
						break;
					default:
						System.out.println("Ge�erli bir se�im yap�n�z.");
					}
			}
			break;
			
			case 3:
				
				cikis = false;
				while(cikis == false){
					System.out.println(
							"\n\t\t<Emir Kay�t Program�>\t\t\t<" + bugun.tarihAl() + ">\n" 
							+ "\n3. �STAT�ST�KLER"
							+ "\n\t1. Detayl� Arama" 
							+ "\n\t2. Komutan �statistikleri"
							+ "\n\t3. Emir �statistikleri"
							+ "\n\t0. GER�");
					
					int secim = sc.nextInt();
					switch(secim){
					case 1:
						ist.detayliArama(emirListesi);
						break;
					case 2:
						ist.komutanIstatistikleri(emirListesi, komutanListesi);
						break;
					case 3:
						ist.emirIstatistikleri(emirListesi, komutanListesi);
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
