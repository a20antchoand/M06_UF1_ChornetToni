package m06.uf.exercicis;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/* UF1    Accés a dades
 * Autor: Toni Chornet Anducas
 * Data : 15/10/2021
 * Facts: Mou el fitxer de l'usuari d'una ruta A a una ruta B
 * */

public class m06Uf1E17 {

	public static void main(String args[]) {

		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter("fitxer.txt"));
			for (int i = 0; i < 10; i++) {
				bw.write("Fila número: " + i + "\n");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}













