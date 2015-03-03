package InspectorGui;

import java.lang.reflect.Field;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Engine.Main;
import Utils.Component;
import Utils.ScriptCompiler;

import com.mrjaffesclass.apcs.messenger.MessageHandler;
import com.mrjaffesclass.apcs.messenger.Messenger;

	

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
	
	public void updateVariable(){
	}
		
	public String getName(){
		return name;
	}

	@Override
	public void messageHandler(String messageName, Object messagePayload) {
		switch(messageName){
		case "Update":
			if(!ScriptCompiler.compiling)updateVariable();
			break;
		}
		
	}
	
}
