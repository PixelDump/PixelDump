package Utils;

import java.util.ArrayList;
import java.util.List;

public class GenericObject {
	public String name;

	public GenericObject(String name) {
		this.name = name;
		init();
	}

	public GenericObject() {
		init();
	}

	public void init() {
		if (name == null) {
			name = "Object";
		}
	}

	protected ArrayList<Component> Components = new ArrayList<Component>();

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
