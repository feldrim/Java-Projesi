
public class TemizlikEmri extends Emir{
	private String bolgeAdi;
	private int temizlikTuru;
	private int kisiSayisi;
	
	public String getBolgeAdi() {
		return bolgeAdi;
	}
	public void setBolgeAdi(String bolgeAdi) {
		this.bolgeAdi = bolgeAdi;
	}
	public int getTemizlikTuru() {
		return temizlikTuru;
	}
	public void setTemizlikTuru(int temizlikTuru) {
		this.temizlikTuru = temizlikTuru;
	}
	public int getKisiSayisi() {
		return kisiSayisi;
	}
	public void setKisiSayisi(int kisiSayisi) {
		this.kisiSayisi = kisiSayisi;
	}
	
	public TemizlikEmri() {
		super();
	}
	
	public TemizlikEmri(int emirNo, Tarih verilme, Tarih uygulama, Komutan emirVeren, boolean uygulandiMi, 
			String bolgeAdi, int temizlikTuru, int kisiSayisi) {
		super(emirNo, verilme, uygulama, emirVeren, uygulandiMi);
		this.bolgeAdi = bolgeAdi;
		this.temizlikTuru = temizlikTuru;
		this.kisiSayisi = kisiSayisi;
	}
	
	private String turnTemizlikTuruString(int temizlikTuru){
		switch(temizlikTuru){
			case 1:
				return "Mýntýka";
			case 2:
				return "Kýþ Temizliði";
			case 3: 
				return "Peyzaj";
			default: 
				return "Tanýmlanmadý";
		}
	}
	
	public void emriUygula(){
		this.setUygulandiMi(true);
		System.out.println(this.getEmirNo() + " numaralý temizlik emri uygulandý.");
	}
	
	@Override
	public String toString() {
		return "\nEmir No: " + (super.getEmirNo() + 1) + "\nTürü: Temizlik\nTemizlik Bölgesi: " + bolgeAdi + "\nTemizlik Türü: " + turnTemizlikTuruString(temizlikTuru) + "(" + temizlikTuru + ")" + "\nKiþi Sayýsý: " + kisiSayisi
				 + super.toString();
	}

}
