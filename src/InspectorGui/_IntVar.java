package InspectorGui;

import Utils.TextDefaults;


public class _IntVar extends GenericVariable{

	public _IntVar(String n){
		name = n;

		this.add(TextDefaults.MakeText(name+": "));
		this.add(integerText);
	}
}
