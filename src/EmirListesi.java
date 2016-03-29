import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class EmirListesi {

	Vector<Emir> emirListesi = new Vector<Emir>();
	Vector<Integer> aTipiKomutanEmirleri = new Vector<Integer>(); //günsonu alýnýrken boþaltýlacak
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
			System.out.println("Emri Veren Komutanýn Apolet Numarasý: ");
			apolet = sc.nextInt();
			if (apolet == 0) {
				return;
			} else if (!komutanListesi.komutanMevcutMu(apolet)) {
				System.out.println("Komutan Bulunamadý.");
			}
		} while (!komutanListesi.komutanMevcutMu(apolet));

		emirVeren = komutanListesi.komutanAl(apolet);
		
		System.out.println("Emri veren: " + emirVeren.kimlikAl() + "\n");
		
		if(emirVeren.komutanTuruAl().equals("KomutanA")){//KomutanA kýsýtlarý
			
			int bireyselSayac = 0;
					
			for(int i = 0; i < aTipiKomutanEmirleri.size(); i++){
				if(aTipiKomutanEmirleri.contains(emirVeren.apoletNumarasýAl())){
					bireyselSayac++;
				}
			}
			
			if(bireyselSayac == 3){
				System.out.println("A Tipi bir komutan ayný gün içinde 2'den fazla emir veremez.");
				aTipiKomutanEmirleri.remove(aTipiKomutanEmirleri.size() - 1);
				return;
			}
			
			if(aTipiKomutanEmirleri.size() == 6){
				System.out.println("A Tipi komutanlar ayný gün içinde toplamda 5'ten fazla emir veremezler.");
				aTipiKomutanEmirleri.remove(aTipiKomutanEmirleri.size() - 1);
				return;
			}
		
			System.out.println("Bugün " + emirVeren.kimlikAl() + " tarafýndan verilen " + bireyselSayac + ". emir.");
			
			aTipiKomutanEmirleri.add(emirVeren.apoletNumarasýAl());
		}

		System.out.println("Emir No: " + (emirListesi.size() + 1));

		System.out.println("1. Temizlik Emri\n2. Spor Emri");
		int secim = sc.nextInt();
		
		if(emirVeren.komutanTuruAl().equals("KomutanB")) {	//KomutanB kýsýtý		
			for(int i = emirListesi.size() - 1 ; i >= 0 ; i--){
				if(emirListesi.get(i).emirVerenKomutanAl().apoletNumarasýAl() == apolet){
					if((emirListesi.get(i).emirTuruAl() == "TemizlikEmri" && secim == 1) ||
					   (emirListesi.get(i).emirTuruAl() == "SporEmri" && secim == 2)){
						
						System.out.println("Bir önceki emrinizden farklý bir türde bir emir vermelisiniz.");
						System.out.println("Bir önceki emriniz:\n" + emirListesi.get(i).emirOzeti());
						return;
					}
				}
			}
		}

		boolean gecerliSecim = false;
		do {
			switch (secim) {

			case 1:

				System.out.println("Temizlik yapýlacak bölge: ");
				String bolgeAdi = sc.next();
				System.out.println("Temizlik türü: (1. Mýntýka, 2. Kýþ, 3. Peyzaj)");
				int temizlikTuru = sc.nextInt();
				System.out.println("Temizlik yapacak kiþi sayýsý:");
				int kisiSayisi = sc.nextInt();
				temp = new TemizlikEmri((emirListesi.size() + 1), bugun, null, emirVeren, false, bolgeAdi, temizlikTuru,
						kisiSayisi);
				gecerliSecim = true;
				break;

			case 2:
				System.out.println("Açýklama: ");
				String hareketTuru = sc.next();
				
				int tekrarSayisi;
				do{
					System.out.println("Tekrar sayýsý: ");
					tekrarSayisi = sc.nextInt();
					if(tekrarSayisi >= 100)
						System.out.println("Tekrar sayýsý 100'den fazla olamaz.");
				}while(tekrarSayisi >= 100);
				
				
				
				
				
				temp = new SporEmri((emirListesi.size() + 1), bugun, null, emirVeren, false, hareketTuru, tekrarSayisi);
				gecerliSecim = true;
				break;

			default:
				System.out.println("Geçerli bir giriþ yapýnýz.");
				gecerliSecim = false;
			}
		} while (!gecerliSecim);
		
		Tarih uygulamaTarihi = new Tarih();

		do {
			System.out.println("Emir Uygulama Tarihi:       (Bugün: " + bugun.tarihAl() + ")");
			uygulamaTarihi = uygulamaTarihi.tarihAyarla();

			if (bugun.gecerliTarih(uygulamaTarihi) == false) {
				System.out.println("Geçerli bir tarih giriniz.");
			}
		} while (bugun.gecerliTarih(uygulamaTarihi) == false);
		
		temp.uygulamaTarihiBelirle(uygulamaTarihi);

		gecerliSecim = false;

		do {
			System.out.println("\n\nEmri tekrarlamak istiyor musunuz?" 
								+ "\n0.  Hayýr" 
								+ "\n1. Günlük" 
								+ "\n2. Haftalýk"
								+ "\n3. Aylýk");

			secim = sc.nextInt();
			int tekrar;

			switch (secim) {
			case 0:
				emirTekrarla(1, 0);
				gecerliSecim = true;
				break;
			case 1:
				System.out.println("Tekrar sayýsý:");
				tekrar = sc.nextInt();
				emirTekrarla(tekrar, 1);
				gecerliSecim = true;
				break;
			case 2:
				System.out.println("Tekrar sayýsý:");
				tekrar = sc.nextInt();
				emirTekrarla(tekrar, 7);
				gecerliSecim = true;
				break;
			case 3:
				System.out.println("Tekrar sayýsý:");
				tekrar = sc.nextInt();
				emirTekrarla(tekrar, 30);
				gecerliSecim = true;
				break;
			default:
				System.out.println("Geçerli bir giriþ yapýnýz.");
				gecerliSecim = false;

			}

		} while (!gecerliSecim);

	}

	public void emirListesiYazdir() {
		if (emirListesi.isEmpty()) {
			System.out.println("Emir listesi boþ");
		} else {
			System.out.println("Kayýtlý emirler: (" + emirListesi.size() + "/" + LIMIT + ")");
			
			
			Iterator<Emir> it = emirListesi.iterator();
			while (it.hasNext())
				System.out.println("* " + it.next().emirOzeti());
			}
	}

	public void emirAra(int emirNo) {
		if (emirNo > emirListesi.size()) {
			System.out.println("Emir bulunamadý.");
		} else {
			System.out.println("Emir bulundu:\n" + emirListesi.get(emirNo - 1).emirMetni());
		}
	}

	public void emirSil() {
		System.out.println("Silinecek emir numarasýný yazýn: ");
		int emirNo = sc.nextInt();

		if (emirNo > emirListesi.size() || emirNo < 1) {
			System.out.println("Emir bulunamadý.");
		} else {
			emirListesi.remove(emirListesi.get(emirNo - 1));
			System.out.println("Emir silindi.");
		}
	}

	public void emirTekrarla(int tekrar, int periyot) {
		if(tekrar > 5){
			System.out.println("En fazla 5 kez tekrar edebilirsiniz. Emriniz 5 tekrar olarak alýnmýþtýr.");
			tekrar = 5;
		}
		emirListesi.add(temp);
		
		for(int i = 1 ; i < tekrar; i++){
			
			if(temp.emirTuruAl() == "TemizlikEmri"){
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
			System.out.println(emirListesi.lastElement().emirOzeti() + " oluþturuldu");
			break;
		case 1:
			System.out.println(emirListesi.lastElement().emirOzeti() + ",\n günlük olarak " + tekrar + " tekrar olacak þekilde oluþturuldu.");
			break;
		case 7:
			System.out.println(emirListesi.lastElement().emirOzeti() + ",\nhaftada bir kez " + tekrar + " tekrar olacak þekilde oluþturuldu.");
			break;
		case 30:
			System.out.println(emirListesi.lastElement().emirOzeti() + ",\nayda bir kez " + tekrar + " tekrar olacak þekilde oluþturuldu.");
			break;
		}
	}

	public void gunSonu(Tarih bugun) {
		
		aTipiKomutanEmirleri.clear();
		int bugunVerilenEmirSayisi = 0;
		int bugunTamamlananEmirSayisi = 0;
		System.out.println("Gün sonu alýnýyor.");

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
		
		System.out.println("\n" + bugun.tarihAl() + " tarihinde " + bugunVerilenEmirSayisi + " emir verilmiþ, "
				+ bugunTamamlananEmirSayisi + " emir tamamlanmýþtýr.");
	}

	public void testVerisiUret(Tarih bugun, KomutanListesi komutanListesi) {
		
		komutanListesi.testVerisiUret();
		
		Vector<Emir> testListesi = new Vector<Emir>();
		testListesi.add( new TemizlikEmri(1, bugun, bugun, komutanListesi.komutanAl(3001), false, "bahçe", 1, 5) );
		testListesi.add( new SporEmri(2, bugun, bugun, komutanListesi.komutanAl(3002), false, "Mekik", 50) );
		testListesi.add( new TemizlikEmri(3, bugun, bugun.gunSonra(1), komutanListesi.komutanAl(3004), false, "avlu", 1,7) );
		testListesi.add( new SporEmri(4, bugun, bugun.gunSonra(1), komutanListesi.komutanAl(3005), false, "Þýnav", 50) );
		testListesi.add( new TemizlikEmri(5, bugun, bugun.gunSonra(2), komutanListesi.komutanAl(3004), false, "avlu", 1,7) );
		testListesi.add( new TemizlikEmri(6, bugun, bugun.gunSonra(3), komutanListesi.komutanAl(3006), false, "yol", 1,7) );
			
		Iterator<Emir> it = testListesi.iterator();
		while(it.hasNext()){
			if ( ( (TemizlikEmri)it).emirVerenKomutanAl().komutanTuruAl() == "KomutanA"){
				
				aTipiKomutanEmirleri.add(( (TemizlikEmri)it).emirVerenKomutanAl().apoletNumarasýAl());
				
			} else if ( ( (SporEmri)it).emirVerenKomutanAl().komutanTuruAl() == "KomutanA"){
				
				aTipiKomutanEmirleri.add(( (SporEmri)it).emirVerenKomutanAl().apoletNumarasýAl());
			}
		}
		
		System.out.println("Test verisi üretildi.");

	}
}
