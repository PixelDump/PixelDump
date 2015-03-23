package Utils;

import java.util.ArrayList;
import java.util.List;

/**Base framework for GameObjects
 * 
 * @author Barry
 *
 */
public class GenericObject {
	public String name;

	/**Creates a new GenericObject with passed in name
	 */
	public GenericObject(String name) {
		this.name = name;
		init();
	}

	public GenericObject() {
		init();
	}

	/**Initializes the GenericObject's name to "Object" temporarily
	 * 
	 */
	public void init() {
		if (name == null) {
			name = "Object";
		}
	}

	public ArrayList<Component> Components = new ArrayList<Component>();

	/**Adds passed in component to the GenericObject's Components ArrayList
	 */
	public void AddComponent(Component c) {
		Components.add(c);
	}

	/**Adds passed in script to the GenericObject's Components ArrayList
	 */
	public void AddScript(ScriptBase script) {

		Components.add(script);
	}
	
	/**Adds all scripts to the GenericObject's Components ArrayList
	 */
	public void AddAllScripts(List<ScriptBase> scripts) {
		for(ScriptBase script:scripts)
		Components.add(script);
	}
}
