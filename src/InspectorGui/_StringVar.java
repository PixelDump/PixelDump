package InspectorGui;

import Utils.TextDefaults;

public class _StringVar  extends GenericVariable{

	public _StringVar(String n){
		name = n;

		this.add(TextDefaults.MakeText(name+": "));
		this.add(text);
	}
}
