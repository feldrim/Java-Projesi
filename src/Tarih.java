import java.util.Locale;


public class Tarih {
	private int gun;
	private int ay;
	private int yil;
	
	public int getGun() {
		return gun;
	}
	public void setGun(int gun) {
		if(gun >0 && gun<=30)
			this.gun = gun;
		else
			this.gun = 1;
	}
	public int getAy() {
		return ay;
	}
	public void setAy(String ay) {
		switch(ay.toLowerCase(Locale.ROOT)){
		
		case "ocak":
		case "1":
		case "01":
			this.ay = 1;
			break;
			
		case "þubat":
		case "2":
		case "02":
			this.ay = 2;
			break;
			
		case "mart":
		case "3":
		case "03":
			this.ay = 3;
			break;
			
		case "nisan":
		case "4":
		case "04":
			this.ay = 4;
			break;
	
		case "mayýs":
		case "5":
		case "05":
			this.ay = 5;
			break;
			
		case "haziran":
		case "6":
		case "06":
			this.ay = 6;
			break;
			
		case "temmuz":
		case "7":
		case "07":
			this.ay = 7;
			break;
		
		case "aðustos":
		case "8":
		case "08":
			this.ay = 8;
			break;
			
		case "eylül":
		case "9":
		case "09":
			this.ay = 9;
			break;
			
		case "ekim":
		case "10":
			this.ay = 10;
			break;
			
		case "kasým":
		case "11":
			this.ay = 11;
			break;
			
		case "aralýk":
		case "12":
			this.ay = 12;
			break;
			
		default:
			this.ay = 1;
			break;
		}
	}
	public int getYil() {
		return yil;
	}
	public void setYil(int yil) {
		if(yil >= 2016 && yil <= 2100)
			this.yil = yil;
		else
			this.yil = 2016;
	}
	
	public Tarih() {
		this.gun = 1;
		this.ay = 1;
		this.yil = 2016;
	}
	
	public Tarih(int gun, String ay, int yil) { //nextInt() -> next()
		setGun(gun);
		setAy(ay);
		setYil(yil);
	}
	public String tarihAl() {
		return gun + "." + ay + "." + yil;
	}
	
}
