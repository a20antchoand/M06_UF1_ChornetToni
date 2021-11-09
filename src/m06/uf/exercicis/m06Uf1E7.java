package m06.uf.exercicis;
import java.io.File;
import java.util.Scanner; 

/* UF1    Accés a dades
 * Autor: Toni Chornet Anducas
 * Data : 29/09/2021
 * Facts: Demana a l'usuari un directori que vulgui crear amb ruta absoluta
 * */

public class m06Uf1E7 {
	public static void main(String args[]) {
		  
		Scanner s = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Indicate the absolute path: ");
		
        File f = new File(s.nextLine());
        s.close();

        if (f.mkdir()) {
        	System.out.println("Directory created succesfully.");

        } else {
        	System.out.println("Can't create the directory, because it exists.");
        }
	}
}
