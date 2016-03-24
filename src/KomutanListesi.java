import java.util.Scanner;
import java.util.Vector;
import java.util.Iterator;

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

	public void komutanAra(int apolet) {
		if (!komutanMevcutMu(apolet)) {
			System.out.println("Sonuç bulunamadý");
		} else {
			System.out.println(komutanAl(apolet).kimlikAl());
		}
	}

	public void listeYazdir() {
		if (komutanListesi.size() == 0) {
			System.out.println("Kayýtlý komutan yok.");
		} else {
			Iterator<Komutan> it = komutanListesi.iterator();
			System.out.println("Kayýtlý komutanlar: (" + komutanListesi.size() + "/" + LIMIT + ")");
			while (it.hasNext())
				System.out.println("* " + it.next().kimlikAl());
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

		Komutan[] testListesi = new Komutan[7];
		testListesi[0] = new KomutanA(3001, "Zafer", "Balkan", "Ütðm.");
		testListesi[1] = new KomutanA(3002, "Sercan", "Gülburun", "Ütðm.");
		testListesi[2] = new KomutanA(3003, "Ý. Süheyl", "Erdem", "Ütðm.");
		testListesi[3] = new KomutanB(3004, "Serkan", "Hasdemir", "Ütðm.");
		testListesi[4] = new KomutanB(3005, "Murat", "Gümüþ", "Ütðm.");
		testListesi[5] = new KomutanB(3006, "Harun", "Artýn", "Ütðm.");
		testListesi[6] = new KomutanB(3007, "Osman", "Dinç", "Ütðm.");

		for (int i = 0; i < testListesi.length; i++) {
			komutanListesi.add(testListesi[i]);
		}
	}
}
