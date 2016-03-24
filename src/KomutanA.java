
public class KomutanA extends Komutan {

	public KomutanA() {
		super();
	}

	public KomutanA(int apolet, String ad, String soyad, String rutbe) {
		super(apolet, ad, soyad, rutbe);
	}

	@Override
	public String kimlikAl() {
		return rutbeAl() + " " + adAl() + " " + soyadAl() + " (" + apoletNumarasıAl() + ") (A)";
	}

}
