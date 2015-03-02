package InspectorGui;

import java.awt.Dimension;

import Utils.Component;
import Utils.TextDefaults;
import Utils.Vector2;

public class _StringVar  extends GenericVariable{


	public TextDefaults stringText = new TextDefaults("String");
	
	
	
	public _StringVar(String n, Component c){
		name = n;
		
		compDupe=c;
		
		stringText.setPreferredSize(new Dimension(50,17));
		stringText.setMaximumSize(new Dimension(100,17));

		this.add(TextDefaults.MakeText(name+": "));
		this.add(stringText);
	}
	public void updateVariable(){
		try{
		
		//text->game
		if(stringText.enter){
				stringText.enter = false;
				(compDupe.getClass().getField(name)).set(compDupe, 
						stringText.getText());
			}
			
		//game->text
		if(!stringText.isFocused() && !stringText.getText().equals(""+getString()) && getString()!=null){
			
			stringText.setText(""+getString());
		}
		
		
		}
		catch(Exception e){
		}
	}
	
	String getString (){
	
	try {
		return (String)((compDupe).getClass().getField(name).get(compDupe));
		
	} 
	catch (IllegalArgumentException | IllegalAccessException
			| NoSuchFieldException | SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}
}
