package InspectorGui;

import Renderer.UI;

public class _Vector2Var extends GenericVariable{

	public _Vector2Var(String n){
		name = n;

		this.add(UI.MakeText(name+": "));
		this.add(text);
		this.add(text2);
	}
}
