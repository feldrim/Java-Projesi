import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class EmirListesi {

	Vector<Emir> emirListesi = new Vector<Emir>();
	Vector<Integer> emirVerenAtipiKomutanlar = new Vector<Integer>(); //KomutanListesi'ne atsak mý?
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
		
		komutanKisitlariKontrolu(emirVeren); //KomutanA kýsýtlarý kontrolü

		System.out.println("Emir No: " + (emirListesi.size() + 1));

		System.out.println("1. Temizlik Emri\n2. Spor Emri");
		int secim = sc.nextInt();
		
		komutanKisitlariKontrolu(emirVeren); //KomutanB kýsýtlarý kontrolü

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
		
		emirVerenAtipiKomutanlar.clear();
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
		
		System.out.println("Test verisi oluþturuluyor...");
		
		komutanListesi.testVerisiUret();
		
		Vector<Emir> testListesi = new Vector<Emir>();
		testListesi.add( new TemizlikEmri(1, bugun, bugun, komutanListesi.komutanAl(3001), false, "bahçe", 1, 5) );		
		testListesi.add( new SporEmri(2, bugun, bugun, komutanListesi.komutanAl(3002), false, "Mekik", 50) );
		testListesi.add( new TemizlikEmri(3, bugun, bugun.gunSonra(1), komutanListesi.komutanAl(3004), false, "avlu", 1,7) );
		testListesi.add( new SporEmri(4, bugun, bugun.gunSonra(1), komutanListesi.komutanAl(3005), false, "Þýnav", 50) );
		testListesi.add( new TemizlikEmri(5, bugun, bugun.gunSonra(2), komutanListesi.komutanAl(3004), false, "avlu", 1,7) );
		testListesi.add( new TemizlikEmri(6, bugun, bugun.gunSonra(3), komutanListesi.komutanAl(3006), false, "yol", 1,7) );
			
		for(int i = 0 ; i < testListesi.size() ; i++ ){
			System.out.println(testListesi.get(i).emirOzeti());
			if(testListesi.get(i).emirVerenKomutanAl().komutanTuruAl() == "KomutanA" ){
				emirVerenAtipiKomutanlar.add(testListesi.get(i).emirVerenKomutanAl().apoletNumarasýAl());
			}
		}
		
		System.out.println(testListesi.size() + " adet emir oluþturuldu.");	
		
		emirListesi.addAll(testListesi);	
		System.out.println("Test verisi üretildi.");

	}
	
	public void komutanKisitlariKontrolu(Komutan komutan){
		
			if(komutan.komutanTuruAl().equals("KomutanA")){
			
			int bireyselSayac = 0;
					
			for(int i = 0; i < emirVerenAtipiKomutanlar.size(); i++){
				if(emirVerenAtipiKomutanlar.contains(komutan.apoletNumarasýAl())){
					bireyselSayac++;
				}
			}
			
			if(bireyselSayac == 3){
				System.out.println("A Tipi bir komutan ayný gün içinde 2'den fazla emir veremez.");
				emirVerenAtipiKomutanlar.remove(emirVerenAtipiKomutanlar.size() - 1);
				return;
			}
			
			if(emirVerenAtipiKomutanlar.size() == 6){
				System.out.println("A Tipi komutanlar ayný gün içinde toplamda 5'ten fazla emir veremezler.");
				emirVerenAtipiKomutanlar.remove(emirVerenAtipiKomutanlar.size() - 1);
				return;
			}
			
			//Debug için aþaðýdakini çalýþtýrabiliriz.		
			//System.out.println("Bugün " + komutan.kimlikAl() + " tarafýndan verilen " + bireyselSayac + ". emir.");
			
			emirVerenAtipiKomutanlar.add(komutan.apoletNumarasýAl());
			
		} else if(komutan.komutanTuruAl().equals("KomutanB")) {
			
			for(int i = emirListesi.size() - 1 ; i >= 0 ; i--){
				if(emirListesi.get(i).emirVerenKomutanAl().apoletNumarasýAl() == komutan.apoletNumarasýAl()){
					if((emirListesi.get(i).emirTuruAl() == "TemizlikEmri") || (emirListesi.get(i).emirTuruAl() == "SporEmri")){
						System.out.println("Bir önceki emrinizden farklý bir türde bir emir vermelisiniz.");
						System.out.println("Bir önceki emriniz:\n" + emirListesi.get(i).emirOzeti());
						return;
					}
				}
			}
		}

	}
}
