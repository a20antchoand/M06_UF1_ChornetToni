package m06.uf.exercicis;
import java.io.File;

/* UF1    Accés a dades
 * Autor: Toni Chornet Anducas
 * Data : 27/09/2021
 * Facts: Demana un fitxer i directori per ruta absoluta mitjançant el file.separator 
 * */

public class m06Uf1E2 {
	public static void main(String args[]) {
		  
        // Creem 2 objectes File, un per un fitxer i un per un directori.
        File f = new File(File.separator + "home" + File.separator + "ausias" + File.separator + "Escriptori" + File.separator + "DADES" + File.separator + "achornet" + File.separator + "fitxer.txt");
        File d = new File(File.separator + "home" + File.separator + "ausias" + File.separator + "Escriptori" + File.separator + "DADES" + File.separator + "achornet");

        // Emmagatzemem el nom i la ruta absoluta de cada objecte.
        String nameFile = f.getName();
        String absPathFile = f.getAbsolutePath();
        String nameDir = d.getName();
        String absPathDir = d.getAbsolutePath();
        
        // Mostrem els noms i absolute path
        System.out.println("File absolute path : " + absPathFile);
        System.out.println("File Name : " + nameFile);
        System.out.println("File Name : " + absPathDir);
        System.out.println("Dir Name : " + nameDir);
	}
}
