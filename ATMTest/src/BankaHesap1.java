import java.util.Scanner;

public class BankaHesap1{
	Scanner scan = new Scanner(System.in);
	private double miktar;
	private String adsoyad, hesapnumarasi;

	public BankaHesap1(double miktar, String adsoyad, String hesapnumarasi) {
		super();
		this.miktar = miktar;
		this.adsoyad = adsoyad;
		this.hesapnumarasi = hesapnumarasi;
	}

	public void goruntule() {
		System.out.println(
				"AdSoyad: " + getAdsoyad() + " Hesapnumarasi: " + getHesapnumarasi() + " Bakiye: " + getMiktar());
	}

	public void yatir() {
		System.out.println("Yuklemek istediginiz tutari giriniz: ");
		int parayatir = scan.nextInt();
		if (parayatir >= 5000) {
			System.out.println("Tek seferde 5000 TL veya daha fazla para yatirilamamaktadir!!");
		} else {
			if (onayla()) {
				miktar = miktar + parayatir;
				System.out.println(parayatir + " TL hesabiniza yatirildi. Hesabinizdaki toplam miktar " + miktar
						+ " TL olmustur.");
			}
		}
	}

	public void cek() {
		double kesim = 0.001;
		System.out.println("Cekmek istediginiz tutari giriniz:");
		int paracek = scan.nextInt();
		if (paracek > miktar) {
			System.out.println("Hesapta yeterli bakiye bulunmamaktadir!!");
		} else if (paracek >= 5000) {
			if (onayla()) {
				if((paracek * 1 / 1000) + paracek > miktar) {
					System.out.println("Hesabinizda kesim ucretini karsilayacak bakiye yoktur.");
				}else {
				miktar = miktar - (paracek * 1 / 1000) - paracek;
				System.out.println((paracek * kesim) + " TL kesilmistir.");
				}
			}
		} else {
			if (onayla()) {
				miktar = miktar - paracek;
				System.out.println(
						paracek + " TL hesabinizdan cekildi. Hesabinizdaki toplam miktar " + miktar + " TL olmustur.");
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

	public void gonder(BankaHesap2 bankahesap2) {
		System.out.println("Gondermek istediginiz miktari giriniz: ");
		double havale = scan.nextInt();
		if (miktar >= havale) {
			miktar = miktar - havale;
			bankahesap2.setMiktar2(bankahesap2.getMiktar2() + havale);
			System.out.println(havale + " TL hesabiniza aktarildi.");
		} else {
			System.out.println("Hesabinizda yeterli bakiye yoktur!!");
		}
	}

	public double getMiktar() {
		return miktar;
	}

	public void setMiktar(double miktar) {
		this.miktar = miktar;
	}

	public String getAdsoyad() {
		return adsoyad;
	}

	public void setAdsoyad(String adsoyad) {
		this.adsoyad = adsoyad;
	}

	public String getHesapnumarasi() {
		return hesapnumarasi;
	}

	public void setHesapnumarasi(String hesapnumarasi) {
		this.hesapnumarasi = hesapnumarasi;
	}

}