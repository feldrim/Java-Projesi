
public class KomutanA extends Komutan{
	private static final int LIMIT = 2; //Kullanacak m�y�z?
	

	public static final int getLimit() {
		return LIMIT;
	}


	public KomutanA() {
		super();
	}
	
	public KomutanA(int apolet, String ad, String soyad, String rutbe) {
		super(apolet, ad, soyad, rutbe);
	}


	@Override
	public String toString() {
		return super.toString() + "(A)";
	}
	
	
	

}
