package InspectorGui;

import java.awt.Dimension;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Utils.Component;
import Utils.ScriptCompiler;
import Utils.removeButton;

/**Edits a JPanel to contain all of a component's information.
 * 
 * @author Jacob
 *
 */
public class ComponentGui extends JPanel{
	
	public ArrayList<String> checkable = new ArrayList<String>(){{
		add("int");
		add("class java.lang.String");
		add("class java.lang.Double");
		add("double");
		add("float");
		add("class java.lang.Float");
		}};
	
	ComponentGui(Component c){
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//gets fields
		Field[] fields = getFields(c.name);
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
		//adding all variables
		if(fields!=null){
		for(int x = 0; x < fields.length; x++){
			
			try {
				Field f = fields[x];
			
			
			if(!f.getName().equals("name")){
				
				if(checkable.contains(f.getType().toString())){
					this.add(new _CheckVar(f, c));
				}
				else if(f.getType().toString().equals("class Utils.Vector2")){
					this.add(new _Vector2Var(f, c));
				}
				else if(f.getType().toString().equals("boolean") || f.getType().toString().equals("class java.lang.Boolean")){
					this.add(new _BooleanVar(f, c));
				}
				else{
					System.out.println("Invalid data type from "+c.name+" (ComponentGui): " + f.getType().toString() + "\nName: " + f.getName());
				}
			
			}
			
			} catch (SecurityException e) {
				e.printStackTrace();
			}
			this.add(Box.createRigidArea(new Dimension(1,7)));
		}	
		this.add(new removeButton(c));
		
		this.setBorder(BorderFactory.createTitledBorder(c.name + ": "));
		}
		
		
	}
	
	/**Returns the Fields of a Component (whose name is passed in).
	 * 
	 * @param name - name of the Component
	 * @return Array of fields
	 */
	public static Field[] getFields(String name){
			try {
				   switch(name){
				   case "Transform":
					   return Class.forName("Utils."+name).getFields();
				   case "Renderer":
					   return null;
				   default:
					   return ScriptCompiler.getPlayerClass(name).getFields();
				   }
			}
				   catch (IllegalArgumentException | SecurityException
		     | ClassNotFoundException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		   return null;
		  }
	
	
	/**Returns the type of field (based on the passed in name and class).
	 * 
	 * @param name - Name of Class
	 * @param index - Index of field to analyze
	 * @return
	 */
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
