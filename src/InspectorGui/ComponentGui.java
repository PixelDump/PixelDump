package InspectorGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Utils.Component;
import Utils.ScriptCompiler;


public class ComponentGui extends JPanel{
	
	
	
	ComponentGui(Component c){
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
		//gets fields
		Field[] fields = getFields(c.name);
		ArrayList<String> respectiveType = new ArrayList<String>();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//makes new instance of variable (using name) for each
		//(Later on, use the fields and instance fields to update variable from text or update text from variable)
		//(Later on, don't just filter out "name" variables, that's fucked up)
		if(fields!=null){
		for(int x = 0; x < fields.length; x++){
			
			if(!fields[x].getName().equals("name")){
				
			switch(fields[x].getType().toString()){
				case "int":
					this.add(new _IntVar(fields[x].getName()));
					break;
				case "class java.lang.Boolean":
					this.add(new _BooleanVar(fields[x].getName()));
					break;
				case "boolean":
					this.add(new _BooleanVar(fields[x].getName()));
					break;
				case "class Utils.Vector2":
					this.add(new _Vector2Var(fields[x].getName()));
					break;
				case "class java.lang.String":
					this.add(new _StringVar(fields[x].getName()));
					break;
				case "class java.lang.Double":
					this.add(new _DoubleVar(fields[x].getName()));
					break;
				case "float":
					this.add(new _DoubleVar(fields[x].getName()));
					break;
				default:
					System.out.println("Invalid data type from "+c.name+" (ComponentGui): " + fields[x].getType().toString() + "\nName: " +fields[x].getName());
					break;
				}
				
			}
			this.add(Box.createRigidArea(new Dimension(1,7)));
		}	
		this.setBorder(BorderFactory.createTitledBorder(c.name + ": "));
		}
		
		
	}
	
	
	static Field[] getFields(String name){
			try {
				   switch(name){
				   case "Transform":
					   return Class.forName("Utils."+name).getFields();
				   case "Renderer":
					   return null;
				   default:
					   return ScriptCompiler.getPlayerClass(name).getFields();//Class.forName("_Scripts."+name).getFields();
				   }
			}
				   catch (IllegalArgumentException | SecurityException
		     | ClassNotFoundException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		   return null;
		  }
	
	
	
	static String getFieldType(String name, int index) {
		
		   try {
		   switch(name){
		   case "Transform":
			   return Class.forName("Utils."+name).getFields()[index].getType().getName();
		   default:
			   return Class.forName("_Scripts."+name).getFields()[index].getType().getName();
		   }
		    
			   
		   } catch (IllegalArgumentException | SecurityException
		     | ClassNotFoundException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		   return null;

		  }
}
