package InspectorGui;

import Utils.TextDefaults;

public class _BooleanVar extends GenericVariable{

	public _BooleanVar(String n){
		name = n;

		this.add(TextDefaults.MakeText(name+": "));
		this.add(radioButton);
	}
	
}
