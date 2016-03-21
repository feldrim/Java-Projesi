
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
				return "M�nt�ka";
			case 2:
				return "K�� Temizli�i";
			case 3: 
				return "Peyzaj";
			default: 
				return "Tan�mlanmad�";
		}
	}
	
	public void emriUygula(){
		this.setUygulandiMi(true);
		System.out.println(this.getEmirNo() + " numaral� temizlik emri uyguland�.");
	}
	
	@Override
	public String toString() {
		return "\nEmir No: " + (super.getEmirNo() + 1) + "\nT�r�: Temizlik\nTemizlik B�lgesi: " + bolgeAdi + "\nTemizlik T�r�: " + turnTemizlikTuruString(temizlikTuru) + "(" + temizlikTuru + ")" + "\nKi�i Say�s�: " + kisiSayisi
				 + super.toString();
	}

}
