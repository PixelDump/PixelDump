package InspectorGui;

import javax.swing.JLabel;

import Utils.TextDefaults;

public class _Vector2Var extends GenericVariable{

	public _Vector2Var(String n){
		name = n;

		this.add(TextDefaults.MakeText(name+": "));
		this.add(x);
		this.add(new JLabel("   ")); //to fill space
		this.add(y);
	}
}
