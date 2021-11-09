package m06.uf.exercicis;
import java.io.File;
import java.util.Scanner; 

/* UF1    Accés a dades
 * Autor: Toni Chornet Anducas
 * Data : 27/09/2021
 * Facts: Demana una ruta absoluta, mostra si es fitxer o directori i certa informació depenent de que sigui. 
 * */

public class m06Uf1E6 {
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
        	if (f.isDirectory()) {
        		System.out.println(f + " is a directory.");
        		System.out.println("Parent: " + f.getParent());
        		File[] subCarpetes = f.listFiles();
        		for (int i = 0; i < subCarpetes.length; i++) {
        			if (subCarpetes[i].isDirectory()) {
        				System.out.println("· [DIR]" + subCarpetes[i]);
        			} else {
        				System.out.println("· [FIL]" + subCarpetes[i]);
        			}
        		}
        	} else {
        		System.out.println(f + " is a file.");
        	}
        } else {
        	System.out.println("File not found.");
        }
	}
}
