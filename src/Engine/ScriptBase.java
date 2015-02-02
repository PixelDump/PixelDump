package Engine;
import com.mrjaffesclass.apcs.messenger.MessageHandler;
import com.mrjaffesclass.apcs.messenger.Messenger;


public abstract class ScriptBase extends Component implements MessageHandler {

	Messenger m ;
	
	protected GameObject gameObject;
	
	protected Transform transform;
	
	
	
	protected ScriptBase(String name){
		super(name);
		m = Main.getMessenger();
		m.subscribe("Update", this);
	}
	
	public void setParent(GameObject parent){
		this.gameObject= parent;
		transform=gameObject.transform;
	}
	
	@Override
	public void messageHandler(String messageName, Object messagePayload) {
		switch(messageName ){
		case "Update": Update();
		case "Start" : Start ();
		}
	}
	
	public void Start(){}
	
	public void Update(){}
	
	
	
}
