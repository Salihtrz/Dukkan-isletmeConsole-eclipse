import java.util.Scanner;

public class BankaHesap2 {
	Scanner scan = new Scanner(System.in);
	private double miktar2;
	private String adsoyad2, hesapnumarasi2;

	public BankaHesap2(double miktar2, String adsoyad2, String hesapnumarasi2) {
		this.miktar2 = miktar2;
		this.adsoyad2 = adsoyad2;
		this.hesapnumarasi2 = hesapnumarasi2;
	}

	public void goruntule() {
		System.out.println(
				"AdSoyad: " + getAdsoyad2() + " Hesapnumarasi: " + getHesapnumarasi2() + " Bakiye: " + getMiktar2());
	}

	public void yatir() {
		System.out.println("Yuklemek istediginiz tutari giriniz: ");
		int parayatir = scan.nextInt();
		if (parayatir >= 5000) {
			System.out.println("Tek seferde 5000 TL veya daha fazla para yatirilamamaktadir!!");
		} else {
			if (onayla()) {
				miktar2 = miktar2 + parayatir;
				System.out.println(parayatir + " TL hesabiniza yatirildi. Hesabinizdaki toplam miktar " + miktar2
						+ " TL olmustur.");
			}
		}
	}

	public void cek() {
		double kesim = 0.001;
		System.out.println("Cekmek istediginiz tutari giriniz:");
		int paracek = scan.nextInt();
		if (paracek > miktar2) {
			System.out.println("Hesapta yeterli bakiye bulunmamaktadir!!");
		} else if (paracek >= 5000) {
			if (onayla()) {
				if((paracek * 1 / 1000) + paracek > miktar2) {
					System.out.println("Hesabinizda kesim ucretini karsilayacak bakiye yoktur.");
				}else {
				miktar2 = miktar2 - (paracek * 1 / 1000) - paracek;
				System.out.println((paracek * kesim) + " TL kesilmistir.");
				}
			}
		} else {
			if (onayla()) {
				miktar2 = miktar2 - paracek;
				System.out.println(
						paracek + " TL hesabinizdan cekildi. Hesabinizdaki toplam miktar " + miktar2 + " TL olmustur.");
			}
		}
	}

	public boolean onayla() {

		System.out.println("Islemi Onaylamak icin <E> Iptal etmek icin <H> tuslayiniz.");
		String key = scan.next();
		key = key.toUpperCase();
		if (key.equals("E")) {
			return true;
		} else {
			System.out.println("Islem iptal edildi.");
			return false;
		}
	}

	public void gonder(BankaHesap1 bankahesap1) {
		System.out.println("Gondermek istediginiz miktari giriniz: ");
		double havale = scan.nextInt();
		if (miktar2 >= havale) {
			miktar2 = miktar2 - havale;
			bankahesap1.setMiktar(bankahesap1.getMiktar() + havale);
			System.out.println(havale + " TL hesabiniza aktarildi.");
		} else {
			System.out.println("Hesabinizda yeterli bakiye yoktur!!");
		}
	}

	public double getMiktar2() {
		return miktar2;
	}

	public void setMiktar2(double miktar2) {
		this.miktar2 = miktar2;
	}

	public String getAdsoyad2() {
		return adsoyad2;
	}

	public void setAdsoyad2(String adsoyad2) {
		this.adsoyad2 = adsoyad2;
	}

	public String getHesapnumarasi2() {
		return hesapnumarasi2;
	}

	public void setHesapnumarasi2(String hesapnumarasi2) {
		this.hesapnumarasi2 = hesapnumarasi2;
	}
}