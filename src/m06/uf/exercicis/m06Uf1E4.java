package m06.uf.exercicis;
import java.io.File;
import java.util.Scanner; 

/* UF1    Accés a dades
 * Autor: Toni Chornet Anducas
 * Data : 27/09/2021
 * Facts: Demana una ruta absoluta, mostra si es fitxer o directori i certa informació depenent de que sigui. 
 * */

public class m06Uf1E4 {
	public static void main(String args[]) {
		  
		Scanner s = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Indicate the absolute path: ");
		
        File f = new File(s.nextLine());
        s.close();
        String nameFile = f.getName();
        String absPathFile = f.getAbsolutePath();
        
        if (f.exists()) {
        	if (f.isDirectory()) {
        		System.out.println(f + " is a directory.");
        		System.out.println("Parent: " + f.getParent());
        	} else {
        		System.out.println(f + " is a file.");
        	}
        	System.out.println("File absolute path : " + absPathFile);
        	System.out.println("File Name : " + nameFile);
        } else {
        	System.out.println("File not found.");
        }
	}
}
