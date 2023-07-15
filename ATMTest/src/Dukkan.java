import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Dukkan {
	Scanner scan = new Scanner(System.in);
	Random r = new Random();
	VeriTabani conn = new VeriTabani();
	Connection con = conn.connDb();
	PreparedStatement preparedStatement = null;
	Statement st = null;
	ResultSet rs = null;
	private int cikolata = 10, biskuvi = 10, kek = 10;
	private double kasa = 0;

	public Dukkan(int cikolata, int biskuvi, int kek, int kasa) {
		super();
		this.cikolata = cikolata;
		this.biskuvi = biskuvi;
		this.kek = kek;
		this.kasa = kasa;
	}

	public void satıs() {
		String secim;
		int musteri = 1, i = r.nextInt(10) + 1;
		System.out.println(i + " musteri dukkana gelmistir.");
		System.out.println("Hosgeldiniz");
		while (true) {
			
			for (int j = 1; j <= i; j++) {
				System.out.println(j + ". musteri satin almak icin geliyor.");
				System.out.println("Cikolata almak icin <C>");
				System.out.println("Biskuvi almak icin <B>");
				System.out.println("Kek almak icin <K>");
				System.out.println("Dukkandan cikmak icin <Q>");
				secim = scan.next();
				secim = secim.toUpperCase();
				switch (secim) {
				case "C":
					if (cikolata <= 0) {
						System.out.println("Dukkanda cikolata kalmamistir.");
						break;
					} else {
						kasa = kasa + (musteri * 5);
						System.out.println("Kasadaki mevcut para: " + kasa);
						cikolata--;
					}
					break;
				case "B":
					if (biskuvi <= 0) {
						System.out.println("Dukkanda biskuvi kalmamistir.");
					} else {
						kasa = kasa + (musteri * 10);
						System.out.println("Kasadaki mevcut para: " + kasa);
						biskuvi--;
					}
					break;
				case "K":
					if (kek <= 0) {
						System.out.println("Dukkanda kek kalmamistir.");
					} else {
						kasa = kasa + (musteri * 3);
						System.out.println("Kasadaki mevcut para: " + kasa);
						kek--;
					}
					break;
				case "Q":
					System.out.println(j + ". musteri dukkandan cikmistir");
					break;
				default:
					System.out.println("Yaptiginiz secim hatalidir. Tekrar deneyiniz.");
					j--;
					break;
				}
			}
			int gun = 0;
			gun++;
			System.out.println(gun + ". gun sona erdi. Dukkani kapatmak icin herhangi bir tusa basiniz.");
			secim = scan.next();
			secim = secim.toUpperCase();
			if (secim.equals(toString())) {
				break;
			} else {
				break;
			}
		}
	}

	public void alıs() {
		String secim;
		int adet;
		while (true) {
			System.out.println("Toptanciya geldiniz.");
			System.out.println("Dukkana tanesi 3 TL olan cikolatadan almak icin <C>");
			System.out.println("Dukkana tanesi 7 TL olan biskuviden almak icin <B>");
			System.out.println("Dukkana tanesi 2 TL olan kekden almak icin <K>");
			secim = scan.next();
			secim = secim.toUpperCase();
			switch (secim) {
			case "C":
				System.out.println("Ne kadar satin almak istiyorsunuz: ");
				adet = scan.nextInt();
				if (kasa < (3 * adet)) {
					System.out.println("Kasada yeterli bakiye yoktur!");
				} else {
					cikolata = cikolata + adet;
					kasa = kasa - (3 * adet);
					System.out.println(adet + " cikolata satin aldiniz. Dukkandaki toplam cikolata " + cikolata
							+ " olmustur. Kasadaki para " + kasa + " olmustur.");
				}
				break;
			case "B":
				System.out.println("Ne kadar satin almak istiyorsunuz: ");
				adet = scan.nextInt();
				if (kasa < (7 * adet)) {
					System.out.println("Kasada yeterli bakiye yoktur!");
				} else {
					biskuvi = biskuvi + adet;
					kasa = kasa - (7 * adet);
					System.out.println(adet + " biskuvi satin aldiniz. Dukkandaki toplam biskuvi " + biskuvi
							+ " olmustur. Kasadaki para " + kasa + " olmustur.");	
				}
				break;
			case "K":
				System.out.println("Ne kadar satin almak istiyorsunuz: ");
				adet = scan.nextInt();
				if (kasa < (2 * adet)) {
					System.out.println("Kasada yeterli bakiye yoktur!");
				} else {
					kek = kek + adet;
					kasa = kasa - (2 * adet);
					System.out.println(adet + " kek satin aldiniz. Dukkandaki toplam kek " + kek
							+ " olmustur. Kasadaki para " + kasa + " olmustur.");
				}
				break;
			default:
				System.out.println("Hatali secim yaptiniz!!");
				break;
			}
			System.out.println("Geri donmek icin herhangi bir tusa basiniz: ");
			secim = scan.next();
			secim = secim.toUpperCase();
			if (secim.equals(toString())) {
				break;
			} else {
				break;
			}
		}
	}

	public void aktar1(BankaHesap1 bankaHesap1) {
		System.out.println("Gondermek istediginiz miktari giriniz: ");
		double havale = scan.nextInt();
		if (havale > kasa) {
			System.out.println("Kasanizda yeterli bakiye yoktur.");
		} else {
			kasa = kasa - havale;
			bankaHesap1.setMiktar(bankaHesap1.getMiktar() + havale);
			System.out.println(havale + " TL hesabibiza aktarildi.");
		}
	}

	public void aktar2(BankaHesap2 bankaHesap2) {
		System.out.println("Gondermek istediginiz miktari giriniz: ");
		double havale = scan.nextInt();
		if (havale > kasa) {
			System.out.println("Kasanizda yeterli bakiye yoktur.");
		} else {
			kasa = kasa - havale;
			bankaHesap2.setMiktar2(bankaHesap2.getMiktar2() + havale);
			System.out.println(havale + " TL hesabibiza aktarildi.");
		}
	}

	public void goruntule() {
		System.out.println("Kasanizdaki toplam bakiye: " + kasa + " TL" + "\nKalan cikolata sayisi: " + cikolata
				+ "\nKalan biskuvi sayisi: " + biskuvi + "\nKalan kek sayisi: " + kek);
	}
	
	

	public int getCikolata() {
		return cikolata;
	}

	public void setCikolata(int cikolata) {
		this.cikolata = cikolata;
	}

	public int getBiskuvi() {
		return biskuvi;
	}

	public void setBiskuvi(int biskuvi) {
		this.biskuvi = biskuvi;
	}

	public int getKek() {
		return kek;
	}

	public void setKek(int kek) {
		this.kek = kek;
	}

	public double getKasa() {
		return kasa;
	}

	public void setKasa(double kasa) {
		this.kasa = kasa;
	}

}
