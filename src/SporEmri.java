
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
		System.out.println(this.getEmirNo() + " numaral� temizlik emri uyguland�.");
	}
	
	@Override
	public String toString() {
		return "\nEmir No: " + (super.getEmirNo() + 1) + "\nT�r�: Spor\nA��klama: " + aciklama + "\nTekrar Say�s�: " + tekrarSayisi + super.toString();
	}
	
}
