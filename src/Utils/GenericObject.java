package Utils;

import java.util.ArrayList;
import java.util.List;



public class GenericObject {
	
	
	protected List<Component> Components = new ArrayList<Component>();

	public void AddComponent(Component c) {
		Components.add(c);
	}

	public void AddScript(ScriptBase script) {

		Components.add(script);
	}
}
