
public class SporEmri extends Emir {
	private String hareketTuru;
	private int tekrarSayisi;

	public String hareketTuruAl() {
		return hareketTuru;
	}

	public void hareketTuruBelirle(String hareketTuru) {
		this.hareketTuru = hareketTuru;
	}

	public int tekrarSayisiAl() {
		return tekrarSayisi;
	}

	public void tekrarSayisiBelirle(int tekrarSayisi) {
		this.tekrarSayisi = tekrarSayisi;
	}

	public SporEmri() {
		super();
		this.hareketTuru = null;
		this.tekrarSayisi = 0;
	}

	public SporEmri(int emirNo, Tarih verilmeTarihi, Tarih uygulamaTarihi, Komutan emirVerenKomutan, boolean uygulamaDurumu,
			String hareketTuru, int tekrarSayisi) {
		super(emirNo, verilmeTarihi, uygulamaTarihi, emirVerenKomutan, uygulamaDurumu);
		this.hareketTuru = hareketTuru;
		this.tekrarSayisi = tekrarSayisi;
	}

	@Override
	public void emriUygula() {
		this.uygulamaDurumuBelirle(true);
		System.out.println(emirOzeti() + " uygulandý.");
	}

	@Override
	public String emirMetni() {
		return "\nEmir No: " + emirNoAl() 
				+ "\nTürü: Spor\nHareket Türü: " + hareketTuru 
				+ "\nTekrar Sayýsý: " + tekrarSayisi 
				+ "\nVerilme Tarihi: " + verilmeTarihiAl().tarihAl() 
				+ "\nUygulama Tarihi: "	+ uygulamaTarihiAl().tarihAl() 
				+ "\nEmir Veren Komutan: " + emirVerenKomutanAl().kimlikAl()
				+ "\nUygulanma Durumu: " + (uygulamaDurumuAl() == true ? "Uygulandý" : "Uygulanmadý");
	}

	@Override
	public String emirOzeti() {
		return "Emir No: " + emirNoAl() + ", " + emirVerenKomutanAl().kimlikAl() + " tarafýndan verilen spor emri ("
				+ hareketTuru + ", " + tekrarSayisi + " tekrar)" + (uygulamaDurumuAl() == true ? " (+)" : "");
	}

}
