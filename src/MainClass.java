import java.util.Scanner;

/**
 * Java Uygulama Projesi
 * Zafer Balkan
 * 
 * 
 * Sorunlar:
 * 1. Emir tekrarý yapýldýðýnda ekrana emirleri doðru numaralarýyla yazdýrýyor. 
 * Ancak emirleri listelediðimizde yeni emirlerin hepsitekrarlanan son emrin numarasýný almýþ olarak görüntüleniyor.
 * 2. Bilgi güncelle menüsünde komutanýn türü deðiþmiyor.
 * 
 * 
 * Geliþtirmeler:
 * 1. Emir arama, komutan arama metorlarý yazýldý, menüye eklenecek
 * 2. Komutan A ve B kýsýtlarýný statik yapmak yerine Komutan sýnýfý içine
 * bir emirVer() metodu yazýp KomutanA ve KomutanB tarafýndan override etsek, 
 * her biri kendi kontrolünü yapsa olur mu? (emirVer(), emirEkle()'yi çaðýracak,
 * apolet numarasý sorgusunu komutanListesi ya da emirListesi içinde yapmayý 
 * gerektirebilir)
 * 3. Emir Listele menüsü ayrýntýlandýrýlacak: Uygulanan, uygulanmayan,
 * bugün uygulanacak, bugün verilen, x komutan tarafýndan verilen, tekrar eden emirler...
 * 4. Komutan Listesi ayrýntýlandýrýlacak: A tipi komutanlar, B tipi komutanlar,
 * bugün emir veren, hiç emir vermeyen...
 * 5. Tarih girmek gün, ay, yýl ve üç kez enter basýldýðýndan 6 aþamalý. Kýsaltabilir miyiz?
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
					+ "\n1. Emir Ekle"
					+ "\n2. Emir Listele" 
					+ "\n3. Emir Sil" //Debug için geçerli, sonra yalnýz son yazýlan emri silme þeklinde düzeltilecek
					+ "\n4. Komutan Ekle" 
					+ "\n5. Komutan Listele"
					+ "\n6. Komutan Sil" 
					+ "\n7. Bilgi Güncelle" 
					+ "\n8. Test Verisi Üret" 
					+ "\n9. Gün Sonu");

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
				bugun = bugun.gunSonra(1); // emirListesi'nin içine alsak mý?
				break;

			default:
				System.out.println("Geçerli bir seçim yapýnýz.");

			}
		}
	}
}
