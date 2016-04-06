import java.util.HashMap;


public class TemizlikEmri extends Emir {
	private String bolgeAdi;
	private int temizlikTuru;
	private int kisiSayisi;

	public String bolgeAdiAl() {
		return bolgeAdi;
	}

	public void bolgeAdiBelirle(String bolgeAdi) {
		this.bolgeAdi = bolgeAdi;
	}

	public int temizlikTuruAl() {
		return temizlikTuru;
	}

	public void temizlikTuruBelirle(int temizlikTuru) {
		if(temizlikTuru > 3 || temizlikTuru < 1)
			this.temizlikTuru = 1;
		else
			this.temizlikTuru = temizlikTuru;
	}

	public int kisiSayisiAl() {
		return kisiSayisi;
	}

	public void kisiSayisiBelirle(int kisiSayisi) {
		this.kisiSayisi = kisiSayisi;
	}

	public TemizlikEmri() {
		super();
		this.bolgeAdi = "";
		this.temizlikTuru = 0;
		this.kisiSayisi = 0;
	}

	public TemizlikEmri(int emirNo, Tarih verilmeTarihi, Tarih uygulamaTarihi, Komutan emirVerenKomutan, boolean uygulamaDurumu,
			String bolgeAdi, int temizlikTuru, int kisiSayisi) {
		super(emirNo, verilmeTarihi, uygulamaTarihi, emirVerenKomutan, uygulamaDurumu);
		this.bolgeAdi = bolgeAdi;
		this.temizlikTuru = temizlikTuru;
		this.kisiSayisi = kisiSayisi;
	}

	private String temizlikTuruString() {
		
		HashMap<Integer, String> temizlikTuruMap = new HashMap<Integer, String>();
		temizlikTuruMap.put(1, "M�nt�ka Temizli�i");
		temizlikTuruMap.put(2, "K�� Temizli�i");
		temizlikTuruMap.put(3, "Peyzaj Faaliyeti");
		
		return temizlikTuruMap.get(temizlikTuru);
		
	}

	@Override
	public String emirMetni() {
		return "\nEmir No: " + (emirNoAl()) + "\nT�r�: Temizlik\nTemizlik B�lgesi: " + bolgeAdi + "\nTemizlik T�r�: "
				+ temizlikTuruString() + "(" + temizlikTuru + ")" + "\nKi�i Say�s�: " + kisiSayisi
				+ "\nVerilme Tarihi: " + verilmeTarihiAl().tarihAl() + "\nUygulama Tarihi: "
				+ uygulamaTarihiAl().tarihAl() + "\nEmir Veren Komutan: " + emirVerenKomutanAl().kimlikAl()
				+ "\nUygulanma Durumu: " + (uygulamaDurumuAl() == true ? "Uyguland�" : "Uygulanmad�");
	}

	@Override
	public String emirOzeti() {
		return "Emir No: " + emirNoAl() + ", " 
				+ emirVerenKomutanAl().kimlikAl() + " taraf�ndan verilen temizlik emri ("
				+ bolgeAdi + " b�lgesinde " 
				+ kisiSayisi + " ki�i ile " 
				+ temizlikTuruString() + ")"
				+ (uygulamaDurumuAl() == true ? " (+)" : "");
	}

}
