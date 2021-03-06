import java.util.Locale;
import java.util.Scanner;

public class Tarih {

	private int gun;
	private int ay;
	private int yil;

	Scanner sc = new Scanner(System.in);

	public int gunAl() {
		return gun;
	}

	public void gunBelirle(String gunString) {
		int gun = Integer.parseInt(gunString);//deneme maksatl� yaz�ld�
		
		if (gun > 0 && gun <= 30)
			this.gun = gun;
		else
			this.gun = 1;
	}

	public int ayAl() {
		return ay;
	}

	public void ayBelirle(String ay) {
		switch (ay.toLowerCase(Locale.ROOT)) {

		case "ocak":
		case "1":
		case "01":
			this.ay = 1;
			break;

		case "�ubat":
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

		case "may�s":
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

		case "a�ustos":
		case "8":
		case "08":
			this.ay = 8;
			break;

		case "eyl�l":
		case "9":
		case "09":
			this.ay = 9;
			break;

		case "ekim":
		case "10":
			this.ay = 10;
			break;

		case "kas�m":
		case "11":
			this.ay = 11;
			break;

		case "aral�k":
		case "12":
			this.ay = 12;
			break;

		default:
			this.ay = 1;
			break;
		}
	}

	public int yilAl() {
		return yil;
	}

	public void yilBelirle(String yilString) {
		int yil = Integer.parseInt(yilString);
		
		if (yil >= 2016 && yil <= 2100)
			this.yil = yil;
		else
			this.yil = 2016;
	}

	public Tarih() {
		this.gun = 1;
		this.ay = 1;
		this.yil = 2016;
	}

	public Tarih(String gun, String ay, String yil) {
		gunBelirle(gun);
		ayBelirle(ay);
		yilBelirle(yil);
	}

	public String tarihAl() {
		return gun + "." + ay + "." + yil;
	}

	public Tarih tarihAyarla() {
		System.out.println("G�n:");
		String gun = sc.next();
		System.out.println("Ay: ");
		String ay = sc.next();
		System.out.println("Y�l: ");
		String yil = sc.next();
		return new Tarih(gun, ay, yil);
	}

	public Tarih gunSonra(int ileri) {

		int sonrakiGun = (gun + ileri) % 30;
		if (sonrakiGun == 0)
			sonrakiGun = 30;

		int sonrakiAy = (ay + ((gun + ileri) / 30)) % 12;
		if (sonrakiAy == 0)
			sonrakiAy = 12;

		int sonrakiYil = ((ay + ((gun + ileri) / 30)) <= 12 ? yil : yil + 1);

		return new Tarih( Integer.toString(sonrakiGun), Integer.toString(sonrakiAy), Integer.toString(sonrakiYil) );

	}

	public boolean gecerliTarih(Tarih uygulamaTarihi) {

		Tarih sonTarih = gunSonra(10);

		if ((uygulamaTarihi.yilAl() < yilAl()) || (uygulamaTarihi.yilAl() == yilAl() && uygulamaTarihi.ayAl() < ayAl())
				|| (uygulamaTarihi.yilAl() == yilAl() && uygulamaTarihi.ayAl() == ayAl()
						&& uygulamaTarihi.gunAl() < gunAl())) {
			return false;
		} else if ((sonTarih.yilAl() < uygulamaTarihi.yilAl())
				|| (sonTarih.yilAl() == uygulamaTarihi.yilAl() && sonTarih.ayAl() < uygulamaTarihi.ayAl())
				|| (sonTarih.yilAl() == uygulamaTarihi.yilAl() && sonTarih.ayAl() == uygulamaTarihi.ayAl()
						&& sonTarih.gunAl() < uygulamaTarihi.gunAl())) {
			return false;
		} else
			return true;
	}

}
