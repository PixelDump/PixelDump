package InspectorGui;

import java.awt.Dimension;

import Utils.Component;
import Utils.TextDefaults;

public class _FloatVar extends GenericVariable{

	public TextDefaults floatText = new TextDefaults("Float");
	
	public _FloatVar (String n, Component c){
		name = n;
		
		compDupe = c;
		
		floatText.setPreferredSize(new Dimension(50,17));
		floatText.setMaximumSize(new Dimension(100,17));

		this.add(TextDefaults.MakeText(name+": "));
		this.add(floatText);
	}
	
	public void updateVariable(){
		try{
		//game->text
		if(!floatText.isFocused() && !floatText.getText().equals(""+getFloat().toString()) && getFloat()!=null && !floatText.enter)
			floatText.setText(""+getFloat());
	
		//text->game
		if(floatText.enter){
				floatText.enter = false;
				(compDupe.getClass().getField(name)).set(compDupe, 
						Float.parseFloat((floatText.getText())));
			}
		}
		
		catch(Exception e){
			}
		}
	
	
	Float getFloat (){
	
	try {
		return ((float) (compDupe).getClass().getField(name).get(compDupe));
		
	} catch (IllegalArgumentException | IllegalAccessException
			| NoSuchFieldException | SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}
	
}