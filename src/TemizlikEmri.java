
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
		switch (temizlikTuru) {
		case 1:
			return "Mýntýka Temizliði";
		case 2:
			return "Kýþ Temizliði";
		case 3:
			return "Peyzaj Faaliyeti";
		default:
			return "Genel Temizlik";
		}
	}

	@Override
	public String emirMetni() {
		return "\nEmir No: " + (emirNoAl()) + "\nTürü: Temizlik\nTemizlik Bölgesi: " + bolgeAdi + "\nTemizlik Türü: "
				+ temizlikTuruString() + "(" + temizlikTuru + ")" + "\nKiþi Sayýsý: " + kisiSayisi
				+ "\nVerilme Tarihi: " + verilmeTarihiAl().tarihAl() + "\nUygulama Tarihi: "
				+ uygulamaTarihiAl().tarihAl() + "\nEmir Veren Komutan: " + emirVerenKomutanAl().kimlikAl()
				+ "\nUygulanma Durumu: " + (uygulamaDurumuAl() == true ? "Uygulandý" : "Uygulanmadý");
	}

	@Override
	public String emirOzeti() {
		return "Emir No: " + emirNoAl() + ", " 
				+ emirVerenKomutanAl().kimlikAl() + " tarafýndan verilen temizlik emri ("
				+ bolgeAdi + " bölgesinde " 
				+ kisiSayisi + " kiþi ile " 
				+ temizlikTuruString() + ")"
				+ (uygulamaDurumuAl() == true ? " (+)" : "");
	}

}
