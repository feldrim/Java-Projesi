
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
	
	private String turnTemizlikTuruString(){
		switch(temizlikTuru){
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
	
	public void emriUygula(){
		this.setUygulandiMi(true);
		System.out.println(emirOzeti() + " uygulandý.");
	}
	
	@Override
	public String emirMetni() {
		return "\nEmir No: " + (getEmirNo()) + "\nTürü: Temizlik\nTemizlik Bölgesi: " + bolgeAdi + "\nTemizlik Türü: " + turnTemizlikTuruString() + "(" + temizlikTuru + ")" + "\nKiþi Sayýsý: " + kisiSayisi + "\nVerilme Tarihi: " + getVerilme().tarihAl() + "\nUygulama Tarihi: " + getUygulama().tarihAl() + "\nEmir Veren Komutan: " + getEmirVeren().kimlikAl() +"\nUygulanma Durumu: " + (isUygulandiMi() == true ? "Uygulandý" : "Uygulanmadý");
	}
	@Override
	public String emirOzeti() {
		return "Emir No: "+ getEmirNo() + ", " + getEmirVeren().kimlikAl() + " tarafýndan verilen temizlik emri (" + bolgeAdi + " bölgesinde " + kisiSayisi + " kiþi ile " + turnTemizlikTuruString() + ")" + (isUygulandiMi() == true ? " +" : "");
	}

	

}
