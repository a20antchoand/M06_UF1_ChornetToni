package m06.uf.exemples;
import java.io.*;

public class exempleGetParent {
	  public static void main(String args[])
	    {
	  
	        // try-catch block to handle exceptions
	        try {
	  
	            // Create a file object
	            File f
	                = new File("c:\\users\\program.txt");
	  
	            // Get the Parent
	            // of the given file f
	            String Parent = f.getParent();
	  
	            // Display the file Parent
	            // of the file object
	            System.out.println("File Parent : "
	                               + Parent);
	        }
	        catch (Exception e) {
	            System.err.println(e.getMessage());
	        }
	    }
}
