package Utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
/**
 * 
 * @author Barry and Jacob
 *
 */
public abstract class Component {
/**
 * The name of the component set in the constructor.
 */
	public String name;
	/**
	 * List of all field in this Component.
	 */
	private Field[] variables;
	
	
	
	Component(String name){
		this.name =name;
		 
	}
	

	/**
	 * Gets all fields in this component.
	 * @return All fields in this component.
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
