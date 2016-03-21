
public class SporEmri extends Emir{
	private String aciklama;
	private int tekrarSayisi;
	
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	public int getTekrarSayisi() {
		return tekrarSayisi;
	}
	public void setTekrarSayisi(int tekrarSayisi) {
		this.tekrarSayisi = tekrarSayisi;
	}

	public SporEmri(int emirNo, Tarih verilme, Tarih uygulama, Komutan emirVeren, boolean uygulandiMi, String aciklama,
			int tekrarSayisi) {
		super(emirNo, verilme, uygulama, emirVeren, uygulandiMi);
		this.aciklama = aciklama;
		this.tekrarSayisi = tekrarSayisi;
	}
	
	public void emriUygula(){
		this.setUygulandiMi(true);
		System.out.println(emirOzeti() + " uygulandý.");
	}
	
	@Override
	public String emirMetni() {
		return "\nEmir No: " + getEmirNo() + "\nTürü: Spor\nAçýklama: " + aciklama + "\nTekrar Sayýsý: " + tekrarSayisi + "\nVerilme Tarihi: " + getVerilme().tarihAl() + "\nUygulama Tarihi: " + getUygulama().tarihAl() + "\nEmir Veren Komutan: " + getEmirVeren().kimlikAl() +"\nUygulanma Durumu: " + (isUygulandiMi() == true ? "Uygulandý" : "Uygulanmadý");
	}
	@Override
	public String emirOzeti() {
		return "Emir No: "+ getEmirNo() + ", " + getEmirVeren().kimlikAl() + " tarafýndan verilen spor emri (" + aciklama + ", " + tekrarSayisi + " tekrar)" + (isUygulandiMi() == true ? " +" : "");
	}
	
}
