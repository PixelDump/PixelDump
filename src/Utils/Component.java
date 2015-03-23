package Utils;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**Organizes a script by its variables
 * 
 * @author Barry
 *
 */
public abstract class Component {

	public String name;
	private Field[] variables;
	
	/**Initializes a new Component with passed in name
	 */
	Component(String name){
		this.name =name;
		 
	}
	


	/**Returns variables in a component, if any
	 */
	public Field[] getVariables() {
		try{
			Class<?> act = Class.forName(name);
			variables = act.getFields();
			return variables;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
	
}
