package Utils;
import Engine.GameObject;
import Engine.Main;

import com.mrjaffesclass.apcs.messenger.MessageHandler;
import com.mrjaffesclass.apcs.messenger.Messenger;

/**Framework for Player Scripts
 * 
 * @author Barry
 *
 */
public abstract class ScriptBase extends Component implements MessageHandler {

	Messenger m ;
	
	protected GameObject gameObject;
	
	protected Transform transform;
	
	private boolean canUpdate =true;
	
	protected boolean PlayInEditMode =false;
	
	/**Creates a new ScriptBase with specified name
	 */
	public ScriptBase(String name){
		super(name);
		m = Main.getMessenger();
		m.subscribe("Update", this);
		m.subscribe("Start", this);
		
	}
	
	/**Sets the script's parent GameObject (the object the the script functions on)
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
	
	public void Start(){}
	
	public void Update(){}
	
	public void UnLink(){
		canUpdate=false;
	}
	
}
