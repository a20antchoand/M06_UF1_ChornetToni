package m06.uf1.examen1_2;

import java.io.File;
import java.io.IOException;

public class examen1_2 {

	final String RUTALOG = "logs";
	File DLOG = null;
	File RESULTAT = new File("resultats.txt");
	Log LOG = new Log(RUTALOG);

	public static void main(String[] args) throws IOException {
		examen1_2 examen = new examen1_2();
		examen.dades();
		examen.comprovarDirectori();
		
		
	}

	public void dades() {
		DLOG = new File(RUTALOG);
	}

	public boolean comprovarDirectori() throws IOException {

		if (!DLOG.exists()) {
			System.out.println("El directori " + DLOG.getAbsolutePath() + " no existeix.");
			crearDirectori();
		} else {
			LOG.addLine("El directori " + DLOG.getAbsolutePath() + " existeix.");
			crearFitxerResultat();
		}

		return true;
	}

	public void crearDirectori() throws IOException {
		if (DLOG.mkdir()) {
			LOG.addLine("S'ha creat el direcotri " + DLOG.getAbsolutePath());
			crearFitxerResultat();
		} else {
			LOG.addLine("No s'ha pogut crear el directori " + DLOG.getAbsolutePath());
			System.exit(0);
		}
	}

	public void crearFitxerResultat() throws IOException {
		if (!RESULTAT.exists()) {
			LOG.addLine("El fitxer resultat no existeix.");
			if (RESULTAT.createNewFile()) {
				LOG.addLine("S'ha creat el fitxer " + RESULTAT.getName());
			} else {
				LOG.addLine("No s'ha pogut crear el fitxer " + RESULTAT.getName());
				System.exit(0);
			}
		} else {
			LOG.addLine("El fitxer " + RESULTAT.getName() + " existeix.");
		}
	}

	public String llegirFitxers() {

		return "";
	}

	public void escriureFitxers() {

	}

}
