
public class Kontrol {
	/* gecerliTarih(): verilmeTarihi <= uygulamaTarihi && uygulamaTarihi <= sonTarih
	 * Diðer kýsýtlara bakacaðýz.
	 * 
	 * 
	 * 
	 * */
	
	private Tarih verilmeTarihi;
	private Tarih uygulamaTarihi;
	private Tarih sonTarih;
	
	
	public Kontrol(Tarih verilmeTarihi, Tarih uygulamaTarihi) {
		this.verilmeTarihi = verilmeTarihi;
		this.uygulamaTarihi = uygulamaTarihi;
	}

	

	public boolean gecerliTarih(){
		
		sonTarih = verilmeTarihi.gunSonra(100);
		
		if ((uygulamaTarihi.getYil() < verilmeTarihi.getYil())
				|| (uygulamaTarihi.getYil() == verilmeTarihi.getYil()
				&& uygulamaTarihi.getAy() < verilmeTarihi.getAy())
		|| (uygulamaTarihi.getYil() == verilmeTarihi.getYil()
				&& uygulamaTarihi.getAy() == verilmeTarihi.getAy()
				&& uygulamaTarihi.getGun() < verilmeTarihi.getGun())){
			return false;
		} else if((sonTarih.getYil() < uygulamaTarihi.getYil())
				|| (sonTarih.getYil() == uygulamaTarihi.getYil()
				&& sonTarih.getAy() < uygulamaTarihi.getAy())
		|| (sonTarih.getYil() == uygulamaTarihi.getYil()
				&& sonTarih.getAy() == uygulamaTarihi.getAy()
				&& sonTarih.getGun() < uygulamaTarihi.getGun())){
			return false;
		} else
			return true;
	}

}
