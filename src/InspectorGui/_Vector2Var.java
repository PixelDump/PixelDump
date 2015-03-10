package InspectorGui;

import java.awt.Dimension;
import java.lang.reflect.Field;

import javax.swing.JLabel;

import Engine.Main;
import Utils.Component;
import Utils.TextDefaults;
import Utils.Transform;
import Utils.Vector2;

/**Inspector Variable gui for type Vector2
 * 
 * @author Jacob
 *
 */
public class _Vector2Var extends GenericVariable{


	public TextDefaults x = new TextDefaults("Double");
	public TextDefaults y = new TextDefaults("Double");
	
	/**Creates a new GenericVariable displaying two text boxes (with limited input) tied to the passed in Vector2
	 * 
	 * @param field - Field to monitor
	 * @param c - Component that the field belongs to
	 */
	public _Vector2Var(Field field, Component c){
		f = field;
		name = f.getName();
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
	
	/**Sets text area to variable value and vice versa
	 * 
	 */
	public void updateVariable(){
		try{
		//game->text
		if(getVec2()!=null && !(x.enter||y.enter)){
			if(!x.isFocused()&&!x.getText().equals(""+getVec2().x)){
				x.setText(""+getVec2().x);
			}
			if(!y.isFocused()&&!y.getText().equals(""+getVec2().y)){
				y.setText(""+getVec2().y);
			}
		}	
		
		//text->game
		if(x.enter||y.enter){
			try{
				x.enter = false;
				y.enter = false;
				f.set(compDupe, new Vector2(Double.parseDouble(x.getText()),Double.parseDouble(y.getText())));
			}
			catch(Exception e){
			}
		}
		}
		catch(Exception e){}
		
		
		
	}
	
	/**
	 * 
	 * @return The Vector2's value at at instance
	 */
	Vector2 getVec2 (){
		
		try {
			return (Vector2)(f.get(compDupe));
		} catch (IllegalArgumentException | IllegalAccessException
				| SecurityException e) {
		}
		return null;
	}
}
