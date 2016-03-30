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
			System.out.println("Komutan t�r�n� giriniz:\n1. A\n2. B");
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
				System.out.println("Girdi�iniz numara sistemde kay�tl�. Tekrar deneyin.");
			}

		} while (komutanMevcutMu(gecici));

		temp.apoletNumaras�Belirle(gecici);

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
				if (apolet == komutanListesi.get(i).apoletNumaras�Al()) {
					return true;
				}
			}
		}
		return false;
	}

	public Komutan komutanAl(int apolet) {
		Komutan temp = null;
		for (int i = 0; i < komutanListesi.size(); i++) {
			if (apolet == komutanListesi.get(i).apoletNumaras�Al()) {
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
			System.out.println("Sonu� bulunamad�");
		} else {
			System.out.println(komutanAl(apolet).kimlikAl());
		}
	}

	public void listeYazdir() {
		if (komutanListesi.size() == 0) {
			System.out.println("Kay�tl� komutan yok.");
		} else {
			Iterator<Komutan> it = komutanListesi.iterator();
			System.out.println("Kay�tl� komutanlar: (" + komutanListesi.size() + "/" + LIMIT + ")");
			while (it.hasNext())
				System.out.println("* " + it.next().kimlikAl());
		}

	}

	public void komutanSil() {
		int apolet;
		do {
			System.out.println("Silinmesini istedi�iniz komutan�n apolet numaras�:");
			apolet = sc.nextInt();
			if (!komutanMevcutMu(apolet)) {
				System.out.println("Ge�erli giri� yap�n�z.");
			}
		} while (!komutanMevcutMu(apolet));

		for (int i = 0; i < komutanListesi.size(); i++) {
			if (apolet == komutanListesi.get(i).apoletNumaras�Al()) {
				System.out.println(komutanListesi.get(i).kimlikAl() + " kayd� ba�ar�yla silindi");
				komutanListesi.remove(i);
				break;
			}
		}

	}

	public void bilgiGuncelle() {
		int apolet;
		do {
			System.out.println("Bilgilerini g�ncellemek istedi�iniz komutan�n apolet numaras�:");
			apolet = sc.nextInt();
			if (!komutanMevcutMu(apolet)) {
				System.out.println("Ge�erli giri� yap�n�z.");
			}
		} while (!komutanMevcutMu(apolet));

		for (int i = 0; i < komutanListesi.size(); i++) {
			if (apolet == komutanListesi.get(i).apoletNumaras�Al()) {
				System.out.println(komutanListesi.get(i).kimlikAl() + " kayd�n� g�ncelliyorsunuz."
						+ "\n1. Apolet  2. R�tbe  3. Ad  4.  Soyad 5. Komutan T�r�");
				int secim = sc.nextInt();
				switch (secim) {
				case 1:
					System.out.println("Yeni apolet numaras�:");
					komutanListesi.get(i).apoletNumaras�Belirle(sc.nextInt());
					System.out.println("Apolet numaras� g�ncellendi. Yeni bilgi.\n" + komutanListesi.get(i).kimlikAl());
					break;
				case 2:
					System.out.println("Yeni r�tbe:");
					komutanListesi.get(i).rutbeBelirle(sc.next());
					System.out.println("Apolet numaras� g�ncellendi. Yeni bilgi.\n" + komutanListesi.get(i).kimlikAl());
					break;
				case 3:
					System.out.println("Yeni ad:");
					komutanListesi.get(i).adBelirle(sc.next());
					System.out.println("Apolet numaras� g�ncellendi. Yeni bilgi.\n" + komutanListesi.get(i).kimlikAl());
					break;
				case 4:
					System.out.println("Yeni soyad:");
					komutanListesi.get(i).soyadBelirle(sc.next());
					System.out.println("Apolet numaras� g�ncellendi. Yeni bilgi.\n" + komutanListesi.get(i).kimlikAl());
					break;
				case 5:
					do {
						System.out.println("Yeni komutan t�r�n� giriniz:\n1. A\n2. B");
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
					
					temp.apoletNumaras�Belirle(komutanListesi.get(i).apoletNumaras�Al());
					temp.rutbeBelirle(komutanListesi.get(i).rutbeAl());
					temp.adBelirle(komutanListesi.get(i).adAl()); 
					temp.soyadBelirle(komutanListesi.get(i).soyadAl());
					
					komutanListesi.insertElementAt(temp, i);
					komutanListesi.remove(i + 1);
					System.out.println("Apolet numaras� g�ncellendi. Yeni bilgi.\n" + komutanListesi.get(i).kimlikAl());
				}

				break;
			}
		}
	}

	public void testVerisiUret() {		
		
		Vector<Komutan> testListesi = new Vector<Komutan>();
		testListesi.add( new KomutanA(3001, "Zafer", "Balkan", "�t�m.") );
		testListesi.add( new KomutanA(3002, "Sercan", "G�lburun", "�t�m.") );
		testListesi.add( new KomutanA(3003, "�. S�heyl", "Erdem", "�t�m.") );
		testListesi.add( new KomutanB(3004, "Serkan", "Hasdemir", "�t�m.") );
		testListesi.add( new KomutanB(3005, "Murat", "G�m��", "�t�m."));
		testListesi.add( new KomutanB(3006, "Harun", "Art�n", "�t�m.") );
		testListesi.add( new KomutanB(3007, "Osman", "Din�", "�t�m.") );
		
		for(int i = 0; i < testListesi.size(); i++){
			System.out.println(testListesi.get(i).kimlikAl());	
		}
				
		komutanListesi.addAll(testListesi);
		System.out.println(testListesi.size() + " komutan eklendi.");

	}
}
