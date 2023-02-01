package mukorcsolya.feladat;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FajlKezeles {

	public static List<Versenyzo> FajlBeolvasas(String fajlnev, String elvalaszto) {
		List<Versenyzo> versenyzok = new ArrayList<Versenyzo>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlnev), "UTF-8"))) {

			br.readLine();

			while (br.ready()) {

				String[] sor = br.readLine().split(elvalaszto);

				versenyzok.add(new Versenyzo(sor[0], sor[1], Double.parseDouble(sor[2]), Double.parseDouble(sor[3]),
						Double.parseDouble(sor[4])));

			}

		} catch (Exception e) {
			System.err.println("Hiba lépett fel az adatok beolvasásakor!");
		}

		return versenyzok;
	}

}
