package m06.uf.exercicis;
import java.io.*;

/* * * * * * * * * * * *
 * UF1    Accés a dades
 * Autor: Toni Chornet Anducas
 * Data : 27/09/2021
 * Facts: Demana fitxer i directori, mostra la info dels 2 
 * * * * * * * * * * * */

public class m06Uf1E1 {
	public static void main(String args[]) {
  
            // Creem 2 objectes File, un per un fitxer i un per un directori.
            File f = new File("fitxer.txt");
            File d = new File("src");
  
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
            
            System.out.println("Implementat per comit del punt 5.4");
	}
}

