import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class EmirListesi {

	Vector<Emir> emirListesi = new Vector<Emir>();
	Vector<Integer> emirVerenAtipiKomutanlar = new Vector<Integer>(); // KomutanListesi'ne
																		// atsak
																		// m�?
	public static final int LIMIT = 100;

	private Scanner sc = new Scanner(System.in);
	private Komutan emirVeren;
	private Emir temp;

	public EmirListesi() {
	}

	public void ekle(Tarih bugun, KomutanListesi komutanListesi) throws Exception {
		int apolet = 0;

		if (emirListesi.size() == LIMIT) {
			System.out.println("Daha fazla emir ekleyemezsiniz.");
			return;
		}

		// Deneme maksatl� multiple try-catch blo�u kullan�ld�. Ba�ka bir yerde
		// kullan�lmayacak
		do {
			try {
				System.out.println("Emri Veren Komutan�n Apolet Numaras�: ");
				apolet = sc.nextInt();

				if (!komutanListesi.komutanMevcutMu(apolet)) {
					throw new Exception("Komutan Bulunamad�.");
				}
				break;

			} catch (InputMismatchException e) {
				System.out.println("Ge�erli bir say� giriniz.");
				// System.out.println(e.toString());
				sc.next();

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}

		} while (true);

		emirVeren = komutanListesi.komutanAl(apolet);

		System.out.println("Emri veren: " + emirVeren.kimlikAl() + "\n");

		komutanKisitlariKontrolu(emirVeren); // KomutanA k�s�tlar� kontrol�

		System.out.println("Emir No: " + (emirListesi.size() + 1));

		System.out.println("1. Temizlik Emri\n2. Spor Emri");
		int secim = sc.nextInt();

		komutanKisitlariKontrolu(emirVeren); // KomutanB k�s�tlar� kontrol�

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
				System.out.println("Hareket T�r�: (1. ��nav, 2. Mekik, 3. Barfiks)");
				int hareketTuru = sc.nextInt();

				int tekrarSayisi;
				do {
					System.out.println("Tekrar say�s�: ");
					tekrarSayisi = sc.nextInt();
					if (tekrarSayisi >= 100)
						System.out.println("Tekrar say�s� 100'den fazla olamaz.");
				} while (tekrarSayisi >= 100);

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
				emirTekrarla(1, 0);
				gecerliSecim = true;
				break;
			case 1:
				System.out.println("Tekrar say�s�:");
				tekrar = sc.nextInt();
				emirTekrarla(tekrar, 1);
				gecerliSecim = true;
				break;
			case 2:
				System.out.println("Tekrar say�s�:");
				tekrar = sc.nextInt();
				emirTekrarla(tekrar, 7);
				gecerliSecim = true;
				break;
			case 3:
				System.out.println("Tekrar say�s�:");
				tekrar = sc.nextInt();
				emirTekrarla(tekrar, 30);
				gecerliSecim = true;
				break;
			default:
				System.out.println("Ge�erli bir giri� yap�n�z.");
				gecerliSecim = false;

			}

		} while (!gecerliSecim);

	}

	public void listele(String listelemeKosulu) {

		Iterator<Emir> it = emirListesi.iterator();// di�er ko�ullarla birlikte
													// sorun ��kard�
		Tarih sorgulanacakTarih = new Tarih();
		Komutan emirVeren = null;

		if (emirListesi.isEmpty()) {
			System.out.println("Emir listesi bo�");
			return;
		}

		switch (listelemeKosulu) {
		case "hepsi":
			System.out.println("Kay�tl� emirler: (" + emirListesi.size() + "/" + LIMIT + ")");

			while (it.hasNext())
				System.out.println("* " + it.next().emirOzeti());
			break;

		case "emirNo":
			System.out.println("Emir numaras� girin:");
			int emirNo = sc.nextInt();

			if (emirNo > emirListesi.size()) {
				System.out.println("Sistemde bu numara ile kay�tl� bir emir yoktur.");
			}

			for (int i = 0; i < emirListesi.size(); i++) {
				if (emirListesi.get(i).emirNoAl() == emirNo)
					System.out.println("* " + emirListesi.get(i).emirMetni());
			}

			break;

		case "uygulanm��":
			System.out.println("Uygulanm�� emirler:");

			for (int i = 0; i < emirListesi.size(); i++) {
				if (emirListesi.get(i).uygulamaDurumuAl() == true)
					System.out.println("* " + emirListesi.get(i).emirOzeti());
			}

			break;

		case "uygulanmam��":
			System.out.println("Uygulanmam�� emirler:");

			for (int i = 0; i < emirListesi.size(); i++) {
				if (emirListesi.get(i).uygulamaDurumuAl() == false)
					System.out.println("* " + emirListesi.get(i).emirOzeti());
			}
			break;

		case "verilmeTarihi":
			sorgulanacakTarih = sorgulanacakTarih.tarihAyarla();
			System.out.println("Verilme Tarihi " + sorgulanacakTarih.tarihAl() + " Olan Emirler:");

			for (int i = 0; i < emirListesi.size(); i++) {
				if (emirListesi.get(i).verilmeTarihiAl().tarihAl().equals(sorgulanacakTarih.tarihAl()))
					System.out.println("* " + emirListesi.get(i).emirOzeti());
			}

			break;

		case "uygulamaTarihi":
			sorgulanacakTarih = sorgulanacakTarih.tarihAyarla();
			System.out.println("Uygulama Tarihi " + sorgulanacakTarih.tarihAl() + " Olan Emirler:");

			for (int i = 0; i < emirListesi.size(); i++) {
				if (emirListesi.get(i).uygulamaTarihiAl().tarihAl().equals(sorgulanacakTarih.tarihAl()))
					System.out.println("* " + emirListesi.get(i).emirOzeti());
			}

			break;

		case "emirVeren":
			System.out.println("Apolet numaras� girin:");
			int apolet = sc.nextInt();

			for (int i = 0; i < emirListesi.size(); i++) {
				if (emirListesi.get(i).emirVerenKomutanAl().apoletNumaras�Al() == apolet) {
					emirVeren = emirListesi.get(i).emirVerenKomutanAl();

				}
			}

			if (emirVeren == null) {
				System.out.println("Sistemde bu numarayla kay�tl� bir komutan yok.");
				break;
			}

			System.out.println(emirVeren.kimlikAl() + " Taraf�ndan Verilen Emirler:");
			for (int i = 0; i < emirListesi.size(); i++) {
				if (emirListesi.get(i).emirVerenKomutanAl().kimlikAl().equals(emirVeren.kimlikAl())) {
					System.out.println("* " + emirListesi.get(i).emirOzeti());
				}
			}

			break;

		}
	}

	public void sil() {

		if (emirListesi.isEmpty()) {
			System.out.println("Emir listesi bo�");
			return;
		}

		System.out.println("Silinecek emir numaras�n� yaz�n: ");
		int emirNo = sc.nextInt();

		if (emirNo > emirListesi.size() || emirNo < 1) {
			System.out.println("Emir bulunamad�.");
		} else {
			emirListesi.remove(emirListesi.get(emirNo - 1));
			System.out.println("Emir silindi.");
		}
	}

	public void emirTekrarla(int tekrar, int periyot) {
		if (tekrar > 5) {
			System.out.println("En fazla 5 kez tekrar edebilirsiniz. Emriniz 5 tekrar olarak al�nm��t�r.");
			tekrar = 5;
		}
		emirListesi.add(temp);

		for (int i = 1; i < tekrar; i++) {

			if (temp.emirTuruAl() == "TemizlikEmri") {
				emirListesi.add(new TemizlikEmri());
				((TemizlikEmri) emirListesi.lastElement())
						.emirNoBelirle(emirListesi.get(emirListesi.size() - 2).emirNoAl() + 1);
				((TemizlikEmri) emirListesi.lastElement())
						.verilmeTarihiBelirle(emirListesi.get(emirListesi.size() - 2).verilmeTarihiAl());
				((TemizlikEmri) emirListesi.lastElement()).uygulamaTarihiBelirle(
						emirListesi.get(emirListesi.size() - 2).uygulamaTarihiAl().gunSonra(periyot));
				((TemizlikEmri) emirListesi.lastElement())
						.emirVerenKomutanBelirle(emirListesi.get(emirListesi.size() - 2).emirVerenKomutanAl());
				((TemizlikEmri) emirListesi.lastElement())
						.uygulamaDurumuBelirle(emirListesi.get(emirListesi.size() - 2).uygulamaDurumuAl());
				((TemizlikEmri) emirListesi.lastElement())
						.bolgeAdiBelirle(((TemizlikEmri) emirListesi.get(emirListesi.size() - 2)).bolgeAdiAl());
				((TemizlikEmri) emirListesi.lastElement())
						.temizlikTuruBelirle(((TemizlikEmri) emirListesi.get(emirListesi.size() - 2)).temizlikTuruAl());
				((TemizlikEmri) emirListesi.lastElement())
						.kisiSayisiBelirle(((TemizlikEmri) emirListesi.get(emirListesi.size() - 2)).kisiSayisiAl());

			} else {
				emirListesi.add(new SporEmri());
				((SporEmri) emirListesi.lastElement())
						.emirNoBelirle(emirListesi.get(emirListesi.size() - 2).emirNoAl() + 1);
				((SporEmri) emirListesi.lastElement())
						.verilmeTarihiBelirle(emirListesi.get(emirListesi.size() - 2).verilmeTarihiAl());
				((SporEmri) emirListesi.lastElement()).uygulamaTarihiBelirle(
						emirListesi.get(emirListesi.size() - 2).uygulamaTarihiAl().gunSonra(periyot));
				((SporEmri) emirListesi.lastElement())
						.emirVerenKomutanBelirle(emirListesi.get(emirListesi.size() - 2).emirVerenKomutanAl());
				((SporEmri) emirListesi.lastElement())
						.uygulamaDurumuBelirle(emirListesi.get(emirListesi.size() - 2).uygulamaDurumuAl());
				((SporEmri) emirListesi.lastElement())
						.hareketTuruBelirle(((SporEmri) emirListesi.get(emirListesi.size() - 2)).hareketTuruAl());
				((SporEmri) emirListesi.lastElement())
						.tekrarSayisiBelirle(((SporEmri) emirListesi.get(emirListesi.size() - 2)).tekrarSayisiAl());
			}

		}

		switch (periyot) {
		case 0:
			System.out.println(emirListesi.lastElement().emirOzeti() + " olu�turuldu");
			break;
		case 1:
			System.out.println(emirListesi.lastElement().emirOzeti() + ",\n g�nl�k olarak " + tekrar
					+ " tekrar olacak �ekilde olu�turuldu.");
			break;
		case 7:
			System.out.println(emirListesi.lastElement().emirOzeti() + ",\nhaftada bir kez " + tekrar
					+ " tekrar olacak �ekilde olu�turuldu.");
			break;
		case 30:
			System.out.println(emirListesi.lastElement().emirOzeti() + ",\nayda bir kez " + tekrar
					+ " tekrar olacak �ekilde olu�turuldu.");
			break;
		}
	}

	public void gunSonu(Tarih bugun) {

		emirVerenAtipiKomutanlar.clear();
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

		System.out.println("Test verisi olu�turuluyor...");

		komutanListesi.testVerisiUret();

		Vector<Emir> testListesi = new Vector<Emir>();
		testListesi.add(new TemizlikEmri(1, bugun, bugun, komutanListesi.komutanAl(3001), false, "bah�e", 1, 5));
		testListesi.add(new SporEmri(2, bugun, bugun, komutanListesi.komutanAl(3002), false, 2, 50));
		testListesi.add(
				new TemizlikEmri(3, bugun, bugun.gunSonra(1), komutanListesi.komutanAl(3004), false, "avlu", 1, 7));
		testListesi.add(new SporEmri(4, bugun, bugun.gunSonra(1), komutanListesi.komutanAl(3005), false, 1, 50));
		testListesi.add(
				new TemizlikEmri(5, bugun, bugun.gunSonra(2), komutanListesi.komutanAl(3004), false, "avlu", 1, 7));
		testListesi
				.add(new TemizlikEmri(6, bugun, bugun.gunSonra(3), komutanListesi.komutanAl(3006), false, "yol", 1, 7));

		for (int i = 0; i < testListesi.size(); i++) {
			// Debug i�in kullan�lacak
			// System.out.println(testListesi.get(i).emirOzeti());
			if (testListesi.get(i).emirVerenKomutanAl().komutanTuruAl() == "KomutanA") {
				emirVerenAtipiKomutanlar.add(testListesi.get(i).emirVerenKomutanAl().apoletNumaras�Al());
			}
		}

		System.out.println(testListesi.size() + " adet emir olu�turuldu.");

		emirListesi.addAll(testListesi);
		System.out.println("Test verisi �retildi.");

	}

	public void komutanKisitlariKontrolu(Komutan komutan) {

		if (komutan.komutanTuruAl().equals("KomutanA")) {

			int bireyselSayac = 0;

			for (int i = 0; i < emirVerenAtipiKomutanlar.size(); i++) {
				if (emirVerenAtipiKomutanlar.contains(komutan.apoletNumaras�Al())) {
					bireyselSayac++;
				}
			}

			if (bireyselSayac == 3) {
				System.out.println("A Tipi bir komutan ayn� g�n i�inde 2'den fazla emir veremez.");
				emirVerenAtipiKomutanlar.remove(emirVerenAtipiKomutanlar.size() - 1);
				return;
			}

			if (emirVerenAtipiKomutanlar.size() == 6) {
				System.out.println("A Tipi komutanlar ayn� g�n i�inde toplamda 5'ten fazla emir veremezler.");
				emirVerenAtipiKomutanlar.remove(emirVerenAtipiKomutanlar.size() - 1);
				return;
			}

			// Debug i�in a�a��dakini �al��t�rabiliriz.
			// System.out.println("Bug�n " + komutan.kimlikAl() + " taraf�ndan
			// verilen " + bireyselSayac + ". emir.");

			emirVerenAtipiKomutanlar.add(komutan.apoletNumaras�Al());

		} else if (komutan.komutanTuruAl().equals("KomutanB")) {

			for (int i = emirListesi.size() - 1; i >= 0; i--) {
				if (emirListesi.get(i).emirVerenKomutanAl().apoletNumaras�Al() == komutan.apoletNumaras�Al()) {
					if ((emirListesi.get(i).emirTuruAl() == "TemizlikEmri")
							|| (emirListesi.get(i).emirTuruAl() == "SporEmri")) {
						System.out.println("Bir �nceki emrinizden farkl� bir t�rde bir emir vermelisiniz.");
						System.out.println("Bir �nceki emriniz:\n" + emirListesi.get(i).emirOzeti());
						return;
					}
				}
			}
		}

	}

}
