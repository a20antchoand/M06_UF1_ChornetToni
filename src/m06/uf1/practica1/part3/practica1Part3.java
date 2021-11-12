package m06.uf1.practica1.part3;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class practica1Part3 {

	static File dLog;
	static File dDesti;
	static File dOrigen;
	static Log log = new Log();

	public static void main(String[] args) {
		try {
			Dades();
			Existeix();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Dades() {
		dOrigen = new File("Origen");
		dDesti = new File("Desti");
		dLog = new File("Logs");
	}

	public static void Existeix() throws IOException {
		boolean op = false;

		if (!dLog.exists()) {
			dLog.mkdir();
		}

		if (!dOrigen.exists()) {

			if (dOrigen.mkdir()) {
				log.addLine("S'ha creat la carpeta d'origen: " + dOrigen.getAbsolutePath() + "\n");
			} else {
				log.addLine("No s'ha pogut crear el directori " + dOrigen.getName() + "\n");
			}
		} else {
			log.addLine("El directori " + dOrigen.getName() + " existeix. \n");
			op = true;
		}

		if (!dDesti.exists()) {

			if (dDesti.mkdir()) {
				log.addLine("S'ha creat la carpeta de destí: " + dDesti.getAbsolutePath() + "\n");
			} else {
				log.addLine("No s'ha pogut crear el directori " + dDesti.getName() + "\n");
			}
		} else {
			log.addLine("El directori " + dDesti.getName() + " existeix. \n");
		}

		if (op) {
			conteFitxers();
		}
	}

	public static void conteFitxers() throws IOException {

		File[] fitxers = dOrigen.listFiles();
		int cont = 0;

		for (int i = 0; i < fitxers.length; i++) {

			if (fitxers[i].isFile() && extensio(fitxers[i])) {

				mou(fitxers[i]);
				cont++;

			} else if (fitxers[i].isDirectory()) {

				File[] fSubDir = fitxers[i].listFiles();

				if (fSubDir.length != 0) {

					log.addLine("A la subcarpeta " + fitxers[i].getName() + " hi han " + fSubDir.length + " fitxers.\n");

					for (int j = 0; j < fSubDir.length; j++) {

						if (extensio(fSubDir[j])) {
							mou(fSubDir[j]);
						}

					}

				}
			}
		}

		if (cont != 0) {
			log.addLine("S'imortaran " + cont + " fitxers de " + dOrigen + "\n");
		} else {
			log.addLine("No hi han fitxers a " + dOrigen.getName() + ". Finalitzant programa.\n");
			System.exit(0);
		}
	}

	public static boolean extensio(File fitxer) {
		boolean op = false;
		if (fitxer.getName().startsWith("Emp") && fitxer.getName().endsWith(".txt")) {
			op = true;
		}
		return op;
	}

	public static void mou(File fitxer) throws IOException {
		String nom;
		nom = comprobarDades(fitxer);
		try {
			if (fitxer.renameTo(new File(dDesti.getAbsolutePath() + File.separator + fitxer.getName()))) {
				log.addLine("S'ha mogut el fitxer " + fitxer.getName() + " de " + fitxer.length()
						+ "que conte les dades de " + nom + " a la carpeta " + dDesti.getAbsolutePath() + "\n");
			} else {
				log.addLine("o s'ha pogut moure el fitxer " + fitxer.getName() + "perque ja existeix.\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String comprobarDades(File fitxer) {
		BufferedReader br = null;
		String resultat = "";
		String linia;
		boolean nom = false;

		try {
			br = new BufferedReader(new FileReader(fitxer));

			while ((linia = br.readLine()) != null && !nom) {
				if (linia.contains("NOM:")) {
					resultat = linia.replace("NOM:", "");
					nom = true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return resultat;
	}
}