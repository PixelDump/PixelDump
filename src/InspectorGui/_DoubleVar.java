package InspectorGui;

import Renderer.UI;

public class _DoubleVar extends GenericVariable{

	public _DoubleVar (String n){
		name = n;

		this.add(UI.MakeText(name+": "));
		this.add(text);
	}
}