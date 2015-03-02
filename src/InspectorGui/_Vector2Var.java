package InspectorGui;

import java.awt.Dimension;

import javax.swing.JLabel;

import Utils.Component;
import Utils.TextDefaults;
import Utils.Transform;
import Utils.Vector2;

public class _Vector2Var extends GenericVariable{


	public TextDefaults x = new TextDefaults("Double");
	public TextDefaults y = new TextDefaults("Double");
	
	
	public _Vector2Var(String n, Component c){
		name = n;

		compDupe = c;

		x.setPreferredSize(new Dimension(30,17));
		x.setMaximumSize(new Dimension(50,17));
		y.setPreferredSize(new Dimension(30,17));
		y.setMaximumSize(new Dimension(50,17));
		
		this.add(TextDefaults.MakeText(name+": "));
		this.add(x);
		this.add(new JLabel("   ")); //to fill space
		this.add(y);
	}
	
	public void pullVariable(){
		if(getVec2()!=null){
		if(!x.isFocused()&&!x.getText().equals(""+getVec2().x)){
			x.setText(""+getVec2().x);
		}
		if(!y.isFocused()&&!y.getText().equals(""+getVec2().y)){
			y.setText(""+getVec2().y);
		}
		}
		
	}
	Vector2 getVec2 (){
		
		try {
			return (Vector2)((compDupe).getClass().getField(name).get(compDupe));
		} catch (IllegalArgumentException | IllegalAccessException
				| NoSuchFieldException | SecurityException e) {
		}
		return null;
	}
}
