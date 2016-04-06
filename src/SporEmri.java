import java.util.HashMap;


public class SporEmri extends Emir {
	private int hareketTuru;
	private int tekrarSayisi;

	public int hareketTuruAl() {
		return hareketTuru;
	}

	public void hareketTuruBelirle(int hareketTuru) {
		if(hareketTuru > 3 || hareketTuru < 1)
			this.hareketTuru = 1;
		else
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
		this.hareketTuru = 0;
		this.tekrarSayisi = 0;
	}

	public SporEmri(int emirNo, Tarih verilmeTarihi, Tarih uygulamaTarihi, Komutan emirVerenKomutan, boolean uygulamaDurumu,
			int hareketTuru, int tekrarSayisi) {
		super(emirNo, verilmeTarihi, uygulamaTarihi, emirVerenKomutan, uygulamaDurumu);
		hareketTuruBelirle(hareketTuru);
		tekrarSayisiBelirle(tekrarSayisi);
	}
	
	private String hareketTuruString() {
		
	HashMap<Integer, String> hareketTuruMap = new HashMap<Integer, String>();
	hareketTuruMap.put(1, "Þýnav");
	hareketTuruMap.put(2, "Mekik");
	hareketTuruMap.put(3, "Barfiks");
	
	return hareketTuruMap.get(hareketTuru);
	}
	

	@Override
	public String emirMetni() {
		return "\nEmir No: " + emirNoAl() 
				+ "\nTürü: Spor\nHareket Türü: " + hareketTuruString() 
				+ "\nTekrar Sayýsý: " + tekrarSayisi 
				+ "\nVerilme Tarihi: " + verilmeTarihiAl().tarihAl() 
				+ "\nUygulama Tarihi: "	+ uygulamaTarihiAl().tarihAl() 
				+ "\nEmir Veren Komutan: " + emirVerenKomutanAl().kimlikAl()
				+ "\nUygulanma Durumu: " + (uygulamaDurumuAl() == true ? "Uygulandý" : "Uygulanmadý");
	}

	@Override
	public String emirOzeti() {
		return "Emir No: " + emirNoAl() + ", " + emirVerenKomutanAl().kimlikAl() + " tarafýndan verilen spor emri ("
				+ hareketTuruString() + ", " + tekrarSayisi + " tekrar)" + (uygulamaDurumuAl() == true ? " (+)" : "");
	}

}
