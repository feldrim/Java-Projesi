import java.util.Scanner;
/*
 *	Main Class k�s�tlara bak�larak tekrar yaz�lacak.
 *
 **/

public class MainClass {

	private static Scanner sc;

	public static void main(String[] args) {
		// Diziler
		Komutan[] komutanListesi = new Komutan[20];
		komutanListesi[0] = new KomutanA(3001, "Zafer", "Balkan", "�t�m.");
		komutanListesi[1] = new KomutanA(3002, "Sercan", "G�lburun", "�t�m.");
		komutanListesi[2] = new KomutanA(3003, "�. S�heyl", "Erdem", "�t�m.");
		komutanListesi[3] = new KomutanB(3004, "Serkan", "Hasdemir", "�t�m.");
		komutanListesi[4] = new KomutanB(3005, "Murat", "G�m��", "�t�m.");
		komutanListesi[5] = new KomutanB(3006, "Harun", "Art�n", "�t�m.");
		komutanListesi[6] = new KomutanB(3007, "Osman", "Din�", "�t�m.");

		Emir[] emirListesi = new Emir[100];

		// De�i�kenler
		sc = new Scanner(System.in);
		int emirNo = 1;
		String emirTuru = null;
		int emirSayisi = 0;
		Tarih verilmeTarihi = new Tarih();
		Tarih uygulamaTarihi = new Tarih();
		Tarih bugun = new Tarih();
		Komutan emirVeren = null;
		Kontrol k; //Tarih vs. kontrol� i�in
		boolean komutanSorgula;
		int komutanSayisi = 7;
		int apolet = 0;
		int i;

		// Temizlik
		String temizlikBolgesi = null;
		int temizlikTuru = 0;
		int temizlikKisiSayisi = 0;

		// Spor
		String sporAciklama = null;
		int sporTekrar = 0;
		

		// Tarih gir
		System.out.println("Bug�n�n tarihini giriniz:\nG�n:");
		int gun = sc.nextInt();
		System.out.println("Ay: ");
		String ay = sc.next();
		System.out.println("Y�l: ");
		int yil = sc.nextInt();
		bugun = new Tarih(gun, ay, yil);
		System.out.println("Tarih: " + bugun.tarihAl());

		// d�ng�
		while (true) {
			
			System.out.println("\n*********\n1. Emir ekle\n2. Emir Listele\n3. Komutan Ekle\n4. Komutan Listele\n5. G�n Sonu");
			int secim1 = sc.nextInt();
			switch (secim1) {
			case 1:
				System.out.println("Emir No: " + (emirNo));

				System.out.println("1. Temizlik Emri\n2. Spor Emri");
				int secim2 = sc.nextInt();
				switch (secim2) {
				case 1:
					emirTuru = "temizlik";
					System.out.println("Temizlik yap�lacak b�lge: ");
					temizlikBolgesi = sc.next();
					System.out.println("Temizlik t�r�: (1. M�nt�ka, 2. K��, 3. Peyzaj)");
					temizlikTuru = sc.nextInt();
					System.out.println("Temizlik yapacak ki�i say�s�:");
					temizlikKisiSayisi = sc.nextInt();
					break;
				case 2:
					emirTuru = "spor";
					System.out.println("A��klama: ");
					sporAciklama = sc.next();
					System.out.println("Tekrar say�s�: ");
					sporTekrar = sc.nextInt();
					break;
				default:
					System.out.println("Ge�eri bir se�im yap�n�z.");
				}

				verilmeTarihi = bugun;

				do {
					System.out.println("Emir Uygulama Tarihi:\nG�n:");
					gun = sc.nextInt();
					System.out.println("Ay: ");
					ay = sc.next();
					System.out.println("Y�l: ");
					yil = sc.nextInt();
					uygulamaTarihi = new Tarih(gun, ay, yil);
					k = new Kontrol(verilmeTarihi, uygulamaTarihi);
					
					if(k.gecerliTarih() == false){
						System.out.println("Ge�erli bir tarih giriniz.");
					}
				} while (k.gecerliTarih() == false);

				System.out.println("Emri Veren Komutan�n Apolet Numaras�: ");
				do {
					apolet = sc.nextInt();
					komutanSorgula = false;
					for (i = 0; i < komutanSayisi; i++) {
						if (apolet == komutanListesi[i].getApolet()) {
							emirVeren = komutanListesi[i];
							komutanSorgula = true;
							break;
						}
					}
					if (komutanSorgula == false && i == komutanSayisi) {
						System.out.println("Komutan Bulunamad�.\nEmri Veren Komutan�n Apolet Numaras�: ");
					}
				} while (komutanSorgula == false);

				if (emirTuru == "temizlik") {
					emirListesi[emirNo - 1] = new TemizlikEmri(emirNo, verilmeTarihi, uygulamaTarihi, emirVeren, false,
							temizlikBolgesi, temizlikTuru, temizlikKisiSayisi);
				} else if (emirTuru == "spor") {
					emirListesi[emirNo - 1] = new SporEmri(emirNo, verilmeTarihi, uygulamaTarihi, emirVeren, false,
							sporAciklama, sporTekrar);
				}

				System.out.println("Emir Kaydedildi:\n" + emirListesi[emirNo - 1].emirMetni());

				emirNo++;
				emirSayisi++;
				break;

			case 2:
				if (emirSayisi == 0) {
					System.out.println("Emir yok");
				} else {
					for (i = 0; i < emirSayisi; i++) {
						System.out.println(emirListesi[i].emirOzeti());
					}
				}
				break;

			case 3:
				int secim3;
				int temp;
				boolean apoletMevcutMu;

				do {
					System.out.println("Komutan t�r�n� giriniz:\n1. A\n2. B");
					secim3 = sc.nextInt();
				} while (secim3 != 1 && secim3 != 2);

				switch (secim3) {
				case 1:
					komutanListesi[komutanSayisi] = new KomutanA();
					break;
				case 2:
					komutanListesi[komutanSayisi] = new KomutanB();
					break;
				}

				do {
					apoletMevcutMu = false;
					System.out.println("Apolet No:");
					temp = sc.nextInt();
					for (i = 0; i < komutanSayisi; i++) {
						if (temp == komutanListesi[i].getApolet()) {
							apoletMevcutMu = true;
							break;

						}
					}
				} while (apoletMevcutMu == true);
				
				komutanListesi[komutanSayisi].setApolet(temp);

				System.out.println("Rutbe:");
				komutanListesi[komutanSayisi].setRutbe(sc.next());

				System.out.println("Ad:");
				komutanListesi[komutanSayisi].setAd(sc.next());

				System.out.println("Soyad:");
				komutanListesi[komutanSayisi].setSoyad(sc.next());

				System.out.println(" Listeye eklendi: " + komutanListesi[komutanSayisi].kimlikAl());
				komutanSayisi++;
				break;

			case 4:
				System.out.println("Kay�tl� komutanlar:");
				for (i = 0; i < komutanSayisi; i++) {
					System.out.println("* " + komutanListesi[i].kimlikAl());
				}
				break;
			case 5:
				int uygulananEmir = 0;
				for (i = 0 ; i < emirSayisi; i++){
					if(emirListesi[i].getUygulama().tarihAl().equals(bugun.tarihAl())){
						emirListesi[i].emriUygula();
						uygulananEmir++;
					}
				}
				if(uygulananEmir == 0)
					System.out.println("Uygulanacak emir yok.");

				bugun = bugun.gunSonra(1);
				System.out.println("Tarih: " + bugun.tarihAl());
				break;
			default:
				System.out.println("Ge�erli bir se�im yap�n�z.");

			}
		}
	}
}
