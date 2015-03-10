package InspectorGui;

import java.awt.Dimension;
import java.lang.reflect.Field;

import Utils.Component;
import Utils.TextDefaults;

/**Inspector Variable gui for types int, String, Double and Float
 * 
 * @author Jacob
 *
 */
public class _CheckVar extends GenericVariable{

	public TextDefaults text;
	
	/**Creates a new GenericVariable displaying a text box (with limited input) tied to the passed in Value 
	 * 
	 * @param field - Field to monitor
	 * @param c - Component that the field belongs to
	 */
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
	
	/**Sets text area to variable value and vice versa
	 * 
	 */
	public void updateVariable(){
		try{
		
		//text->game
		if(text.enter){
				text.enter = false;
				switch(f.getType().toString()){
				case "int":
					f.set(compDupe, Integer.parseInt(text.getText()));
					break;
				case "class java.lang.String":
					f.set(compDupe, text.getText());
					break;
				case "class java.lang.Double":
					f.set(compDupe, Double.parseDouble(text.getText()));
					break;
				case "double":
					f.set(compDupe, Double.parseDouble(text.getText()));
					break;
				case "float":
					f.set(compDupe, Float.parseFloat(text.getText()));
					break;
				case "class java.lang.Float":
					f.set(compDupe, Float.parseFloat(text.getText()));
					break;
				default:
					System.out.println("Invalid variable type (_CheckVar) \"" + name + "\"" );
				}
			}
			
		//game->text
		if(!text.isFocused() && !text.getText().equals(""+getExisting().toString()) && getExisting()!=null){
			
			text.setText(""+getExisting());
		}
		
		
		}
		catch(Exception e){
		}
	}
	
	/**
	 * 
	 * @return The field's value at at instance
	 */
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
