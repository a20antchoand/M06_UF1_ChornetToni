package m06.uf.exercicis;

import java.io.File;
import java.util.Scanner;

/* UF1    Accés a dades
 * Autor: Toni Chornet Anducas
 * Data : 15/10/2021
 * Facts: Mou el fitxer de l'usuari d'una ruta A a una ruta B
 * */

public class m06Uf1E15 {
	
	static String EOF = "FI";
	
	public static void  main(String args[]) {
		
		Scanner s = null;
		
		try {
			System.out.println("La carpeta de treball es: " + System.getProperty("user.dir"));
			File f = new File("fitxer.txt");
			s = new Scanner(f);
	        System.out.println("Fitxer obert correctament.");
	        cerca(s);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
	}

	public static void cerca(Scanner s) {
		boolean op = false;
		String paraula;
		while (s.hasNext() && !op) {
			paraula = s.next();
			if (!paraula.equals(EOF)) {
				System.out.println(paraula);
			} else {
				op = true;
			}
        }
		
	}
	
}
