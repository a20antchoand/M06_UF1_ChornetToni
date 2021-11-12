/**
 * 
 */
package m06.uf.exercicis;
import java.io.PrintWriter;
import java.util.List;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * @author angela
 *
 */
public class m06Uf1E22 {
	
	private static org.jdom2.Document jdomDocument;
	
	public static void main(String[] args) {

		try {
			
			//Inicialitzem el parse XML
			SAXBuilder jdomBuilder = new SAXBuilder();
			jdomDocument = jdomBuilder.build("books.xml");

			//Obtenim l'arrel del document XML
			Element arrel = jdomDocument.getRootElement();
			
			//Obtenim el nom de l'element arrel
			System.out.println(arrel.getName());
			
			//Obtenim el primer fill de l'element arrel i el seu nom
			List<Element> llibres = arrel.getChildren();
			System.out.println(llibres.get(0).getName());
			
			/*OBTENIM EL CONTINGUT D'UN NODE*/
			
			//manera 1
			//Preguntar a un element pel contingut del seu fill
			
			String nomLlibre = llibres.get(0).getChildText("title");
			System.out.println(nomLlibre);
			
			//Manera 2
			//Obtenir el fill i al fill preguntar pel seu contingut
			
			Element titol = llibres.get(0).getChild("title");
			String nom2 = titol.getText();
			System.out.println(nom2);
			
			//Manera 3
			//Obtenir tots els fills d'un element
			
			for (Element e : llibres) {
				for (Element e2 : e.getChildren() ) {
					System.out.println(e2.getText());
				}
			}
			
			//Cerquem el titol d'un llibre pel nom del seu autor
			String nom = buscaNomLlibre("JK Rowling");
			System.out.println("El nom del llibre de JK Rowling és " + nom);
			
			//Afegim un llibre nou a la llibreria
			guardarLlibre("W.Shakespeare", "Hamlet", "1600");
			System.out.println("S'ha afegit el nou llibre a la llibreria");
		} catch (Exception e) {
			
		}
	         
	}

	private static void guardarLlibre(String autorN, String titolN, String anyN) {
		try {
			Element llibreria = jdomDocument.getRootElement();
			Element llibre = new Element ("book");
			llibreria.addContent(llibre);
			Element autor = new Element("author");
			autor.setText(autorN);
			llibre.addContent(autor);
			Element titol = new Element("title");
			titol.setText(titolN);
			llibre.addContent(titol);
			Element any = new Element("year");
			any.setText(anyN);
			llibre.addContent(any);
			
			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
			outputter.output(jdomDocument, new PrintWriter("books.xml"));
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		
	}

	private static String buscaNomLlibre(String nomAutor) {
		try {
			Element arrel = jdomDocument.getRootElement();
			List<Element> llibres = arrel.getChildren();
			String autor, titol;
			for (Element llibre:llibres) {
				autor = llibre.getChildText("author");
				if (autor.equals(nomAutor)) {
					titol = llibre.getChildText("title");
					return titol;
				}
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return null;
	}
	
}
