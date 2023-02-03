package mukorcsolya.feladat;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

	public static void FajlbaIras(List<Versenyzo> vegeredmeny, String fajlnev, String elvalaszto) {

		try (OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fajlnev, false), "UTF-8")) {

			for (int i = 0; i < vegeredmeny.size(); i++) {

				String pontSzam = String.format("%.2f", vegeredmeny.get(i).getTechikaiPontszam());

				String kiir = String.valueOf((i + 1)) + elvalaszto + vegeredmeny.get(i).getNev() + elvalaszto
						+ vegeredmeny.get(i).getOrszagKod() + elvalaszto + pontSzam;
				out.write(kiir + "\n");

			}

		} catch (Exception e) {
			System.err.println("Hiba lépett fel az adatok fájlba írásakor!");
		}

		System.out.println("\n8. feladat: vegeredmeny.csv");
	}

}
