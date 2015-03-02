package InspectorGui;

import Utils.TextDefaults;

public class _DoubleVar extends GenericVariable{

	public _DoubleVar (String n){
		name = n;

		this.add(TextDefaults.MakeText(name+": "));
		this.add(doubleText);
	}
}