package InspectorGui;

import Renderer.UI;

public class _BooleanVar extends GenericVariable{

	public _BooleanVar(String n){
		name = n;

		this.add(UI.MakeText(name+": "));
		this.add(radioButton);
	}
	
}
