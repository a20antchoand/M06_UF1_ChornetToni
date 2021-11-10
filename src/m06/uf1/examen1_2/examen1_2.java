package m06.uf1.examen1_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
		llegirFitxers();
	}

	public void llegirFitxers() throws IOException {
		File dEmpleats = new File("empleats");
		String linea, fraseFinal = "";
		int cont = 0;
		BufferedReader br = null;
		List<File> llistaFitxers = Arrays.asList(dEmpleats.listFiles());
		try {

			for (File f : llistaFitxers) {
				br = new BufferedReader(new FileReader(f));
				while ((linea = br.readLine()) != null) {
					if (!linea.contains(":")) {
						fraseFinal += linea;
					} else if (linea.contains("CARREC:")) {
						fraseFinal += linea.replace("CARREC:", ", ");
					} else if (linea.contains("DEPARTAMENT:")) {
						fraseFinal += linea.replace("DEPARTAMENT:", ", ");
					} else if (linea.contains("NSS:")) {
						fraseFinal += linea.replace("NSS:", ", ");
					}
				}
				escriureFitxers(fraseFinal);
				cont++;
				fraseFinal = "";
			}
			
			LOG.addLine("S'han escrit a " + RESULTAT.getName() + " " + cont + " lineas.");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			br.close();
		}
	}

	public void escriureFitxers(String frase) {
		try {
			FileWriter fw = new FileWriter(RESULTAT, true);
			fw.append(frase + "\n");
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
