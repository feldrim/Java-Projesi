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

	public static void main(String[] args) throws Exception{

		KomutanListesi komutanListesi = new KomutanListesi();
		EmirListesi emirListesi = new EmirListesi();
		Tarih bugun = new Tarih();
		Ýstatistikler ist = new Ýstatistikler();

		Scanner sc = new Scanner(System.in);

		bugun = bugun.tarihAyarla();

		while (true) {
			System.out.println(
					"\n\t\t<Emir Kayýt Programý>\t\t\t<" + bugun.tarihAl() + ">\n" 
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
							"\n\t\t<Emir Kayýt Programý>\t\t\t<" + bugun.tarihAl() + ">\n" 
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
						emirListesi.listele("uygulanmýþ");
						break;
					case 6:
						emirListesi.listele("uygulanmamýþ");
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
						System.out.println("Geçerli bir seçim yapýnýz.");
					}
			}
			break;

			case 2:
				cikis = false;
				while(cikis == false){
					System.out.println(
							"\n\t\t<Emir Kayýt Programý>\t\t\t<" + bugun.tarihAl() + ">\n" 
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
						System.out.println("Geçerli bir seçim yapýnýz.");
					}
			}
			break;
			
			case 3:
				
				cikis = false;
				while(cikis == false){
					System.out.println(
							"\n\t\t<Emir Kayýt Programý>\t\t\t<" + bugun.tarihAl() + ">\n" 
							+ "\n3. ÝSTATÝSTÝKLER"
							+ "\n\t1. Detaylý Arama" 
							+ "\n\t2. Komutan Ýstatistikleri"
							+ "\n\t3. Emir Ýstatistikleri"
							+ "\n\t0. GERÝ");
					
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
