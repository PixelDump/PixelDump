package Utils;
import Engine.GameObject;
import Engine.Main;

import com.mrjaffesclass.apcs.messenger.MessageHandler;
import com.mrjaffesclass.apcs.messenger.Messenger;


public abstract class ScriptBase extends Component implements MessageHandler {

	Messenger m ;
	
	protected GameObject gameObject;
	
	protected Transform transform;
	
	private boolean canUpdate =true;
	
	protected boolean PlayInEditMode =false;
	
	public ScriptBase(String name){
		super(name);
		m = Main.getMessenger();
		m.subscribe("Update", this);
		m.subscribe("Start", this);
		
	}
	
	
	public void setParent(GameObject parent){
		this.gameObject= parent;
		transform=gameObject.transform;
	}
	
	@Override
	public void messageHandler(String messageName, Object messagePayload) {
		switch(messageName ){
		case "Update":if(canUpdate&&(PlayInEditMode||Main.PlayMode)) {Update();}break;
		case "Start" : Start ();break;
		
		}
	}
	
	public void Start(){}
	
	public void Update(){}
	
	public void UnLink(){
		canUpdate=false;
	}
	
}
