package InspectorGui;

import java.awt.Dimension;

import Utils.TextDefaults;

public class _DoubleVar extends GenericVariable{


	public TextDefaults doubleText = new TextDefaults("Double");
	
	public _DoubleVar (String n){
		name = n;
		
		doubleText.setPreferredSize(new Dimension(50,17));
		doubleText.setMaximumSize(new Dimension(100,17));

		this.add(TextDefaults.MakeText(name+": "));
		this.add(doubleText);
	}
}