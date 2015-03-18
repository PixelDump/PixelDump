package Utils;

import java.util.ArrayList;
import java.util.List;

public class GenericObject {
	public String name;
/**
 * constructs a generic object
 * @param name
 */
	public GenericObject(String name) {
		this.name = name;
		init();
	}
	/**
	 * constructs a generic object
	 * @param name
	 */
	public GenericObject() {
		init();
	}
/**
 * Assigns name of object on startup.
 */
	public void init() {
		if (name == null) {
			name = "Object";
		}
	}
/**
 * All scripts components etc on this Game Object.
 */
	public ArrayList<Component> Components = new ArrayList<Component>();
/**
 * Adds a given component to this GameObject.
 * @param c - component to add.
 */
	public void AddComponent(Component c) {
		Components.add(c);
	}

	public void AddScript(ScriptBase script) {

		Components.add(script);
	}
	public void AddAllScripts(List<ScriptBase> scripts) {
		for(ScriptBase script:scripts)
		Components.add(script);
	}
}
