package Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class ComponentCombo extends JComboBox{

	
	
	//This may need to be changed to find scripts from file locations?
	public ComponentCombo(){
		
		for(int x = 0; x<ScriptCompiler.PlayerScripts.size(); x++){
			this.addItem(makeObj(ScriptCompiler.PlayerScripts.get(x).getName()));
			System.out.println("here");
		}
		
		
		
	}
	
	private Object makeObj(final String item)  {
	     return new Object() { public String toString() { return item; } };
	   }
	
}
