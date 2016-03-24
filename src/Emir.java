
public abstract class Emir {
	private int emirNo;
	private Tarih verilmeTarihi;
	private Tarih uygulamaTarihi;
	private Komutan emirVerenKomutan;
	private boolean uygulamaDurumu;

	public int emirNoAl() {
		return emirNo;
	}

	public void emirNoBelirle(int emirNo) {
		this.emirNo = emirNo;
	}

	public Tarih verilmeTarihiAl() {
		return verilmeTarihi;
	}

	public void verilmeTarihiBelirle(Tarih verilmeTarihi) {
		this.verilmeTarihi = verilmeTarihi;
	}

	public Tarih uygulamaTarihiAl() {
		return uygulamaTarihi;
	}

	public void uygulamaTarihiBelirle(Tarih uygulama) {
		this.uygulamaTarihi = uygulama;
	}

	public boolean uygulamaDurumuAl() {
		return uygulamaDurumu;
	}

	public void uygulamaDurumuBelirle(boolean uygulamaDurumu) {
		this.uygulamaDurumu = uygulamaDurumu;
	}

	public Komutan emirVerenKomutanAl() {
		return emirVerenKomutan;
	}

	public void emirVerenKomutanBelirle(Komutan emirVerenKomutan) {
		this.emirVerenKomutan = emirVerenKomutan;
	}

	public Emir() {
		this.emirNo = 0;
		this.verilmeTarihi = null;
		this.uygulamaTarihi = null;
		this.emirVerenKomutan = null;
		this.uygulamaDurumu = false;
	}

	public Emir(int emirNo, Tarih verilmeTarihi, Tarih uygulamaTarihi, Komutan emirVerenKomutan, boolean uygulamaDurumu) {
		this.emirNo = emirNo;
		this.verilmeTarihi = verilmeTarihi;
		this.uygulamaTarihi = uygulamaTarihi;
		this.emirVerenKomutan = emirVerenKomutan;
		this.uygulamaDurumu = uygulamaDurumu;
	}

	public abstract void emriUygula();

	public abstract String emirMetni();

	public abstract String emirOzeti();

}
