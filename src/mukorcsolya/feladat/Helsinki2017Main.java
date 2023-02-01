package mukorcsolya.feladat;

import java.util.List;

public class Helsinki2017Main {

	public static void main(String[] args) {

		List<Versenyzo> rovidProgram = FajlKezeles.FajlBeolvasas("F:\\Kurs\\Feladatok\\Mukorcsolya\\rovidprogram.csv",
				";");
		List<Versenyzo> donto = FajlKezeles.FajlBeolvasas("F:\\Kurs\\Feladatok\\Mukorcsolya\\donto.csv", ";");
		Feladatok feladat = new Feladatok();
		/*
		 * System.out.println("Rövidprogram:\n");
		 * rovidProgram.stream().forEach(System.out::println);
		 * System.out.println("\nDöntő:\n");
		 * donto.stream().forEach(System.out::println);
		 */

		System.out.println("2. feladat:\nA rövidprogramban " + rovidProgram.size() + " induló volt");
		System.out.println("\n3. feladat:");
		feladat.KeresesMagyarVersenyzo(donto);
	}

}
