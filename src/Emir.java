
public abstract class Emir {
	private int emirNo;
	private Tarih verilme;
	private Tarih uygulama;
	private Komutan emirVeren;
	private boolean uygulandiMi;
		
	public int getEmirNo() {
		return emirNo;
	}
	public void setEmirNo(int emirNo) {
		this.emirNo = emirNo;
	}
	public Tarih getVerilme() {
		return verilme;
	}
	public void setVerilme(Tarih verilme) {
		this.verilme = verilme;
	}
	public Tarih getUygulama() {
		return uygulama;
	}
	public void setUygulama(Tarih uygulama) {
		this.uygulama = uygulama;
	}
	public boolean isUygulandiMi() {
		return uygulandiMi;
	}
	public void setUygulandiMi(boolean uygulandiMi) {
		this.uygulandiMi = uygulandiMi;
	}
	public Komutan getEmirVeren() {
		return emirVeren;
	}
	public void setEmirVeren(Komutan emirVeren) {
		this.emirVeren = emirVeren;
	}
	
	public Emir() {
		this.emirNo = 0;
		this.verilme = null;
		this.uygulama = null;
		this.emirVeren = null;
		this.uygulandiMi = false;
	}
	
	public Emir(int emirNo, Tarih verilme, Tarih uygulama, Komutan emirVeren, boolean uygulandiMi) {
		this.emirNo = emirNo;
		this.verilme = verilme;
		this.uygulama = uygulama;
		this.emirVeren = emirVeren;
		this.uygulandiMi = uygulandiMi;
	}
	
	public abstract void emriUygula();
	
	public abstract String emirMetni();
	
	public abstract String emirOzeti();
	

}
