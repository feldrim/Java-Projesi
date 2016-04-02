import java.util.Scanner;

/**
 * Java Uygulama Projesi
 * Zafer Balkan
 * 
 * Ýsterler:
 * Tamamý karþýlandý.
 *  
 * Sorunlar:
 *  
 * Geliþtirmeler:
 * 1. Exception yazýlacak. Öncelikle inputlar, ardýndan kýsýtlar.
 * 2. Tarih girmek gün, ay, yýl ve üç kez enter basýldýðýndan 6 aþamalý. Kýsaltabilir miyiz?
 * 3. Ýstatistikler
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
					"\n          <Emir Kayýt Programý>               <" + bugun.tarihAl() + ">\n" 
					+ "\n1. Emir Ýþlemleri"
					+ "\n2. Komutan Ýþlemleri" 
					+ "\n3. Ýstatistikler"
					+ "\n9. Test Verisi Üret" 
					+ "\n0. Gün Sonu");

			int secim1 = sc.nextInt();
			switch (secim1) {

			case 1:
				boolean cikis = false;
				while(cikis == false){
					System.out.println(
							"\n          <Emir Kayýt Programý>               <" + bugun.tarihAl() + ">\n" 
							+ "\n1. EMÝR ÝÞLEMLERÝ"
							+ "\n\t1. Emir Ekle" 
							+ "\n\t2. Emir Sil" //Debug için geçerli, sonra yalnýz son yazýlan emri silme þeklinde düzeltilecek
							+ "\n\t3. Emir Numarasýyla Ara"
							+ "\n\t4. Tüm Emirler" 
							+ "\n\t5. Tüm Uygulanmýþ Emirler"
							+ "\n\t6. Tüm Uygulanmýþ Emirler" 
							+ "\n\t7. Verilme Tarihine Göre Emirler"
							+ "\n\t8. Uygulama Tarihine Göre Emirler" 
							+ "\n\t9. Emir Veren Komutana Göre Emirler" 
							+ "\n\t0. GERÝ");
					
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
						emirListesi.listeYazdir("uygulanmýþ");
						break;
					case 6:
						emirListesi.listeYazdir("uygulanmamýþ");
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
						System.out.println("Geçerli bir seçim yapýnýz.");
					}
			}
			break;

			case 2:
				cikis = false;
				while(cikis == false){
					System.out.println(
							"\n          <Emir Kayýt Programý>               <" + bugun.tarihAl() + ">\n" 
							+ "\n2. KOMUTAN ÝÞLEMLERÝ"
							+ "\n\t1. Komutan Ekle" 
							+ "\n\t2. Komutan Sil"
							+ "\n\t3. Bilgi Güncelle"
							+ "\n\t4. Tüm Komutanlar"
							+ "\n\t5. A Sýnýfý Komutanlar" 
							+ "\n\t6. B Sýnýfý Komutanlar"
							+ "\n\t7. Apolet Numarasýyla Ara" 
							+ "\n\t8. Adýna Göre Ara" 
							+ "\n\t9. Soyadýna Göre Ara"
							+ "\n\t10. Rütbeye Göre Ara"
							+ "\n\t0. GERÝ");
					
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
						System.out.println("Geçerli bir seçim yapýnýz.");
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
				System.out.println("Geçerli bir seçim yapýnýz.");

			}
		}
	}
}
