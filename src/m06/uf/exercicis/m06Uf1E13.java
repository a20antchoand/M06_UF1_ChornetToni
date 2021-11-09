package m06.uf.exercicis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* UF1    Accés a dades
 * Autor: Toni Chornet Anducas
 * Data : 15/10/2021
 * Facts: Mou el fitxer de l'usuari d'una ruta A a una ruta B
 * */

public class m06Uf1E13 {
	
	public static void  main(String args[]) {
		
		Scanner s = null;
		
		try {
			System.out.println("La carpeta de treball es: " + System.getProperty("user.dir"));
			File f = new File("enters.txt");
			s = new Scanner(f);
	        System.out.println("Fitxer obert correctament.");
	        System.out.println("El numero mes alta és: " + notaMaxima(s));
	        System.out.println("El numero mes baix és: " + notaMinima(s));
	        mitjana(s);
	        
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
	}

	public static void mitjana(Scanner s) throws FileNotFoundException {
		while (s.hasNextInt()) {
        	System.out.println(s.nextInt());
        }
		
	}

	public static int notaMinima(Scanner s) {
        int min = 0;
        int num;
		while (s.hasNextInt()) {
			num = s.nextInt();
        	if (num < min) {
        		min = num;
        	}
        }
		
		return min;
	}

	public static int notaMaxima(Scanner s) {
        int max = 0;
        int num;
		while (s.hasNextInt()) {
			num = s.nextInt();
        	if (num > max) {
        		max = num;
        	}
        }
		
		return max;
	}
	
}
