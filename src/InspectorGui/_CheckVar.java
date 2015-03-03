package InspectorGui;

import java.awt.Dimension;
import java.lang.reflect.Field;

import Utils.Component;
import Utils.TextDefaults;

public class _CheckVar extends GenericVariable{

	public TextDefaults text;
	
	public _CheckVar(Field field, Component c){
		 f=field;
		 name = f.getName();
		 compDupe = c;
		
		text = new TextDefaults(f.getType().toString());
		
		text.setPreferredSize(new Dimension(50,17));
		text.setMaximumSize(new Dimension(100,17));
		
		this.add(TextDefaults.MakeText(name+": "));
		this.add(text);
		
	}
	
	public void updateVariable(){
		try{
		
		//text->game
		if(text.enter){
				text.enter = false;
				f.set(compDupe, text.getText());
			}
			
		//game->text
		if(!text.isFocused() && !text.getText().equals(""+getExisting().toString()) && getExisting()!=null){
			
			text.setText(""+getExisting());
		}
		
		
		}
		catch(Exception e){
		}
	}
	
	Object getExisting (){
		
		try {
			return f.get(compDupe);
			
		} 
		catch (IllegalArgumentException | IllegalAccessException
				| SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
