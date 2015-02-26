package InspectorGui;

import Renderer.UI;


public class _IntVar extends GenericVariable{

	public _IntVar(String n){
		name = n;

		this.add(UI.MakeText(name+": "));
		this.add(text);
	}
}
