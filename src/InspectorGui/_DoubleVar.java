package InspectorGui;

import java.awt.Dimension;

import Utils.Component;
import Utils.TextDefaults;
import Utils.Vector2;

public class _DoubleVar extends GenericVariable{


	public TextDefaults doubleText = new TextDefaults("Double");
	
	public _DoubleVar (String n, Component c){
		name = n;
		
		compDupe = c;
		
		doubleText.setPreferredSize(new Dimension(50,17));
		doubleText.setMaximumSize(new Dimension(100,17));

		this.add(TextDefaults.MakeText(name+": "));
		this.add(doubleText);
	}
	
	public void updateVariable(){
		try{
		//game->text
		if(!doubleText.isFocused() && !doubleText.getText().equals(""+getDouble().toString()) && getDouble()!=null && !doubleText.enter)
			doubleText.setText(""+getDouble());
	
		//text->game
		if(doubleText.enter){
			
				doubleText.enter = false;
				(compDupe.getClass().getField(name)).set(compDupe, 
						Double.parseDouble(doubleText.getText()));
			}
		}
		
		catch(Exception e){
				e.printStackTrace();
			}
		}
	
	
	Object getDouble (){
	
	try {
			return (Double)(compDupe).getClass().getField(name).get(compDupe);
		
	} catch (IllegalArgumentException | IllegalAccessException
			| NoSuchFieldException | SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}
	
}