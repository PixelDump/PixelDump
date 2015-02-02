package Engine;

import Utils.ScriptBase;

public class testScript extends ScriptBase {

	testScript() {
		super("testScript");
	}
	
	
	public void Update(){
		
		transform.position.x +=1;
		
		gameObject.name();
		
		//System.out.println(transform.position.y);
	}
	

}
