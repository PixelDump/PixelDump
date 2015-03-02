package InspectorGui;

import javax.swing.JRadioButton;

import Utils.TextDefaults;

public class _BooleanVar extends GenericVariable{

	public JRadioButton radioButton = new JRadioButton();
	
	public _BooleanVar(String n){
		name = n;

		this.add(TextDefaults.MakeText(name+": "));
		this.add(radioButton);
	}
	
}
