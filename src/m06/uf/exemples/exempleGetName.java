package m06.uf.exemples;
import java.io.*;

public class exempleGetName {
	public static void main(String args[])
    {
  
        // try-catch block to handle exceptions
        try {
  
            // Create a file object
            File f = new File("c:\\users\\programsToni.txt");
  
            // Get the Name of the given file f
            String Name = f.getName();
  
            // Display the file Name of the file object
            System.out.println("File Name : " + Name);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
