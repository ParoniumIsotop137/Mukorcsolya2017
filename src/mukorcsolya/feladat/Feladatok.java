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

}
