package Engine;

import Utils.ScriptBase;

public class testScript extends ScriptBase {

	public testScript() {
		super("testScript");
	}
	
	
	public void Update(){
		
		transform.position.x +=1;
		transform.position.y +=1;
		//gameObject.name();
		
	//	System.out.println("testing");
	}
	

}
