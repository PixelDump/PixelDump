package Utils;

import Engine.GameObject;
import Engine.Main;

import com.mrjaffesclass.apcs.messenger.MessageHandler;
import com.mrjaffesclass.apcs.messenger.Messenger;

/** Framework for Player Scripts
 * 
 * @author Barry
 *
 */
public class PScript extends Component  implements MessageHandler{

Messenger m ;
	
	protected GameObject gameObject;
	
	protected Transform transform;
	
	private boolean canUpdate =true;
	
	protected boolean PlayInEditMode =false;
	
	/**Creates a new script with passed in name
	 */
	public PScript(String name){
		super(name);
		m = Main.getMessenger();
		m.subscribe("Update", this);
		m.subscribe("Start", this);
		
	}
	
	/**Sets the script's parent to passed in GameObject
	 */
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
	
	/**Prevents the script from being updated
	 * 
	 */
	public void UnLink(){
		canUpdate=false;
	}

}
