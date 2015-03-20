package Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for the Generic "Object". 
 * @author barry
 *
 */
public class GenericObject {
	public String name;
/**
 * Constructs a generic object.
 * @param name - Name of object.
 */
	public GenericObject(String name) {
		this.name = name;
		init();
	}
	/**
	 * Constructs a generic object.
	 */
	public GenericObject() {
		init();
	}
/**
 * Stores Name into "name", field.
 */
	public void init() {
		if (name == null) {
			name = "Object";
		}
	}
/**
 * list of all scripts and other components on this object.
 */
	public ArrayList<Component> Components = new ArrayList<Component>();
/**
 * Adds component to component array.
 * @param c - component to add.
 */
	public void AddComponent(Component c) {
		Components.add(c);
	}
	/**
	 * Adds component to component array.
	 * @param script - script to add.
	 */
	public void AddScript(ScriptBase script) {

		Components.add(script);
	}
	
	/**
	 * Adds multiple scripts to the components list at once.
	 * @param scripts - list of scripts to add.
	 */
	public void AddAllScripts(List<ScriptBase> scripts) {
		for(ScriptBase script:scripts)
		Components.add(script);
	}
}
