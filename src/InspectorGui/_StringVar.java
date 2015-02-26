package InspectorGui;

import Renderer.UI;

public class _StringVar  extends GenericVariable{

	public _StringVar(String n){
		name = n;

		this.add(UI.MakeText(name+": "));
		this.add(text);
	}
}
