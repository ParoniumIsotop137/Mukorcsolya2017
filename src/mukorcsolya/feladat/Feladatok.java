package mukorcsolya.feladat;

import java.util.List;

public class Feladatok {

	public void KeresesMagyarVersenyzo(List<Versenyzo> donto) {

		int i = 0;

		while (i < donto.size() && !donto.get(i).getOrszagKod().equalsIgnoreCase("HUN")) {
			i++;
		}

		if (i < donto.size()) {
			System.out.println("A magyar versenyző bejutott a kűrbe.");
		} else {
			System.out.println("Nem jutott be magyar versenyző a kűrbe.");
		}
	}

	public void OsszPontszam(List<Versenyzo> rovidProgram, List<Versenyzo> donto, String nev) {

		double osszPontSzam = 0.0;

		for (Versenyzo versenyzo : rovidProgram) {
			if (versenyzo.getNev().equalsIgnoreCase(nev)) {
				osszPontSzam = versenyzo.getTechikaiPontszam() + versenyzo.getKomponensPontszam();
				for (Versenyzo dontos : donto) {
					if (dontos.getNev().equalsIgnoreCase(nev)) {
						osszPontSzam += dontos.getTechikaiPontszam() + dontos.getKomponensPontszam();
					}
				}
			}
		}

		System.out.println("\n6. feladat:\nA versenyző összpontszáma: " + osszPontSzam);

	}

	public void KeresesNevre(List<Versenyzo> donto, List<Versenyzo> rovidProgram, String nev) {

		int i = 0;

		while (i < rovidProgram.size() && !rovidProgram.get(i).getNev().equalsIgnoreCase(nev)) {
			i++;
		}

		if (i < rovidProgram.size()) {
			OsszPontszam(rovidProgram, donto, nev);
		} else {
			System.out.println("Ilyen nevű induló nem volt!");
		}

	}
}
