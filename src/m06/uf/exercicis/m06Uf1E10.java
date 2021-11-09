package m06.uf.exercicis;

import java.io.File;
import java.util.Scanner;

/* UF1    Accés a dades
 * Autor: Toni Chornet Anducas
 * Data : 29/09/2021
 * Facts: Mou el fitxer de l'usuari d'una ruta A a una ruta B
 * */

public class m06Uf1E10 {
	
	public static void main(String args[]) {

		Scanner s = new Scanner(System.in); // Create a Scanner object
		System.out.print("Indicate the absolute path: ");
		String nouNom;
		File f = new File(s.nextLine());
		
		try {
			if (f.exists()) {
				System.out.print("Indicate the new path: "); nouNom = s.nextLine();
				f.renameTo(new File(nouNom));
			} else {
				System.out.println("The file don't exists.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
	}
	
}
