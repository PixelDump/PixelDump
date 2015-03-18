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
	/**
	 * Is this script going to run when the game is not playing?
	 */
	protected boolean PlayInEditMode =false;
	
	/**
	 * Constucts a new Script to be used only by the engine.
	 * @param name - name of script being constructed.
	 */
	public ScriptBase(String name){
		super(name);
		m = Main.getMessenger();
		m.subscribe("Update", this);
		m.subscribe("Start", this);
		
	}
	
	/**
	 * sets the parent of this gameObject.
	 * @param parent - GameObject to be set as parent.
	 */
	public void setParent(GameObject parent){
		this.gameObject= parent;
		transform=gameObject.transform;
	}
	
	@Override
	public void messageHandler(String messageName, Object messagePayload) {
		switch(messageName ){
		case "Update":if(canUpdate) {Update();}break;
		case "Start" : Start ();break;
		
		}
	}
	/**
	 * Function called once on start up to handle initialization of scripts. 
	 */
	public void Start(){}
	/**
	 * Function called every frame of the main gameloop.
	 */
	public void Update(){}
	/**
	 * Cuts off update function of script.
	 */
	public void UnLink(){
		canUpdate=false;
	}
	
}
