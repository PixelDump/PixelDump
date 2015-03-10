package InspectorGui;

import java.lang.reflect.Field;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Engine.Main;
import Utils.Component;

import com.mrjaffesclass.apcs.messenger.MessageHandler;
import com.mrjaffesclass.apcs.messenger.Messenger;

	
/**Base class for each Component variable gui type; constructs universal variable gui attributes and the head overload for updateVariable 
 * 
 * @author Jacob
 *
 */
public class GenericVariable extends JPanel implements MessageHandler{
	
	public String name;
	Messenger m;
	protected Component compDupe;
	Field f;
	
	GenericVariable(){
		
		m = Main.getMessenger();
		m.subscribe("Update", this);
		this.removeAll();
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		
	}
	
	/**Calls all overloads of updateVariable in each type of GenericVariable.
	 * 
	 */
	public void updateVariable(){
	}
		
	/**Returns the field's name.
	 * 
	 */
	public String getName(){
		return name;
	}

	/**Runs updateVariable whenever "Update" message is put out.
	 * 
	 */
	@Override
	public void messageHandler(String messageName, Object messagePayload) {
		switch(messageName){
		case "Update":
			updateVariable();
			break;
		}
		
	}
	
}
