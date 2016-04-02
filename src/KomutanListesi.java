import java.util.Scanner;
import java.util.Vector;
import java.util.Iterator;
import java.util.Locale;

public class KomutanListesi {
	Vector<Komutan> komutanListesi = new Vector<Komutan>();
	public static final int LIMIT = 20;

	private Komutan temp;
	private Scanner sc = new Scanner(System.in);

	public KomutanListesi() {
	}

	public void komutanEkle() {
		int secim;
		int gecici;
		sc = new Scanner(System.in);

		if (komutanListesi.size() == LIMIT) {
			System.out.println("Daha fazla komutan ekleyemezsiniz.");
			return;
		}

		do {
			System.out.println("Komutan türünü giriniz:\n1. A\n2. B");
			secim = sc.nextInt();
		} while (secim != 1 && secim != 2);

		switch (secim) {
		case 1:
			temp = new KomutanA();
			break;
		case 2:
			temp = new KomutanB();
			break;
		}

		do {
			System.out.println("Apolet No:");
			gecici = sc.nextInt();
			if (komutanMevcutMu(gecici)) {
				System.out.println("Girdiðiniz numara sistemde kayýtlý. Tekrar deneyin.");
			}

		} while (komutanMevcutMu(gecici));

		temp.apoletNumarasýBelirle(gecici);

		System.out.println("Rutbe:");
		temp.rutbeBelirle(sc.next());

		System.out.println("Ad:");
		temp.adBelirle(sc.next());

		System.out.println("Soyad:");
		temp.soyadBelirle(sc.next());

		komutanListesi.add(temp);

		System.out.println(" Listeye eklendi: " + temp.kimlikAl());

	}

	public boolean komutanMevcutMu(int apolet) {
		if (komutanListesi.isEmpty()) {
			return false;
		} else {
			for (int i = 0; i < komutanListesi.size(); i++) {
				if (apolet == komutanListesi.get(i).apoletNumarasýAl()) {
					return true;
				}
			}
		}
		return false;
	}

	public Komutan komutanAl(int apolet) {
		
		if(!komutanMevcutMu(apolet)){
			System.out.println("Sistemde bu numarayla kayýtlý bir komutan yok.");
			return null;
		} else {
			Komutan temp = null;
			for (int i = 0; i < komutanListesi.size(); i++) {
				if (apolet == komutanListesi.get(i).apoletNumarasýAl()) {
					temp = komutanListesi.get(i);
					break;
				} else {
					temp = null;
				}
			}
			return temp;
		}
	}

	public void listeYazdir(String listelemeKosulu) {
		
		Iterator<Komutan> it = komutanListesi.iterator();
		
		if (komutanListesi.isEmpty()) {
			System.out.println("Kayýtlý komutan yok.");
		}
		
		switch(listelemeKosulu){
		case "hepsi":
				System.out.println("Kayýtlý komutanlar: (" + komutanListesi.size() + "/" + LIMIT + ")");
				while (it.hasNext())
					System.out.println("* " + it.next().kimlikAl());
				break;
		
		case "A":
			System.out.println("A tipi komutanlar:");
			
			for(int i = 0 ; i < komutanListesi.size(); i++){
				if(komutanListesi.get(i).komutanTuruAl()=="KomutanA")
					System.out.println("* " + komutanListesi.get(i).kimlikAl());
			}
			break;
			
		case "B":
			System.out.println("B tipi komutanlar:");
			
			for(int i = 0 ; i < komutanListesi.size(); i++){
				if(komutanListesi.get(i).komutanTuruAl()=="KomutanB")
					System.out.println("* " + komutanListesi.get(i).kimlikAl());
			}
			break;
			
		case "apolet":
			System.out.println("Apolet numarasý girin:");
			int apolet = sc.nextInt();
			if(komutanAl(apolet) != null){
				System.out.println("* " + komutanAl(apolet).kimlikAl());
			}
			break;

		case "ad":
			System.out.println("Aradýðýnýz adý girin:");
			String ad = sc.next();
			boolean bulundu = false;
			
			for(int i = 0 ; i < komutanListesi.size() ; i++){
				if(komutanListesi.get(i).adAl().toLowerCase(Locale.ROOT).equals(ad.toLowerCase(Locale.ROOT)) ){
					System.out.println("* " + komutanListesi.get(i).kimlikAl());
					bulundu = true;
				}
			}
			if(!bulundu){
				System.out.println("Bu ada sahip bir komutan yok.");
			}
			break;
			
		case "soyad":
			System.out.println("Aradýðýnýz soyadý girin:");
			String soyad = sc.next();
			bulundu = false;
			
			for(int i = 0 ; i < komutanListesi.size() ; i++){
				if(komutanListesi.get(i).soyadAl().toLowerCase(Locale.ROOT).equals(soyad.toLowerCase(Locale.ROOT))){
					System.out.println("* " + komutanListesi.get(i).kimlikAl());
				}
			}
			if(!bulundu){
				System.out.println("Bu soyadýna sahip bir komutan yok.");
			}
			break;
			
		case "rütbe":
			System.out.println("Aradýðýnýz rütbeyi girin:");
			String rutbe = sc.next();
			bulundu = false;
			
			for(int i = 0 ; i < komutanListesi.size() ; i++){
				if(komutanListesi.get(i).rutbeAl().toLowerCase(Locale.ROOT).equals(rutbe.toLowerCase(Locale.ROOT))){
					System.out.println("* " + komutanListesi.get(i).kimlikAl());
				}
			}
			if(!bulundu){
				System.out.println("Bu rütbede bir komutan yok.");
			}
			break;
			
		}
		

	}

	public void komutanSil() {
		int apolet;
		do {
			System.out.println("Silinmesini istediðiniz komutanýn apolet numarasý:");
			apolet = sc.nextInt();
			if (!komutanMevcutMu(apolet)) {
				System.out.println("Geçerli giriþ yapýnýz.");
			}
		} while (!komutanMevcutMu(apolet));

		for (int i = 0; i < komutanListesi.size(); i++) {
			if (apolet == komutanListesi.get(i).apoletNumarasýAl()) {
				System.out.println(komutanListesi.get(i).kimlikAl() + " kaydý baþarýyla silindi");
				komutanListesi.remove(i);
				break;
			}
		}

	}

	public void bilgiGuncelle() {
		int apolet;
		do {
			System.out.println("Bilgilerini güncellemek istediðiniz komutanýn apolet numarasý:");
			apolet = sc.nextInt();
			if (!komutanMevcutMu(apolet)) {
				System.out.println("Geçerli giriþ yapýnýz.");
			}
		} while (!komutanMevcutMu(apolet));

		for (int i = 0; i < komutanListesi.size(); i++) {
			if (apolet == komutanListesi.get(i).apoletNumarasýAl()) {
				System.out.println(komutanListesi.get(i).kimlikAl() + " kaydýný güncelliyorsunuz."
						+ "\n1. Apolet  2. Rütbe  3. Ad  4.  Soyad 5. Komutan Türü");
				int secim = sc.nextInt();
				switch (secim) {
				case 1:
					System.out.println("Yeni apolet numarasý:");
					komutanListesi.get(i).apoletNumarasýBelirle(sc.nextInt());
					System.out.println("Apolet numarasý güncellendi. Yeni bilgi.\n" + komutanListesi.get(i).kimlikAl());
					break;
				case 2:
					System.out.println("Yeni rütbe:");
					komutanListesi.get(i).rutbeBelirle(sc.next());
					System.out.println("Apolet numarasý güncellendi. Yeni bilgi.\n" + komutanListesi.get(i).kimlikAl());
					break;
				case 3:
					System.out.println("Yeni ad:");
					komutanListesi.get(i).adBelirle(sc.next());
					System.out.println("Apolet numarasý güncellendi. Yeni bilgi.\n" + komutanListesi.get(i).kimlikAl());
					break;
				case 4:
					System.out.println("Yeni soyad:");
					komutanListesi.get(i).soyadBelirle(sc.next());
					System.out.println("Apolet numarasý güncellendi. Yeni bilgi.\n" + komutanListesi.get(i).kimlikAl());
					break;
				case 5:
					do {
						System.out.println("Yeni komutan türünü giriniz:\n1. A\n2. B");
						secim = sc.nextInt();
					} while (secim != 1 && secim != 2);

					switch (secim) {
					case 1:
						temp = new KomutanA();
						break;
					case 2:
						temp = new KomutanB();
						break;
					}
					
					temp.apoletNumarasýBelirle(komutanListesi.get(i).apoletNumarasýAl());
					temp.rutbeBelirle(komutanListesi.get(i).rutbeAl());
					temp.adBelirle(komutanListesi.get(i).adAl()); 
					temp.soyadBelirle(komutanListesi.get(i).soyadAl());
					
					komutanListesi.insertElementAt(temp, i);
					komutanListesi.remove(i + 1);
					System.out.println("Apolet numarasý güncellendi. Yeni bilgi.\n" + komutanListesi.get(i).kimlikAl());
				}

				break;
			}
		}
	}

	public void testVerisiUret() {		
		
		Vector<Komutan> testListesi = new Vector<Komutan>();
		testListesi.add( new KomutanA(3001, "Zafer", "Balkan", "Ütðm.") );
		testListesi.add( new KomutanA(3002, "Sercan", "Gülburun", "Ütðm.") );
		testListesi.add( new KomutanA(3003, "Ý. Süheyl", "Erdem", "Ütðm.") );
		testListesi.add( new KomutanB(3004, "Serkan", "Hasdemir", "Ütðm.") );
		testListesi.add( new KomutanB(3005, "Murat", "Gümüþ", "Ütðm."));
		testListesi.add( new KomutanB(3006, "Harun", "Artýn", "Ütðm.") );
		testListesi.add( new KomutanB(3007, "Osman", "Dinç", "Ütðm.") );
		
		for(int i = 0; i < testListesi.size(); i++){
			System.out.println(testListesi.get(i).kimlikAl());	
		}
				
		komutanListesi.addAll(testListesi);
		System.out.println(testListesi.size() + " komutan eklendi.");

	}
}
