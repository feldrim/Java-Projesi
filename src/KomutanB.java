
public class KomutanB extends Komutan {

	public KomutanB() {
		super();
	}

	public KomutanB(int apolet, String ad, String soyad, String rutbe) {
		super(apolet, ad, soyad, rutbe);
	}

	@Override
	public String kimlikAl() {
		return rutbelAl() + " " + adAl() + " " + soyadAl() + " (" + apoletNumarasýAl() + ") (B)";
	}

}
