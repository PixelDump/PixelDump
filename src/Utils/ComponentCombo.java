package Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

/**Creates a JComboBox with a list of all possible components.
 * 
 * @author Jacob
 *
 */
public class ComponentCombo extends JComboBox{

	
	
	/**Creates a JComboBox with a list of all possible components
	 * 
	 */
	public ComponentCombo(){
		
		for(int x = 0; x<ScriptCompiler.PlayerScripts.size(); x++){
			this.addItem(makeObj(ScriptCompiler.PlayerScripts.get(x).getName().substring(ScriptCompiler.PlayerScripts.get(x).getName().indexOf('.')+1)));
		}
		
		
		
	}
	
	/**Returns and object based on passed in String
	 * 
	 */
	private Object makeObj(final String item)  {
	     return new Object() { public String toString() { return item; } };
	   }
	
}
