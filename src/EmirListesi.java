import java.util.Scanner;
import java.util.Vector;

public class EmirListesi {
	/*
	 * emirAra() main'e eklenecek emirTekrarla() yeniden yaz�lacak KomutanA ve
	 * KomutanB k�s�tlar� emirEkle()'ye eklenecek
	 */

	Vector<Emir> emirListesi = new Vector<Emir>();
	public static final int LIMIT = 100;

	private Scanner sc = new Scanner(System.in);
	private Komutan emirVeren;
	private Emir temp;

	public EmirListesi() {
	}

	public void emirEkle(Tarih bugun, KomutanListesi komutanListesi) {
		int apolet;
		
		if (emirListesi.size() == LIMIT) {
			System.out.println("Daha fazla emir ekleyemezsiniz.");
			return;
		}

		do {
			System.out.println("Emri Veren Komutan�n Apolet Numaras�: ");
			apolet = sc.nextInt();
			if (apolet == 0) {
				return;
			} else if (!komutanListesi.komutanMevcutMu(apolet)) {
				System.out.println("Komutan Bulunamad�.");
			}
		} while (!komutanListesi.komutanMevcutMu(apolet));

		emirVeren = komutanListesi.komutanAl(apolet);

		System.out.println("Emir No: " + (emirListesi.size() + 1));

		System.out.println("1. Temizlik Emri\n2. Spor Emri");
		int secim = sc.nextInt();

		boolean gecerliSecim = false;
		do {
			switch (secim) {

			case 1:

				System.out.println("Temizlik yap�lacak b�lge: ");
				String bolgeAdi = sc.next();
				System.out.println("Temizlik t�r�: (1. M�nt�ka, 2. K��, 3. Peyzaj)");
				int temizlikTuru = sc.nextInt();
				System.out.println("Temizlik yapacak ki�i say�s�:");
				int kisiSayisi = sc.nextInt();
				temp = new TemizlikEmri((emirListesi.size() + 1), bugun, null, emirVeren, false, bolgeAdi, temizlikTuru,
						kisiSayisi);
				gecerliSecim = true;
				break;

			case 2:
				System.out.println("A��klama: ");
				String hareketTuru = sc.next();
				System.out.println("Tekrar say�s�: ");
				int tekrarSayisi = sc.nextInt();
				temp = new SporEmri((emirListesi.size() + 1), bugun, null, emirVeren, false, hareketTuru, tekrarSayisi);
				gecerliSecim = true;
				break;

			default:
				System.out.println("Ge�erli bir giri� yap�n�z.");
				gecerliSecim = false;
			}
		} while (!gecerliSecim);

		Tarih uygulamaTarihi = new Tarih();

		do {
			System.out.println("Emir Uygulama Tarihi:       (Bug�n: " + bugun.tarihAl() + ")");
			uygulamaTarihi = uygulamaTarihi.tarihAyarla();

			if (bugun.gecerliTarih(uygulamaTarihi) == false) {
				System.out.println("Ge�erli bir tarih giriniz.");
			}
		} while (bugun.gecerliTarih(uygulamaTarihi) == false);
		
		temp.uygulamaTarihiBelirle(uygulamaTarihi);

		gecerliSecim = false;

		do {
			System.out.println("\n\nEmri tekrarlamak istiyor musunuz?" + "\n0.  Hay�r" + "\n1. G�nl�k" + "\n2. Haftal�k"
					+ "\n3. Ayl�k");

			secim = sc.nextInt();
			int tekrar;

			switch (secim) {
			case 0:
				sonEmriTekrarla(1, 1);
				gecerliSecim = true;
				break;
			case 1:
				System.out.println("Tekrar say�s�:");
				tekrar = sc.nextInt();
				sonEmriTekrarla(tekrar, 1);
				gecerliSecim = true;
				break;
			case 2:
				System.out.println("Tekrar say�s�:");
				tekrar = sc.nextInt();
				sonEmriTekrarla(tekrar, 7);
				gecerliSecim = true;
				break;
			case 3:
				System.out.println("Tekrar say�s�:");
				tekrar = sc.nextInt();
				sonEmriTekrarla(tekrar, 30);
				gecerliSecim = true;
				break;
			default:
				System.out.println("Ge�erli bir giri� yap�n�z.");
				gecerliSecim = false;

			}

		} while (!gecerliSecim);

	}

	public void emirListesiYazdir() {
		if (emirListesi.isEmpty()) {
			System.out.println("Emir listesi bo�");
		} else {
			System.out.println("Kay�tl� emirler: (" + emirListesi.size() + "/" + LIMIT + ")");
			for (int i = 0; i < emirListesi.size(); i++) {
				System.out.println("* " + emirListesi.get(i).emirMetni());
			}
		}
	}

	public void emirAra(int emirNo) {
		if (emirNo > emirListesi.size()) {
			System.out.println("Emir bulunamad�.");
		} else {
			System.out.println("Emir bulundu:\n" + emirListesi.get(emirNo - 1).emirMetni());
		}
	}

	public void emirSil() {
		System.out.println("Silinecek emir numaras�n� yaz�n: ");
		int emirNo = sc.nextInt();

		if (emirNo > emirListesi.size() || emirNo < 1) {
			System.out.println("Emir bulunamad�.");
		} else {
			emirListesi.remove(emirListesi.get(emirNo - 1));
			System.out.println("Emir silindi.");
		}
	}

	public void sonEmriTekrarla(int tekrar, int periyot) {
		if(tekrar > 5){
			System.out.println("En fazla 5 kez tekrar edebilirsiniz. Emriniz 5 tekrar olarak al�nm��t�r.");
			tekrar = 5;
		}
		
		emirListesi.add(temp);
		
		System.out.println("Emir Kaydedildi:\n" + emirListesi.lastElement().emirMetni());

		for (int i = 1; i < tekrar; i++) {
			/**
			 * 1. Son eklenen emri kopyala
			 * 2. Son eklenen emrin (art�k kendisi), uygulama tarihini belirlenen periyot kadar ilerlet
			 *  ve son emrin uygulama tarihine ata
			 * 3. Emir numaras�n� bir artt�rarak ata.
			 * */
			emirListesi.addElement(emirListesi.lastElement());
			
			emirListesi.lastElement().uygulamaTarihiBelirle(emirListesi.lastElement().uygulamaTarihiAl().gunSonra(periyot));
			
			emirListesi.lastElement().emirNoBelirle(emirListesi.lastElement().emirNoAl() + 1);
			
			System.out.println(emirListesi.lastElement().emirMetni());
		}
		
		System.out.println(tekrar + " adet emir olu�turuldu.");
	}

	public void gunSonu(Tarih bugun) {

		int bugunVerilenEmirSayisi = 0;
		int bugunTamamlananEmirSayisi = 0;
		System.out.println("G�n sonu al�n�yor.");

		if (emirListesi.size() == 0) {
			System.out.println("Uygulanacak emir yok.");
		} else {
			for (int i = 0; i < emirListesi.size(); i++) {
				if (emirListesi.get(i).verilmeTarihiAl() == bugun) {
					bugunVerilenEmirSayisi++;
				}

				if (emirListesi.get(i).uygulamaTarihiAl() == bugun) {
					emirListesi.get(i).emriUygula();
					bugunTamamlananEmirSayisi++;
				}
			}

		}
		System.out.println("\n" + bugun.tarihAl() + " tarihinde " + bugunVerilenEmirSayisi + " emir verilmi�, "
				+ bugunTamamlananEmirSayisi + " emir tamamlanm��t�r.");
	}

	public void testVerisiUret(Tarih bugun, KomutanListesi komutanListesi) {
		komutanListesi.testVerisiUret();

		Emir[] testListesi = new Emir[4];
		testListesi[0] = new TemizlikEmri(1, bugun, bugun, komutanListesi.komutanAl(3001), false, "bah�e", 1, 5);
		testListesi[1] = new SporEmri(2, bugun, bugun, komutanListesi.komutanAl(3002), false, "Mekik", 50);
		testListesi[2] = new TemizlikEmri(3, bugun, bugun.gunSonra(1), komutanListesi.komutanAl(3003), false, "avlu", 1,
				7);
		testListesi[3] = new SporEmri(4, bugun, bugun.gunSonra(1), komutanListesi.komutanAl(3004), false, "��nav", 50);

		for (int i = 0; i < testListesi.length; i++) {
			emirListesi.add(testListesi[i]);
		}
		System.out.println("Test verisi �retildi.");

	}
}
