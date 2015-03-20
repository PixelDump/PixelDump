package Utils;
import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.PrintWriter;
	import java.io.UnsupportedEncodingException;
	import java.util.Scanner;

/**Functionality for text editing
 * 
 * @author Jacob
 *
 */
public class TextUtilities {
	
	/**Creates a new text file
	 * 
	 * @param name - Name of the file
	 * @param text - Contents of the file
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
		void Create(String name, String text) throws FileNotFoundException, UnsupportedEncodingException{
			
			PrintWriter writer = new PrintWriter(name + ".txt", "UTF-8");
			writer.println(text);
			writer.close();
			
		}
			
		/**Reads a file's contents
		 * 
		 * @param fileName - Name of the file to read
		 * @return
		 * @throws FileNotFoundException
		 */
		@SuppressWarnings("resource")
		String Read(String fileName) throws FileNotFoundException{
			return (new Scanner(new File(fileName))).useDelimiter("\\A").next();
		}
}
