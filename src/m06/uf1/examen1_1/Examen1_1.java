package m06.uf1.examen1_1;

import java.io.File;

/* UF1    Accés a dades
 * Autor: Toni Chornet Anducas
 * Data : 27/10/2021
 * Facts: m06.uf1.examen1_1 UF1 M06 
 * */

/* Utilitzare la ruta com a una constatant per evitar fer feina
 * extra. aquestes constants es diran Origen i Desti.
 * */

public class Examen1_1 {

	// Creem dos variables constants ORIGEN i DESTI
	File ORIGEN = new File("OrigenExamen");
	File DESTI = new File("DestiExamen");
	static int MOGUT = 0;

	// Al ExamenMain cridem a la funció existeixDirectori() que ja s'encarrega de cridar
	// les altres funcions.
	public static void main(String[] args) {
		Examen1_1 e = new Examen1_1();
		e.existeixDirectori();
		if (MOGUT == 0) {
			System.out.println("\nNo s'han mogut fitxers.");
		}
	}

	// Comprova si existeixen els directoris, de no ser així crida ala funció
	// corresponent.
	public void existeixDirectori() {

		if (ORIGEN.exists()) {
			System.out.println(
					" El directori " + ORIGEN.getName() + " s'ha trobat a la ruta absoluta " + ORIGEN.getAbsolutePath());
		} else {
			crearDirectori(ORIGEN);
		}

		if (DESTI.exists()) {
			System.out.println(" El directori " + DESTI.getName() + " s'ha trobat a la ruta " + DESTI.getAbsolutePath());
		} else {
			crearDirectori(DESTI);
		}

		comprovarFitxers();

	}

	// S'encarrega de crear els directoris.
	public void crearDirectori(File Directori) {

		if (Directori.mkdir()) {
			System.out.println(" S'ha creat el directori " + Directori.getName() + " a la ruta absoluta "
					+ Directori.getAbsolutePath());
		} else {
			System.out.println(" No s'ha pogut creat el directori " + Directori.getName() + " a la ruta absoluta "
					+ Directori.getAbsolutePath() + ". Acaba l'execució del programa.");
			System.exit(1);
		}

	}

	// Comprova que tingui fitxers, mira si son fitxers o directoris
	public void comprovarFitxers() {

		File[] contingut = ORIGEN.listFiles();
		File[] fitxers = ORIGEN.listFiles();
		File[] subDirectoris = ORIGEN.listFiles();

		int contFitx = 0, contSubDir = 0;

		if (contingut.length > 0) {
			for (int i = 0; i < contingut.length; i++) {

				if (contingut[i].isFile()) {
					fitxers[contFitx] = contingut[i];
					contFitx++;
				} else if (contingut[i].isDirectory()) {
					subDirectoris[contSubDir] = contingut[i];
					contSubDir++;
				}

			}

			System.out.println(" El directori " + ORIGEN.getName() + " conte " + contFitx + " fitxers i " + contSubDir + " subdirectoris.");

			System.out.println("\n**********fitxers*********\n");

			for (int i = 0; i < contFitx; i++) {
				if (fitxers[i] != null) {
					System.out.println(" ./" + fitxers[i].getName());
				}
			}

			System.out.println("\n**************************\n");

			System.out.println("\n**********subdirectoris*********\n");

			for (int i = 0; i < contSubDir; i++) {
				if (subDirectoris[i] != null) {
					System.out.println(" ./" + subDirectoris[i].getName() + "/");
					File[] subFitxers = subDirectoris[i].listFiles();
					if (subFitxers.length > 0) {
						moureFitxers(subFitxers, subFitxers.length);
					}
				}
			}
			
			System.out.println("\n********************************");

		} else if (contingut.length == 0) {
			System.out.println(" El directori " + ORIGEN.getName() + " esta buit. No hi ha contingut per moure. Acaba l'execució del programa.");
			System.exit(0);
		}

		moureFitxers(fitxers, contFitx);
	}

	// S'encarga de moure els fitxers que acabin el ".xml" sigui de Origen o subdirectoris
	public void moureFitxers(File[] fitxers, int length) {

		for (int i = 0; i < length; i++) {
			if (fitxers[i].getName().endsWith(".xml")) {

				if (fitxers[i].renameTo(new File(DESTI.getAbsolutePath() + File.separator + fitxers[i].getName()))) {
					System.out.println("\nS'ha mogut el fitxer " + fitxers[i].getName());
					MOGUT++;
				} else {
					System.out.println("\nNo s'ha pogut moure el fitxer " + fitxers[i].getName());
				}
			}
		}

	}
}