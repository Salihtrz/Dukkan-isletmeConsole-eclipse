import java.util.*;

public class Arayuz {
	BankaHesap1 bankaHesap1;
	BankaHesap2 bankaHesap2;
	Dukkan dukkan;
	Scanner scan = new Scanner(System.in);
	int secenek, hsecenek;
	String adsoyad, sifre = "1905";
	public void giris() {
		System.out.println("Adsoyad giriniz: ");
		adsoyad = scan.nextLine();
		for (int i = 2; i >= 0; i--) {
			System.out.println("Sifrenizi giriniz: ");
			System.out.println("Cikmak icin <Q> tuslayiniz: ");
			String sifre2 = scan.next();
			sifre2 = sifre2.toUpperCase();
			if (sifre2.equals(sifre)) {
				hesapla();
			}else if(sifre2.equals("Q")) {
				i=0;
			}
			else {
				System.out.println("Girdiginiz sifre hatalidir!!" + i + " hakkiniz kaldi.");
			}
		}
	}

	public void hesapla() {
		bankaHesap1 = new BankaHesap1(20000, adsoyad, "1234");
		bankaHesap2 = new BankaHesap2(50000, adsoyad, "5678");
		dukkan = new Dukkan(3, 3, 3, 50);
		while (true) {
			System.out.println("Islem yapmak istediginiz hesabi tuslayiniz: ");
			System.out.println("1-> 1. Hesap");
			System.out.println("2-> 2. Hesap");
			System.out.println("3-> Dukkan");
			System.out.println("4-> Cikis");
			int hsecenek = scan.nextInt();
			while (hsecenek < 0 || hsecenek > 4) {
				System.out.println("Lutfen gecerli bir secim yapiniz!");
				hsecenek = scan.nextInt();
			}
			switch (hsecenek) {
			case 1:

				System.out.println("Yapmak istediginiz islemi tuslayiniz: ");
				System.out.println("1-> Para Yatirma");
				System.out.println("2-> Para Cekme");
				System.out.println("3-> Para Gonder");
				System.out.println("4-> Hesap Bilgileri");
				System.out.println("5-> Cikis");
				int secenek = scan.nextInt();
				while (secenek < 0 || secenek > 5) {
					System.out.println("Lutfen gecerli bir secim yapiniz!");
					secenek = scan.nextInt();

				}
				switch (secenek) {
				case 1:
					bankaHesap1.yatir();
					break;
				case 2:
					bankaHesap1.cek();
					break;
				case 3:
					bankaHesap1.gonder(bankaHesap2);
					break;
				case 4:
					bankaHesap1.goruntule();
					break;
				case 5:
					break;
				}
				break;
			case 2:

				System.out.println("Yapmak istediginiz islemi tuslayiniz: ");
				System.out.println("1-> Para Yatirma");
				System.out.println("2-> Para Cekme");
				System.out.println("3-> Para Gonder");
				System.out.println("4-> Hesap Bilgileri");
				System.out.println("5-> Cikis");
				int secenek2 = scan.nextInt();
				while (secenek2 < 0 || secenek2 > 5) {
					System.out.println("Lutfen gecerli bir secim yapiniz!");
					secenek2 = scan.nextInt();

				}
				switch (secenek2) {
				case 1:
					bankaHesap2.yatir();
					break;
				case 2:
					bankaHesap2.cek();
					break;
				case 3:
					bankaHesap2.gonder(bankaHesap1);
					break;
				case 4:
					bankaHesap2.goruntule();
					break;
				case 5:
					break;
				}
				break;
			case 3:
				System.out.println("Yapmak istediginiz islemi tuslayiniz: ");
				System.out.println("1-> Dukkanda urun satisi");
				System.out.println("2-> Dukkana urun alisi");
				System.out.println("3-> Kasadan " + bankaHesap1.getHesapnumarasi() + " numarali hesaba para aktarma");
				System.out.println("4-> Kasadan " + bankaHesap2.getHesapnumarasi2() + " numarali hesaba para aktarma");
				System.out.println("5-> Dukkan bilgileri");
				System.out.println("6-> Geri donmek icin");
				int secenek3 = scan.nextInt();
				while (secenek3 < 0 || secenek3 > 6) {
					System.out.println("Lutfen gecerli bir secim yapiniz!");
					secenek3 = scan.nextInt();
				}
				switch (secenek3) {
				case 1:
					dukkan.satıs();
					break;
				case 2:
					dukkan.alıs();
					break;
				case 3:
					dukkan.aktar1(bankaHesap1);
					break;
				case 4:
					dukkan.aktar2(bankaHesap2);
					break;
				case 5:
					dukkan.goruntule();
					break;
				case 6:
					break;
				}
				if (secenek3 == 6) {
					break;
				}
			}
			if (hsecenek == 4) {
				break;
			}
		}
	}
}