package Utils;



public class GenericObject {
	
	
	private List<Component> Components = new ArrayList<Component>();

	public void AddComponent(Component c) {
		Components.add(c);
	}

	public void AddScript(ScriptBase script) {

		Components.add(script);
	}
}
