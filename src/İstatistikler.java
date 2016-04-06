import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class �statistikler {
	
	public �statistikler() {
	}

	Scanner sc = new Scanner(System.in);
	
	public void detayliArama(EmirListesi e) {
		Set<Emir> set1 = new HashSet<Emir>();
		Set<Emir> set2 = new HashSet<Emir>();
		Vector<Emir> emirListesi = new Vector<Emir>();
		emirListesi = e.emirListesi;
		
		String parametre1 = null;
		String parametre2 = null;

		System.out.println("�ki farkl� parametre girerek arama yapabilirsiniz."
		+ "\nArama yapmak i�in ilk parametreyi se�iniz:" 
		+ "\n\t1. Emir veren komutan apolet numaras�"
		+ "\n\t2. Emir veren komutan r�tbesi" 
		+ "\n\t3. Emir veren komutan t�r�" 
		+ "\n\t4. Emir t�r�"
		+ "\n\t5. Emir verilme tarihi" 
		+ "\n\t6. Emir uygulama tarihi");

		int secim1 = sc.nextInt();
		switch (secim1) {
		case 1:
			System.out.println("Apolet numaras� girin:");
			int apolet = sc.nextInt();
			for (int i = 0; i < emirListesi.size(); i++) {
				if (emirListesi.get(i).emirVerenKomutanAl().apoletNumaras�Al() == apolet)
					set1.add(emirListesi.get(i));
			}
			parametre1 = (apolet + " apolet numaral� komutan taraf�ndan verilen emirler");
			break;

		case 2:
			System.out.println("R�tbe girin:");
			String rutbe = sc.next();
			for (int i = 0; i < emirListesi.size(); i++) {
				if (emirListesi.get(i).emirVerenKomutanAl().rutbeAl().equals(rutbe))
					set1.add(emirListesi.get(i));
			}
			parametre1 = (rutbe + " r�tbeli komutan(lar) taraf�ndan verilen emirler");
			break;
			
		case 3:
			System.out.println("Komutan t�r� girin: (1. A, 2. B)");
			int komutanTuru = sc.nextInt();
			String komutanTuruString;

			if (komutanTuru == 1) {
				komutanTuruString = "KomutanA";
				
			} else {
				komutanTuruString = "KomutanB";
			}

			for (int i = 0; i < emirListesi.size(); i++) {
				if (emirListesi.get(i).emirVerenKomutanAl().komutanTuruAl().equals(komutanTuruString))
					set1.add(emirListesi.get(i));
			}
			
			parametre1 = (komutanTuruString + " t�r� komutanlar taraf�ndan verilen emirler");
			break;

		case 4:
			System.out.println("Emir t�r� girin: (1. Temizlik, 2. Spor)");
			int emirTuru = sc.nextInt();
			String emirTuruString;

			if (emirTuru == 1) {
				emirTuruString = "TemizlikEmri";
			} else {
				emirTuruString = "SporEmri";
			}

			for (int i = 0; i < emirListesi.size(); i++) {
				if (emirListesi.get(i).emirTuruAl().equals(emirTuruString))
					set1.add(emirListesi.get(i));
			}
			parametre1 = (emirTuruString + " t�r� emirler");
			break;

		case 5:
			System.out.println("Emir verilme tarihini girin:");
			Tarih temp = new Tarih();
			temp.tarihAyarla();

			for (int i = 0; i < emirListesi.size(); i++) {
				if (emirListesi.get(i).verilmeTarihiAl().tarihAl().equals(temp.tarihAl()))
					set1.add(emirListesi.get(i));
			}
			parametre1 = (temp.tarihAl() + " tarihinde verilen emirler");
			break;

		case 6:
			System.out.println("Emir verilme tarihini girin:");
			Tarih temp2 = new Tarih();
			temp2.tarihAyarla();

			for (int i = 0; i < emirListesi.size(); i++) {
				if (emirListesi.get(i).uygulamaTarihiAl().tarihAl().equals(temp2.tarihAl()))
					set1.add(emirListesi.get(i));
			}
			parametre1 = (temp2.tarihAl() + " tarihinde uygulanan/uygulanacak emirler");
			break;
		}

		System.out.println("Arama yapmak i�in ikinci parametreyi se�iniz:" 
				+ "\n\t1. Emir veren komutan apolet numaras�"
				+ "\n\t2. Emir veren komutan r�tbesi" 
				+ "\n\t3. Emir veren komutan t�r�" 
				+ "\n\t4. Emir t�r�"
				+ "\n\t5. Emir verilme tarihi" 
				+ "\n\t6. Emir uygulama tarihi");

		int secim2 = sc.nextInt();
		switch (secim2) {
		case 1:
			System.out.println("Apolet numaras� girin:");
			int apolet = sc.nextInt();
			for (int i = 0; i < emirListesi.size(); i++) {
				if (emirListesi.get(i).emirVerenKomutanAl().apoletNumaras�Al() == apolet)
					set2.add(emirListesi.get(i));
			}
			parametre2 = (apolet + " apolet numaral� komutan taraf�ndan verilen emirler");
			break;

		case 2:
			System.out.println("R�tbe girin:");
			String rutbe = sc.next();
			for (int i = 0; i < emirListesi.size(); i++) {
				if (emirListesi.get(i).emirVerenKomutanAl().rutbeAl().equals(rutbe))
					set2.add(emirListesi.get(i));
			}
			parametre2 = (rutbe + " r�tbeli komutan(lar) taraf�ndan verilen emirler");
			break;
			
		case 3:
			System.out.println("Komutan t�r� girin: (1. A, 2. B)");
			int komutanTuru = sc.nextInt();
			String komutanTuruString;

			if (komutanTuru == 1) {
				komutanTuruString = "KomutanA";
				
			} else {
				komutanTuruString = "KomutanB";
			}

			for (int i = 0; i < emirListesi.size(); i++) {
				if (emirListesi.get(i).emirVerenKomutanAl().komutanTuruAl().equals(komutanTuruString))
					set2.add(emirListesi.get(i));
			}
			
			parametre2 = (komutanTuruString + " t�r� komutanlar taraf�ndan verilen emirler");
			break;

		case 4:
			System.out.println("Emir t�r� girin: (1. Temizlik, 2. Spor)");
			int emirTuru = sc.nextInt();
			String emirTuruString;

			if (emirTuru == 1) {
				emirTuruString = "TemizlikEmri";
			} else {
				emirTuruString = "SporEmri";
			}

			for (int i = 0; i < emirListesi.size(); i++) {
				if (emirListesi.get(i).emirTuruAl().equals(emirTuruString))
					set2.add(emirListesi.get(i));
			}
			parametre2 = (emirTuruString + " t�r� emirler");
			break;

		case 5:
			System.out.println("Emir verilme tarihini girin:");
			Tarih temp = new Tarih();
			temp.tarihAyarla();

			for (int i = 0; i < emirListesi.size(); i++) {
				if (emirListesi.get(i).verilmeTarihiAl().tarihAl().equals(temp.tarihAl()))
					set2.add(emirListesi.get(i));
			}
			parametre2 = (temp.tarihAl() + " tarihinde verilen emirler");
			break;

		case 6:
			System.out.println("Emir verilme tarihini girin:");
			Tarih temp2 = new Tarih();
			temp2.tarihAyarla();

			for (int i = 0; i < emirListesi.size(); i++) {
				if (emirListesi.get(i).uygulamaTarihiAl().tarihAl().equals(temp2.tarihAl()))
					set2.add(emirListesi.get(i));
			}
			parametre2 = (temp2.tarihAl() + " tarihinde uygulanan/uygulanacak emirler");
			break;
		}
		
		System.out.println("Arama sonucu:");
		System.out.println("Parametre 1: " + parametre1);
		System.out.println("Parametre 2: " + parametre2);

		set1.retainAll(set2);
		if(set1.isEmpty()){
			System.out.println("Sonu� bulunamad�.");
		} else {
			Iterator<Emir> it = set1.iterator();
			while (it.hasNext())
				System.out.println(it.next().emirOzeti());
		}		
	}

	public void komutanIstatistikleri(EmirListesi e, KomutanListesi k){

	}
	
	public void emirIstatistikleri(EmirListesi e, KomutanListesi k){

	}

}
