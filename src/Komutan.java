
public abstract class Komutan {
	private int apolet;
	private String ad;
	private String soyad;
	private String rutbe; //sonra int olarak ayarlanýp switch case ile seçmek mümkün olacak
	public int getApolet() {
		return apolet;
	}
	public void setApolet(int apolet) {
		this.apolet = apolet;
	}
	public String getAd() {
		return (ad==null ? "" : ad);
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return (soyad==null ? "" : soyad);
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public String getRutbe() {
		return (rutbe==null ? "" : rutbe);
	}
	public void setRutbe(String rutbe) {
		this.rutbe = rutbe;
	}
	
	public Komutan() {
		this.apolet = 0000;
		this.ad = "";
		this.soyad = "";
		this.rutbe = "";
	}
	
	public Komutan(int apolet, String ad, String soyad, String rutbe) {
		this.apolet = apolet;
		this.ad = ad;
		this.soyad = soyad;
		this.rutbe = rutbe;
	}
	

	
	public abstract String kimlikAl();
	
	
	

}
