package mukorcsolya.feladat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

	public void Osszesites(List<Versenyzo> donto) {

		Map<String, Integer> osszesites = new HashMap<String, Integer>();

		for (Versenyzo versenyzo : donto) {
			osszesites.put(versenyzo.getOrszagKod(), 0);
		}

		for (Versenyzo versenyzo : donto) {
			for (Map.Entry<String, Integer> stati : osszesites.entrySet()) {
				if (stati.getKey().equals(versenyzo.getOrszagKod())) {
					stati.setValue((stati.getValue() + 1));
				}
			}

		}
		StringBuilder kiiras = new StringBuilder();

		osszesites.entrySet().stream().filter(s -> s.getValue() > 1)
				.forEach(s -> kiiras.append(s.getKey() + " : " + s.getValue() + " versenyző\n"));

		System.out.println(kiiras.toString());

	}

	public void VegeredmenyLista(List<Versenyzo> donto, List<Versenyzo> rovidProgram) {

		List<Versenyzo> eredmenyek = new ArrayList<Versenyzo>();

		for (Versenyzo versenyzo : rovidProgram) {
			for (Versenyzo versenyzoDonto : donto) {
				if (versenyzo.getNev().equals(versenyzoDonto.getNev())) {
					double osszPontszam = (((versenyzo.getTechikaiPontszam() + versenyzoDonto.getTechikaiPontszam())
							+ (versenyzo.getKomponensPontszam() + versenyzoDonto.getKomponensPontszam())));

					eredmenyek.add(new Versenyzo(versenyzo.getNev(), versenyzo.getOrszagKod(), osszPontszam, 0.0, 0.0));
				}

			}

		}

		List<Versenyzo> vegeredmeny = eredmenyek.stream()
				.sorted(Comparator.comparingDouble(n -> ((Versenyzo) n).getTechikaiPontszam()).reversed())
				.collect(Collectors.toList());

		FajlKezeles.FajlbaIras(vegeredmeny, "F:\\Kurs\\Feladatok\\Mukorcsolya\\vegeredmeny.csv", ";");
	}
}
