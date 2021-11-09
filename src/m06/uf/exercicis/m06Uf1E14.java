package m06.uf.exercicis;

import java.io.File;
import java.util.Scanner;

/* UF1    Accés a dades
 * Autor: Toni Chornet Anducas
 * Data : 15/10/2021
 * Facts: Mou el fitxer de l'usuari d'una ruta A a una ruta B
 * */

public class m06Uf1E14 {
	
	public static void main(String args[]) {

		Scanner s = null;
		
		try {
			 
			File f = new File("fitxer.txt");
	        s = new Scanner(f);
	        System.out.println("Fitxer obert correctament.");
	        
	        while (s.hasNext()) {
	        	System.out.println(s.next());
	        }
	        
		} catch (Exception e) {
			
			System.out.println("Fitxer lo trobat.");
		
		} finally {
			s.close();
		} 
	}
	
}
