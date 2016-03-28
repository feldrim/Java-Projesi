import java.util.Vector;

public abstract class Komutan {
	private int apoletNumarasý;
	private String ad;
	private String soyad;
	private String rutbe;

	public int apoletNumarasýAl() {
		return apoletNumarasý;
	}

	public void apoletNumarasýBelirle(int apoletNumarasý) {
		this.apoletNumarasý = apoletNumarasý;
	}

	public String adAl() {
		return (ad == null ? "" : ad);
	}

	public void adBelirle(String ad) {
		this.ad = ad;
	}

	public String soyadAl() {
		return (soyad == null ? "" : soyad);
	}

	public void soyadBelirle(String soyad) {
		this.soyad = soyad;
	}

	public String rutbeAl() {
		return (rutbe == null ? "" : rutbe);
	}

	public void rutbeBelirle(String rutbe) {
		this.rutbe = rutbe;
	}
	
	public String komutanTuruAl(){
		return getClass().getName();
	}

	public Komutan() {
		this.apoletNumarasý = 0000;
		this.ad = "";
		this.soyad = "";
		this.rutbe = "";
	}

	public Komutan(int apolet, String ad, String soyad, String rutbe) {
		this.apoletNumarasý = apolet;
		this.ad = ad;
		this.soyad = soyad;
		this.rutbe = rutbe;
	}

	public String kimlikAl(){
		return rutbeAl() + " " + adAl() + " " + soyadAl() + " (" + apoletNumarasýAl() + ") (" + komutanTuruAl() + ")";
	}

}
