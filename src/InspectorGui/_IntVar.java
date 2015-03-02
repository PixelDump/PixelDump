package InspectorGui;

import java.awt.Dimension;

import Utils.Component;
import Utils.TextDefaults;


public class _IntVar extends GenericVariable{


	public TextDefaults integerText = new TextDefaults("Integer");
	
	
	
	public _IntVar(String n, Component c){
		name = n;
		
		compDupe=c;
		
		integerText.setPreferredSize(new Dimension(50,17));
		integerText.setMaximumSize(new Dimension(100,17));

		this.add(TextDefaults.MakeText(name+": "));
		this.add(integerText);
	}
	
	public void updateVariable(){
		try{
		//game->text
		if(!integerText.isFocused()&&!integerText.getText().equals(""+getInt())){
			integerText.setText(""+getInt());
		}
		
		//text->game
		if(integerText.enter){
			integerText.enter = false;
			(compDupe.getClass().getField(name)).set(compDupe, 
					integerText.getText());
		}
	
		}
	
		catch(Exception e){
		}
	}
	
	int getInt (){
		
		try {
			return (int)((compDupe).getClass().getField(name).get(compDupe));
		} catch (IllegalArgumentException | IllegalAccessException
				| NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		}
}
