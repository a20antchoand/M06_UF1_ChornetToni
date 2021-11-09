package m06.uf.exercicis;
import java.io.File;
import java.util.Scanner; 

/* UF1    Accés a dades
 * Autor: Toni Chornet Anducas
 * Data : 27/09/2021
 * Facts: Demana per teclat la ruta absoluta d'un fitxer i mostra si existeix la seva informació 
 * */

public class m06Uf1E3 {
	public static void main(String args[]) {
		  
		Scanner s = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Indicate the absolute path: ");
		
        File f = new File(s.nextLine());
        s.close();
        String nameFile = f.getName();
        String absPathFile = f.getAbsolutePath();
        
        if (f.exists()) {
        	System.out.println("File absolute path : " + absPathFile);
        	System.out.println("File Name : " + nameFile);
        } else {
        	System.out.println("File not found.");
        }
	}
}
