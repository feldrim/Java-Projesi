import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class EmirListesi {
	/*
	 * emirAra() main'e eklenecek emirTekrarla() yeniden yaz�lacak KomutanA ve
	 * KomutanB k�s�tlar� emirEkle()'ye eklenecek
	 */

	Vector<Emir> emirListesi = new Vector<Emir>();
	Vector<Integer> aTipiKomutanEmirleri = new Vector<Integer>(); //g�nsonu al�n�rken bo�alt�lacak
	public static final int LIMIT = 100;

	private Scanner sc = new Scanner(System.in);
	private Komutan emirVeren;
	private Emir temp;
	private int emirTuru;


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
		
		System.out.println("Emri veren: " + emirVeren.kimlikAl() + "\n");
		
		if(emirVeren.komutanTuruAl().equals("KomutanA")){
			
			int bireyselSayac = 0;//Test verilerini saymad���ndan sorun oluyor. Dinamik yapmak laz�m.
			aTipiKomutanEmirleri.add(emirVeren.apoletNumaras�Al());
			
			for(int i = 0; i < aTipiKomutanEmirleri.size(); i++){
				if(aTipiKomutanEmirleri.contains(emirVeren.apoletNumaras�Al())){
					bireyselSayac++;
				}
			}
			
			if(bireyselSayac == 3){
				System.out.println("A Tipi bir komutan ayn� g�n i�inde 2'den fazla emir veremez.");
				aTipiKomutanEmirleri.remove(aTipiKomutanEmirleri.size() - 1);
				return;
			}
			
			if(aTipiKomutanEmirleri.size() == 6){
				System.out.println("A Tipi komutanlar ayn� g�n i�inde toplamda 5'ten fazla emir veremezler.");
				aTipiKomutanEmirleri.remove(aTipiKomutanEmirleri.size() - 1);
				return;
			}
		
			System.out.println("Bug�n " + emirVeren.kimlikAl() + " taraf�ndan verilen " + bireyselSayac + ". emir.");
		}

		System.out.println("Emir No: " + (emirListesi.size() + 1));

		System.out.println("1. Temizlik Emri\n2. Spor Emri");
		int secim = sc.nextInt();
		
		if(emirVeren.komutanTuruAl().equals("KomutanB")) {			
			for(int i = emirListesi.size() - 1 ; i >= 0 ; i--){
				if(emirListesi.get(i).emirVerenKomutanAl().apoletNumaras�Al() == apolet){
					if((emirListesi.get(i).getClass().getName() == "TemizlikEmri" && secim == 1) ||
					   (emirListesi.get(i).getClass().getName() == "SporEmri" && secim == 2)){
						
						System.out.println("Bir �nceki emrinizden farkl� bir t�rde bir emir vermelisiniz.");
						System.out.println("Bir �nceki emriniz:\n" + emirListesi.get(i).emirOzeti());
						return;
					}
				}
			}
		}

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
		
		emirTuru = secim;

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

	public void emirListesiYazdir() {
		if (emirListesi.isEmpty()) {
			System.out.println("Emir listesi bo�");
		} else {
			System.out.println("Kay�tl� emirler: (" + emirListesi.size() + "/" + LIMIT + ")");
			
			
			Iterator<Emir> it = emirListesi.iterator();
			while (it.hasNext())
				System.out.println("* " + it.next().emirOzeti());
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

	public void emirTekrarla(int tekrar, int periyot) {
		if(tekrar > 5){
			System.out.println("En fazla 5 kez tekrar edebilirsiniz. Emriniz 5 tekrar olarak al�nm��t�r.");
			tekrar = 5;
		}
		emirListesi.add(temp);
		
		for(int i = 1 ; i < tekrar; i++){
			
			if(emirTuru == 1){
				emirListesi.add(new TemizlikEmri());
				((TemizlikEmri)emirListesi.lastElement()).emirNoBelirle(emirListesi.get(emirListesi.size() - 2).emirNoAl() + 1);
				((TemizlikEmri)emirListesi.lastElement()).verilmeTarihiBelirle(emirListesi.get(emirListesi.size() - 2).verilmeTarihiAl());
				((TemizlikEmri)emirListesi.lastElement()).uygulamaTarihiBelirle(emirListesi.get(emirListesi.size() - 2).uygulamaTarihiAl().gunSonra(periyot));
				((TemizlikEmri)emirListesi.lastElement()).emirVerenKomutanBelirle(emirListesi.get(emirListesi.size() - 2).emirVerenKomutanAl());
				((TemizlikEmri)emirListesi.lastElement()).uygulamaDurumuBelirle(emirListesi.get(emirListesi.size() - 2).uygulamaDurumuAl());
				((TemizlikEmri)emirListesi.lastElement()).bolgeAdiBelirle( ( (TemizlikEmri)emirListesi.get(emirListesi.size() - 2)).bolgeAdiAl());
				((TemizlikEmri)emirListesi.lastElement()).temizlikTuruBelirle( ( (TemizlikEmri)emirListesi.get(emirListesi.size() - 2)).temizlikTuruAl());
				((TemizlikEmri)emirListesi.lastElement()).kisiSayisiBelirle( ( (TemizlikEmri)emirListesi.get(emirListesi.size() - 2)).kisiSayisiAl());
				
			} else {
				emirListesi.add(new SporEmri());
				((SporEmri)emirListesi.lastElement()).emirNoBelirle(emirListesi.get(emirListesi.size() - 2).emirNoAl() + 1);
				((SporEmri)emirListesi.lastElement()).verilmeTarihiBelirle(emirListesi.get(emirListesi.size() - 2).verilmeTarihiAl());
				((SporEmri)emirListesi.lastElement()).uygulamaTarihiBelirle(emirListesi.get(emirListesi.size() - 2).uygulamaTarihiAl().gunSonra(periyot));
				((SporEmri)emirListesi.lastElement()).emirVerenKomutanBelirle(emirListesi.get(emirListesi.size() - 2).emirVerenKomutanAl());
				((SporEmri)emirListesi.lastElement()).uygulamaDurumuBelirle(emirListesi.get(emirListesi.size() - 2).uygulamaDurumuAl());
				((SporEmri)emirListesi.lastElement()).hareketTuruBelirle( ( (SporEmri)emirListesi.get(emirListesi.size() - 2)).hareketTuruAl());
				((SporEmri)emirListesi.lastElement()).tekrarSayisiBelirle( ( (SporEmri)emirListesi.get(emirListesi.size() - 2)).tekrarSayisiAl());
			}
			
		}

		switch(periyot){
		case 0:
			System.out.println(emirListesi.lastElement().emirOzeti() + " olu�turuldu");
			break;
		case 1:
			System.out.println(emirListesi.lastElement().emirOzeti() + ",\n g�nl�k olarak " + tekrar + " tekrar olacak �ekilde olu�turuldu.");
			break;
		case 7:
			System.out.println(emirListesi.lastElement().emirOzeti() + ",\nhaftada bir kez " + tekrar + " tekrar olacak �ekilde olu�turuldu.");
			break;
		case 30:
			System.out.println(emirListesi.lastElement().emirOzeti() + ",\nayda bir kez " + tekrar + " tekrar olacak �ekilde olu�turuldu.");
			break;
		}
	}

	public void gunSonu(Tarih bugun) {
		
		aTipiKomutanEmirleri.clear();
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
		testListesi[2] = new TemizlikEmri(3, bugun, bugun.gunSonra(1), komutanListesi.komutanAl(3004), false, "avlu", 1,
				7);
		testListesi[3] = new SporEmri(4, bugun, bugun.gunSonra(1), komutanListesi.komutanAl(3005), false, "��nav", 50);

		for (int i = 0; i < testListesi.length; i++) {
			emirListesi.add(testListesi[i]);
			if(testListesi[i].emirVerenKomutanAl().getClass().getName() == "KomutanA"){
				aTipiKomutanEmirleri.add(testListesi[i].emirVerenKomutanAl().apoletNumaras�Al());
			}
		}
		
		
		
		
		System.out.println("Test verisi �retildi.");

	}
}
