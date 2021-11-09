package m06.uf.exercicis;

import java.io.FileWriter;
import java.io.IOException;

/* UF1    Accés a dades
 * Autor: Toni Chornet Anducas
 * Data : 15/10/2021
 * Facts: Mou el fitxer de l'usuari d'una ruta A a una ruta B
 * */

public class m06Uf1E19 {

	public static void main(String args[]) {

		String nomFitxer = "fitxer.txt";
		FileWriter output = null;

		try {
			output = new FileWriter(nomFitxer);

			for (int i = 0; i < 115; i++) {
				output.write("Linia " + i + ": " + "asdfMEC\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
