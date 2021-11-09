package m06.uf.exercicis;

import java.io.File;
import java.util.Scanner;

/* UF1    Accés a dades
 * Autor: Toni Chornet Anducas
 * Data : 15/10/2021
 * Facts: Mou el fitxer de l'usuari d'una ruta A a una ruta B
 * */

public class m06Uf1E16 {
		
	public static void  main(String args[]) {
		
		Scanner source = null;
		Scanner scan = null;
		String paraula = "";
		
		try {
			
			System.out.println("La carpeta de treball es: " + System.getProperty("user.dir"));
			File f = new File("fitxer.txt");
			
			source = new Scanner(f);
	        System.out.print("Indica la paraula a cercar: ");
	        
	        scan = new Scanner(System.in);
	        paraula = scan.next();
			
	        cerca(source, paraula);
	        
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			source.close();
	        scan.close();
	        
		}
	}

	public static void cerca(Scanner s, String paraula) {
		int cont = 0;
		while (s.hasNext()) {
			if (s.next().equals(paraula)) {
				cont++;
			}
        }
		
		System.out.println("La paraula " + paraula + " s'ha trobat " + cont + " vegades.");
		
	}
	
}
