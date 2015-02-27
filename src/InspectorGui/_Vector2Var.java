package InspectorGui;

import javax.swing.JLabel;

import Renderer.UI;

public class _Vector2Var extends GenericVariable{

	public _Vector2Var(String n){
		name = n;

		this.add(UI.MakeText(name+": "));
		this.add(x);
		this.add(new JLabel("   ")); //to fill space
		this.add(y);
	}
}
