package InspectorGui;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Engine.Main;
import Utils.Component;

import com.mrjaffesclass.apcs.messenger.MessageHandler;
import com.mrjaffesclass.apcs.messenger.Messenger;

	

public class GenericVariable extends JPanel implements MessageHandler{
	
	public String name;
	Messenger m;
	protected Component compDupe;
	
	GenericVariable(){
		
		m = Main.getMessenger();
		m.subscribe("Update", this);
		this.removeAll();
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		
	}
	
	public void pullVariable(){
	}
	
	public void pushVariable(){
		
	}
	
	public String getName(){
		return name;
	}

	@Override
	public void messageHandler(String messageName, Object messagePayload) {
		switch(messageName){
		case "Update":
			pullVariable();
			break;
		}
		
	}
	
}
