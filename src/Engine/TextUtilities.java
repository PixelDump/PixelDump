package Engine;
import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.PrintWriter;
	import java.io.UnsupportedEncodingException;
	import java.util.Scanner;


public class TextUtilities {
	
		void Create(String name, String text) throws FileNotFoundException, UnsupportedEncodingException{
			
			PrintWriter writer = new PrintWriter(name + ".txt", "UTF-8");
			writer.println(text);
			writer.close();
			
		}
			
		@SuppressWarnings("resource")
		String Read(String read) throws FileNotFoundException{
			return (new Scanner(new File(read))).useDelimiter("\\A").next();
		}
}
