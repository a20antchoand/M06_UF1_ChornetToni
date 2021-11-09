package m06.uf.exercicis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* UF1    Accés a dades
 * Autor: Toni Chornet Anducas
 * Data : 15/10/2021
 * Facts: Mou el fitxer de l'usuari d'una ruta A a una ruta B
 * */

public class m06Uf1E18 {

	public static void main(String args[]) {

		String nomFitxer = "fitxer.txt";
		File fitxer = new File(nomFitxer);
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(fitxer));

			for (int i = 0; i < 115; i++) {
				bw.write("Linia " + i + ": " + "MEC\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
