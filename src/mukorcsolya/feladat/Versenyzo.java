package mukorcsolya.feladat;

public class Versenyzo {

	private String nev;
	private String orszagKod;
	private double techikaiPontszam;
	private double komponensPontszam;
	private double levonas;

	public Versenyzo(String nev, String orszagKod, double techikaiPontszam, double komponensPontszam, double levonas) {
		this.nev = nev;
		this.orszagKod = orszagKod;
		this.techikaiPontszam = techikaiPontszam;
		this.komponensPontszam = komponensPontszam;
		this.levonas = levonas;
	}

	public String getNev() {
		return nev;
	}

	public String getOrszagKod() {
		return orszagKod;
	}

	public double getTechikaiPontszam() {
		return techikaiPontszam;
	}

	public double getKomponensPontszam() {
		return komponensPontszam;
	}

	public double getLevonas() {
		return levonas;
	}

	@Override
	public String toString() {
		return "Versenyző neve: " + this.nev + ", országkód: " + this.orszagKod + ", techikai pontszám: "
				+ this.techikaiPontszam + ", komponens pontszám: " + this.komponensPontszam + ", levonás: "
				+ this.levonas;
	}

}
