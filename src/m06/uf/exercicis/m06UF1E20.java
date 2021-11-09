package m06.uf.exercicis;


/**
 * @author angela
 *
 */

import java.io.*;
import java.util.*;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

public class m06UF1E20 {
	
	public static void main(String[] args) {
	
		try {
			
			SAXBuilder saxBuilder = new SAXBuilder();
	        Document document = saxBuilder.build("src" + File.separator + "class.xml");
	        System.out.println("Root element :" + document.getRootElement().getName());
	        Element classElement = document.getRootElement();
	        
	        List<Element> studentList = classElement.getChildren();
	         System.out.println("----------------------------");

	         for (int temp = 0; temp < studentList.size(); temp++) {    
	            Element student = studentList.get(temp);
	            System.out.println("\nCurrent Element :" 
	               + student.getName());
	            Attribute attribute =  student.getAttribute("rollno");
	            System.out.println("Student roll no : " 
	               + attribute.getValue() );
	            System.out.println("First Name : "
	               + student.getChild("firstname").getText());
	            System.out.println("Last Name : "
	               + student.getChild("lastname").getText());
	            System.out.println("Nick Name : "
	               + student.getChild("nickname").getText());
	            System.out.println("Marks : "
	               + student.getChild("marks").getText());
	         }
	        
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
	
	


