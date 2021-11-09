package m06.uf.exercicis;

import java.io.File;
import java.util.Scanner;

/* UF1    Accés a dades
 * Autor: Toni Chornet Anducas
 * Data : 29/09/2021
 * Facts: Demana a l'usuari un fitxer i modifica el nom
 * */

public class m06Uf1E9 {
	
	public static void main(String args[]) {

		Scanner s = new Scanner(System.in); // Create a Scanner object
		System.out.print("Indicate the absolute path: ");
		String nouNom;
		File f = new File(s.nextLine());

		try {
			if (f.exists()) {
				System.out.print("Indicate the new name: "); nouNom = s.next();
				f.renameTo(new File(f.getParent() + File.separator + nouNom));
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
